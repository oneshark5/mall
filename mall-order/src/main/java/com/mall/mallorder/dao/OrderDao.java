package com.mall.mallorder.dao;

import com.mall.mallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author bobo
 * @email oneshark5@163.com
 * @date 2025-02-17 21:53:05
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
