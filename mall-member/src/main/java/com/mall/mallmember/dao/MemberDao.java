package com.mall.mallmember.dao;

import com.mall.mallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author bobo
 * @email oneshark5@163.com
 * @date 2025-02-17 21:21:40
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
