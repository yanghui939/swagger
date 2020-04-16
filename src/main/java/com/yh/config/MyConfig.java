package com.yh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.yh.controller")
public class MyConfig {

    @Bean
    public Docket createApi(Environment environment){
        boolean isEnable = environment.acceptsProfiles(Profiles.of("prod"));
        return new Docket(DocumentationType.SWAGGER_2)
                //配置页面详情信息
                .apiInfo(apiInfo())
                //判断是否可以访问api ，false为不可以访问 ，true为可以访问
                .enable(!isEnable)
                .select()
                //根据包筛选生成api的类的方法
                .apis(RequestHandlerSelectors.basePackage("com.yh.controller"))
                //根据路径筛选生成api的方法
                .paths(PathSelectors.any())
                //构建
                .build();
    }

    /**
     * 设计页面详情信息
     * @return
     */
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //标题信息
                .title("swagger训练")
                //描述信息
                .description("swagger描述")
                //作者信息
                .contact(new Contact("yanghui","8088","123@qq.com"))
                //版本信息
                .version("1.0.0")
                //构建
                .build();
    }
}
