package com.mall.mallmember.feign;

import com.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author bobo
 * @Date 2025/2/22 12:56
 * @注释
 */
// 表明是远程客户端

/**
 * 声明式的远程调用
 */
@FeignClient("mall-coupon")
public interface CouponFeignService {
    @RequestMapping("/mallcoupon/coupon/member/list")
    public R membercoupons();
}
