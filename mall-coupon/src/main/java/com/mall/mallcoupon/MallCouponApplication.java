package com.mall.mallcoupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 1、如何使用Nacos作为配置中心统一管理配置
 *  1）引入依赖
 *  <dependency>
 *             <groupId>com.alibaba.cloud</groupId>
 *             <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
 *         </dependency>
 *  2)创建一个bootstrap.yaml
 *  3）给配置中心添加一个数据集  为服务名.yaml
 *  4）给应用名.yaml添加配置
 *  5）动态获取配置
 *      添加@RefreshScope注解
 *      @Value("${coupon.user.name}") 获取某个配置的值
 *      如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的配置。
 *  2、细节
 *   1）命名空间：配置隔离；默认public，默认新增的所有配置都在public
 *      1、开发、测试、生产（不同阶段创建不同命名空间）；利用命名空间来做环境隔离（基于环境隔离）
 *      注意：在bootstrap.yaml 配置上，需要明确使用哪个命名空间下的配置
 *      2、每一个微服务之间互相隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置（基于微服务隔离）
 *      coupon商品服务、member用户服务、order订单服务、product、ware优惠服务
 *   2）配置集：所有配置的集合
 *
 *   3）配置集ID：类似文件名
 *      Data ID：类似文件名
 *   4）配置分组：默认所有的配置集都属于：DEFAULT_GROUP
 *   group: # 配置分组
 *  使用：每个微服务创建自己的命名空间，使用配置分组区分环境，dev、test、prod
 * 3、同时加载多个配置集
 *  以前Spring Boot任何方法从配置文件中获取值，都能使用
 *  配置中心有的优先使用配置中心的，
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCouponApplication.class, args);
    }

}
