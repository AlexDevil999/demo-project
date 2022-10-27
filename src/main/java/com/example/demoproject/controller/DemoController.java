package com.example.demoproject.controller;


import com.example.demoproject.exception.ElementException;
import com.example.demoproject.service.Calculate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class DemoController {

    private final Calculate calculate;

    @GetMapping("/")
    public ResponseEntity<?> calculateCapacityWater(@RequestParam List<Integer> datas) throws ElementException {
        return ResponseEntity.ok(calculate.getVolume(datas));
    }
}
