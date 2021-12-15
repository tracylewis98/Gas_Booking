package com.gasbooking;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.gasbooking.entity.Bank;
import com.gasbooking.service.IBankService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
*/


@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger2
public class GasBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GasBookingAppApplication.class, args);
		System.out.println("Connected to database");
	}

	/*@Bean
	  public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.example.demo")).build();
	   }
	   */
	
	 //http://localhost:8080/swagger-ui/index.html 


}
