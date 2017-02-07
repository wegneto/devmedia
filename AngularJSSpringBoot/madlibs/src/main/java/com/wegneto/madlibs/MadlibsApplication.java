package com.wegneto.madlibs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.wegneto.madlibs.service,com.wegneto.madlibs.controller")
@SpringBootApplication
public class MadlibsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadlibsApplication.class, args);
	}
}
