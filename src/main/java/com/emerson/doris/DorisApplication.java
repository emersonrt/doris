package com.emerson.doris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class DorisApplication {

	public static void main(String[] args) {
		SpringApplication.run(DorisApplication.class, args);
	}

}
