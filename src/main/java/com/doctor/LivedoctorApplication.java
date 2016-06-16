package com.doctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@SpringBootApplication
//@PropertySource("classpath:application.properties")
public class LivedoctorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivedoctorApplication.class, args);
	}

//	@Bean
//	@ConfigurationProperties(prefix="datasource.mine")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}
}
