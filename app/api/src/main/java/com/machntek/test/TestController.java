package com.machntek.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final FeedService feedService;

    @GetMapping("/api/test")
    public void test() {

        System.out.println("##########");
        System.out.println("TestController is called!!");
        System.out.println("##########");
        feedService.doSomething();
    }
}
