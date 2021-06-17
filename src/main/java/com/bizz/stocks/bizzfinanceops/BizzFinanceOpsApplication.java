package com.bizz.stocks.bizzfinanceops;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BizzFinanceOpsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BizzFinanceOpsApplication.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8083"));
        app.run(args);
		//SpringApplication.run(BizzFinanceOpsApplication.class, args);
		System.out.println("Hello");
	}

}
