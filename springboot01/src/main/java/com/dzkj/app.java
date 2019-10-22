package com.dzkj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class app {
		public static void main(String[] args) {
			//springboot开机
			SpringApplication.run(app.class, args);
		}
		

}
