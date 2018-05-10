package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching//redis缓存注解
//@MapperScan(basePackages = "cn.imooc.dataObject.mapper")
public class SellApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellApplication.class, args);
		System.out.println(Thread.currentThread().getStackTrace()[1].getClassName()+"已启动");

	}

}
