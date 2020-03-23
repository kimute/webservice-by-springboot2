package com_kim;

import com_kim.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test_function() {

        //variable given
        String name = "test";
        int amount = 1000;

        //it works when variable given
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //use check library
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
