package com.jojoldu.book.springboot.web.dto;

//import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_func_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        // assertj 의 assertThat
        // * assertj 라는 테스트 검증 라이브러리의 검증 메소드
        // * 검증하고 싶은 대상을 메소드 인자로 받음, 메소드 체이닝 지원
        // * CoreMatcher 와 달리 추가적 라이브러리 필요 x
        // * 자동완성이 좀 더 확실함

        // isEqualTo
        // * assertj 동등 비교 메소드
        // * assertThat 에 있는 값과 isEqualTo 값 비교해 같을때만 성공
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
