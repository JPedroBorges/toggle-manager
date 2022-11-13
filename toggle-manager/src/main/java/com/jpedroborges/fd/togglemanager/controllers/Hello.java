package com.jpedroborges.fd.togglemanager.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("SameReturnValue")
@RestController
@RequiredArgsConstructor
public class Hello {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }
}
