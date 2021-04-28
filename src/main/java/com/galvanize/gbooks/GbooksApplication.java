package com.galvanize.gbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GbooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(GbooksApplication.class, args);
	}

	@GetMapping("/health")
	public String getHealth(){
		return "ok";
	}
}
