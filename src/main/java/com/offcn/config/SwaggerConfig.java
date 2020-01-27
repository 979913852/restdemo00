package com.offcn.config;

import io.swagger.annotations.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author zhangzz
 * @date 2019/12/25 22:03
 */

@Configuration
public class SwaggerConfig {

    /**
     * 配置文档基本对象
     * @return
     */
    private ApiInfo getApiInfo(){
       return new ApiInfoBuilder().title("Swagger接口文档")
                            .contact("张扬")
                            .termsOfServiceUrl("www.baidu.com")
                            .description("前端程序员参考文档")
                            .version("1.0")
                    .build();

    }

    //正文配置
    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.offcn.cont roller")).paths(PathSelectors.any()).build();
    }
}
