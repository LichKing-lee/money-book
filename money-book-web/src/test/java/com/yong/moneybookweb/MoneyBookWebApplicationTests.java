package com.yong.moneybookweb;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MoneyBookWebApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void t() throws Exception {
        // given

        // when

        // then
        var p = new Person("changyong", 32);
        assertThat(p).isEqualTo(new Person("changyong", 32));
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private int age;
    }
}
