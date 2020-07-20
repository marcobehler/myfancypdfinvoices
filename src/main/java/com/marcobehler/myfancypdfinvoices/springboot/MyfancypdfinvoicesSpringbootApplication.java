package com.marcobehler.myfancypdfinvoices.springboot;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class MyfancypdfinvoicesSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyfancypdfinvoicesSpringbootApplication.class, args);
	}
}
