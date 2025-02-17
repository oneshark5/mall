package com.mall.mallproduct.dao;

import com.mall.mallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author bobo
 * @email oneshark5@163.com
 * @date 2024-12-19 19:37:51
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
