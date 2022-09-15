package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 해당 프로젝트의 메인 클래스
// @SpringBootApplication 으로 인해 스프링부트 자동 설정, 스프링 Bean 읽기/생성 모두 자동 설정
// @SpringBootApplication 이 있는 위치부터 설정을 읽어가기 때문에 항상 프로젝트 최상단에 위치해야만 함
@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
