package com.chandrahas.udemy;

import io.micronaut.context.annotation.Property;
import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("${hello.controller.path}")
public class HelloWorldController {

    private final HelloWorldService helloWorldService;
    private final HelloGreetingConfiguration helloGreetingConfiguration;

    @Value("${greeting.message:Thank you}")
    private String greetingMessage;

    HelloWorldController(HelloWorldService helloWorldService, HelloGreetingConfiguration greetingConfiguration) {
        this.helloWorldService = helloWorldService;
        this.helloGreetingConfiguration = greetingConfiguration;
    }

    @Get()
    public String index(){
        System.out.println(greetingMessage);
        return helloWorldService.SayHi();
    }

    @Get("/de")
    public String greetInGerman() {
        return helloGreetingConfiguration.getDe();
    }

    @Get("/en")
    public String greetInEnglish() {
        return helloGreetingConfiguration.getEn();
    }

}
