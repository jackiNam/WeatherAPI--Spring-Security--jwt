package com.java.namle.weatherAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableJpaAuditing
@SpringBootApplication
//@SpringBootApplication bao gồm 3 annotation
//@EnableAutoConfiguration: bật cơ chế cấu hình tự động của Spring Boot
//@ComponentScan: bật quét trên bao bì chứa ứng dụng (xem các phương pháp hay nhất@Component)
//@Configuration: cho phép đăng ký thêm beans trong ngữ cảnh hoặc nhập các lớp cấu hình bổ sung
public class WeatherApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(WeatherApiApplication.class, args);
	}

}
