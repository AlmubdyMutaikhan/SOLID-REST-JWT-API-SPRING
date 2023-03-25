package com.example.demo;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication  {
	@GetMapping("/")
	public String hello() {
		return "Solid bank app project. Version 4 is under maintenance.";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	@Override
	public void run(String... arg0) throws Exception {
//		BankAppCLI bankAppCLI = context.getBean(BankAppCLI.class);
//		bankAppCLI.start();
	}*/
}
