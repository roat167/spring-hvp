package edu.mum.cs.cs544.spring.hvp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
//@ImportResource("classpath:applicationContext.xml")
public class SpringHvpApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		 return application.sources(SpringHvpApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringHvpApplication.class, args);
	}
	
	public static void addSampleData() {

	}
}
