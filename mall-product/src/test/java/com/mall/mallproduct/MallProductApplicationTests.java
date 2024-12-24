package com.mall.mallproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mall.mallproduct.entity.BrandEntity;
import com.mall.mallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        // 插入
        // brandEntity.setName("滴滴滴");
        // brandService.save(brandEntity);
        // System.out.println("保存成功。。。");

        // 修改
        // brandEntity.setBrandId(6L);
        // brandEntity.setDescript("didididi~~~");
        // brandService.updateById(brandEntity);
        //
        // System.out.println("保存成功！！！");

        // 查询
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", "6L"));
        list.forEach((item) -> {
            System.out.println("list output:" + item);
        });

    }

}
