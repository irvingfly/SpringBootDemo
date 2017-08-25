package com.icourt.config;

import com.icourt.annotation.SwaggerIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * Swagger配置类
 * @author Zhangtengfei
 * @date 2017-8-23
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket merchantStoreApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("internal-api")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .apis(not(withClassAnnotation(SwaggerIgnore.class)))  //SwaggerIngore的注解的controller将会被忽略
                .paths(or(regex("/user/.*")))
                .build()
                .apiInfo(testApiInfo());
    }


    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("标题文档",//大标题
                "用户增删改查",//小标题
                "0.1",//版本
                "NO terms of service",
                "irvingfly@163.com",//作者
                " 用户增删改查 version 1.0",//链接显示文字
                "www.icourt.com"//网站链接
        );

        return apiInfo;
    }
}