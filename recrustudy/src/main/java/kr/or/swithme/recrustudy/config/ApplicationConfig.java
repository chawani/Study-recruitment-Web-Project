package kr.or.swithme.recrustudy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.swithme.recrustudy.dao",  "kr.or.swithme.recrustudy.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}