package com.mall.mallproduct.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mall.mallproduct.entity.CategoryEntity;
import com.mall.mallproduct.service.CategoryService;
import com.common.utils.PageUtils;
import com.common.utils.R;



/**
 * 商品三级分类
 *
 * @author bobo
 * @email oneshark5@163.com
 * @date 2024-12-19 20:35:54
 */
@RestController
@RequestMapping("mallproduct/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     * @param params
     * @return
     */
    @RequestMapping("/list/tree")
    public R listTree(){
        List<CategoryEntity> entities = categoryService.listWithTree();
        return R.ok().put("page", entities);
    }



    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 删除
     * @RequestBody:获取请求体，必须发送POST请求
     * SpringMVC自动降请求体的数据（json），转为对应的对象
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        // 1、检查当前删除的菜单，是否被别的地方引用
		// categoryService.removeByIds(Arrays.asList(catIds));

        categoryService.removeMenuByIds(Arrays.asList(catIds)); // 批量删除方法
        return R.ok();
    }

}
