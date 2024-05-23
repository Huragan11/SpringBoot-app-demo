package com.huragan11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse(
                "well hello there",
                List.of("C++","Java","C#"),
                new Person("Alex", 23,500.0)
                );
    }

    record Person(String name, int age, double savings){}
    record GreetResponse(
            String greet,
            List<String> favProgLang,
            Person person
    ){}
}
