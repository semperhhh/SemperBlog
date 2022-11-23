package com.zph;

import com.zph.Utils.R;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@SpringBootTest
@Slf4j
class SemperWorkApplicationTests {

    @Test
    void test1() {
        String s = new Date(1660118528143l).toString();
        System.out.println(s);
    }
}
