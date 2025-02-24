package cn.yematech.heaver.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author se7en
 * @date 2021/09/09
 **/
@ConditionalOnClass(Docket.class)
@Configuration
public class Swagger2Configuration {
  @Bean
  public Docket smarteMenuApi(){
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("heaver")
        .select()
        .apis(RequestHandlerSelectors.basePackage("cn.yematech.heaver"))
        .paths(PathSelectors.any())
        .build();
  }
}
