package com.jojoldu.book.springboot.dto;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {

        //given
        String name = "송재호";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        /*
         Junit의 기본 assertThat이 아닌 assertj의 assertThat을 사용함
         assertj역시 Junit에서 자동으로 라이브러리 등록을 해줌.
         Junit과 비교하여 assertj는 CoreMatchers 라이브러리 등이 필요없고, 자동완성이 좀 더 확실하게 지원됨.
         */
        Assertions.assertThat(dto.getName()).isEqualTo(name);
        Assertions.assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
