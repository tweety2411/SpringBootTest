package com.heypli.springboottest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(value = {"key=value"}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootTestApplicationTests {

    @Value("${key}")
    private String key;

    @Test
    void contextLoads() {
        assertThat(key, is("value"));
    }

}
