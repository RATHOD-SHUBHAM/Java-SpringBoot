package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class SpringBootTutorialApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootTutorialApplication.class, args);
	}

//	@GetMapping // making it a rest end point
//	public String hello(){
//		return "Hello Java World.";
//	}

}
