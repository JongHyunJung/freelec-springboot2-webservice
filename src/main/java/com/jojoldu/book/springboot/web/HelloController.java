package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// * 컨트롤러를 JSON 반환하는 컨트롤러로 만들어 줌
// * 이전 @ResponseBody 를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해주는 것

// @GetMapping
// * HTTP Method 인 GET 의 요청을 받을 수 있는 API를 만들어 줌
// * 이전 @RequestMapping(method = RequestMethod.GET)
// * 이제 이 프로젝트는 /hello 요청이 오면 문자열 hello를 반환하는 기능을 가지게 됨

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
