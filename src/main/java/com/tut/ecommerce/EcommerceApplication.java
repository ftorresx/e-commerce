package com.tut.ecommerce;

import java.text.NumberFormat;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);

	}

	public static void printInfo() {
		Runtime runtime = Runtime.getRuntime();
		final NumberFormat format = NumberFormat.getInstance();
		final long maxMemory = runtime.maxMemory();
		final long allocatedMemory = runtime.totalMemory();
		final long freeMemory = runtime.freeMemory();
		final long mb = 1024L * 1024L;
		final String mega = " MB";
		System.out.println("===== Memory Info Application E-COMMERCE TUT =========");
		System.out.println("Free memory: " + format.format(freeMemory / mb) + mega);
		System.out.println("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
		System.out.println("Max memory: " + format.format(maxMemory / mb) + mega);
		System.out.println(
				"Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
		System.out.println("========================================================");
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Bean
	public CommandLineRunner memInfoRunner() {
		return args -> printInfo();
	}

}
