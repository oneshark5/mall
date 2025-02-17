package com.mall.mallorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageUtils;
import com.mall.mallorder.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author bobo
 * @email oneshark5@163.com
 * @date 2025-02-17 21:53:05
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

