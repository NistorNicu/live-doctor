package com.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
public class LivedoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivedoctorApplication.class, args);
	}

	@Bean
	public Docket doctorApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("livedoctor")
				.select()
				.build();
	}


//	@Bean
//	@ConfigurationProperties(prefix="datasource.mine")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
}
