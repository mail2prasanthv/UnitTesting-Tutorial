package com.tutorial.unittesting.UnitTestingTutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.tutorial.unittesting")
public class UnitTestingTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingTutorialApplication.class, args);
	}

}
