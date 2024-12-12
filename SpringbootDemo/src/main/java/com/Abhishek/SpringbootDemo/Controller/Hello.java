package com.Abhishek.SpringbootDemo.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @Value("${welcome.message}")
    private String welcomemessage;
@GetMapping(value = "/")
    public String helloworld(){
        return welcomemessage;
    }
}
