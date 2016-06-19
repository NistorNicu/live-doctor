package com.doctor;

import com.doctor.service.impl.ConsultationSessionHandler;
import com.opentok.OpenTok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
//@ComponentScan(basePackages = "com.doctor")
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
