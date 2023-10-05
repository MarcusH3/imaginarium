package com.example.imaginarium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
@TestConfiguration(proxyBeanMethods = false)
public class TestImaginariumApplication {

	public static void main(String[] args) {
		SpringApplication.from(ImaginariumApplication::main).with(TestImaginariumApplication.class).run(args);}
}