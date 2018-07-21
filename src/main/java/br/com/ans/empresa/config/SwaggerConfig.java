package br.com.ans.empresa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * O Swagger usa o 'basePackage' para buscar os controllers,
 * logo, defina nele o local onde os controllers estão.
 * 
 * @Configuration permite que a classe contenha configurações para o Spring.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors
				.basePackage("br.com.ans.empresa.controllers"))
				.paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
		
	}

	private ApiInfo apiInfo() {
		//Gerado a partir de "(apiInfo())".
		return new ApiInfoBuilder().title("Swagger API")
					.description("Documentação da API de acesso aos endpoints com Swagger")
					.version("1.0")
					.build();
	}

}
