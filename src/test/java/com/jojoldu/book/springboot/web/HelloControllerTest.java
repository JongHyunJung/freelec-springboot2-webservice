package com.jojoldu.book.springboot.web;

//import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;
// @RunWith
// * 테스트 진행 시 JUnit 내장된 실행자 외 다른 실행자 실행
// * 여기서는 SpringRunner 라는 실행자 사용
// * 스프링 부트 테스트와 JUnit 사이에 연결자 역할

// @WebMvcTest
// * 여러 스프링 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
// * 선언 시 @Controller, @ControllerAdvice 등 사용 가능
// * 단, @Service, @Component, @Repository 등 사용 불가능 why? 여기서는 컨트롤러만 사용하기 때문

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    // @Autowired
    // * 스프링이 관리하는 빈(Bean) 주입 받음

    // private MockMvc mvc
    // * 웹 API 테스트할 때 사용
    // * 스프링 MVC 테스트 시작점
    // * 이 클래스 통해 HTTP GET, POST 등 대한 API 테스트 가능
    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        // mvc.perform(get("/hello"))
        // * MockMvc 통해 /hello 주소로 HTTP GET 요청
        // * 체이닝이 지원되어 아래와 같이 여러 검증 기능 이어서 선언 가능

        // .and Expect(status().isOK())
        // * mvc.perform 결과 검증
        // * HTTP Header 의 Status 검증
        // * 우리가 흔히 아는 200, 404, 500 등 상태 검증
        // * 여기서 OK 즉, 200인지 아닌지 검증

        // .and Expect(content().string(hello))
        // mvc.perform 결과 검증
        // 응답 본문 내용 검증
        // Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto_return() throws Exception{
        String name = "hello";
        int amount = 1000;

        // param
        // * API 테스트할 때 사용될 요청 파라미터 설정
        // * 단, 값은 String만 허용
        // * 그래서 숫자/날짜 등의 데이터도 등록 시 문자열로 변경해야 가능

        // jsonPath
        // * JSON 응답값을 필드별로 검증할 수 있는 메소드
        // * $ 기준으로 필드명 명시
        // * name, amount 를 검증하니 $.name, $.amount 로 검증

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
