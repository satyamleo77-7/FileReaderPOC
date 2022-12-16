package com.reader.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {
		"com.reader"
})
@ComponentScan(basePackages= {"com.reader"})
public class FileReaderPocAppl {

	public static void main(String[] args) {
		SpringApplication.run(FileReaderPocAppl.class, args);
	}

}
