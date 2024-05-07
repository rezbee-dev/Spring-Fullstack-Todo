package com.risby.todoapp.http;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    @Operation(summary = "Returns 'Hello World!'")
    public String home() {
        return "Hello World!";
    }
}
