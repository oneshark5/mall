package com.mall.mallproduct.service.impl;
import com.common.utils.PageUtils;
import com.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.mall.mallproduct.dao.CategoryDao;
import com.mall.mallproduct.entity.CategoryEntity;
import com.mall.mallproduct.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        /**
         * bobo
         * 1.筛选一级菜单
         * 2.给一级菜单设置子菜单
         *     递归设置子菜单
         */
        //2、组装成父子的树形结构
        //2.1）、找到所有的一级分类，给children设置子分类
        return entities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .peek(menu -> menu.setChildren(getChildless(menu, entities)))
                .sorted(Comparator.comparingInt(menu -> (menu.getSort()) == null ? 0 : menu.getSort()))
                .collect(Collectors.toList());
    }

    /**
     * 批量删除方法
     * @param asList
     */
    @Override
    public void removeMenuByIds(List<Long> asList) {
        // TODO 检查当前删除的菜单，是否被别的低副引用

        // 实际删除
        baseMapper.deleteBatchIds(asList);

        // 常用的是逻辑删除（设置标志位，表示此处为删除）


    }

    /**
     * 递归查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildless(CategoryEntity root, List<CategoryEntity> all) {
        return all.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid().equals(root.getCatId()))
                .peek(categoryEntity -> {
                    // 找子菜单
                    categoryEntity.setChildren(getChildless(categoryEntity, all));
                })
                .sorted(Comparator.comparingInt(menu -> (menu.getSort() == null ? 0 : menu.getSort())))
                .collect(Collectors.toList());


    }

}