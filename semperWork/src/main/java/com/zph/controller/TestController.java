package com.zph.controller;

import com.zph.Utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/test1")
    public R<String> test1() {
        throw new RuntimeException();
    }
}
