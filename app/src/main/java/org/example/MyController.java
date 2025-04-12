package org.example;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String printHello() {
        return "Hello World!";
    }
}
