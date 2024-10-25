package com.example.testchain.controller;

import com.example.testchain.chain.GodValidator;
import com.example.testchain.others.Dummy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AllController {
    private final GodValidator godValidator;

    @GetMapping
    @ResponseBody
    public String getall() {
        godValidator.validate(new Dummy()); // 'OH NO THIS IS DUMMY' will be thrown
        godValidator.validate("sdsds"); // 'OH NO THIS IS STRING' will be thrown
        godValidator.validate(5); // 'OH NO THIS IS INTEGER' will be thrown
        return "wat";
    }
}
