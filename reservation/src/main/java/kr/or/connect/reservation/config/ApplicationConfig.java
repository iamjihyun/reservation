package kr.or.connect.reservation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.reservation.dao",  "kr.or.connect.reservation.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {
//dbConfig에 설정된 내용을 읽어와야해서 임포트 함
}