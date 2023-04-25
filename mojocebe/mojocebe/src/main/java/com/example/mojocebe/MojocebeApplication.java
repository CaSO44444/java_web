package com.example.mojocebe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.mojocebe.mapper")
public class MojocebeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MojocebeApplication.class, args);
    }

}
