package com.mall.mallproduct;

import com.mall.mallproduct.entity.BrandEntity;
import com.mall.mallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setName("滴滴滴");
        brandService.save(brandEntity);
        System.out.println("保存成功。。。");
    }

}
