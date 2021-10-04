package com.foo.stopwatchingyoutube.root;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0")
public class RootRestController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
