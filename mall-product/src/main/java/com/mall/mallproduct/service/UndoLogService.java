package com.mall.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.common.utils.PageUtils;
import com.mall.mallproduct.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author bobo
 * @email oneshark5@163.com
 * @date 2024-12-19 19:37:49
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

