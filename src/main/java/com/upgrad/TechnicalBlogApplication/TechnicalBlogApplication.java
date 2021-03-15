package com.upgrad.TechnicalBlogApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TechnicalBlogApplication {
	public static void main(String[] args) {
		SpringApplication.run(TechnicalBlogApplication.class, args);
	}
}
