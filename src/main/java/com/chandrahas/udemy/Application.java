package com.chandrahas.udemy;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.Micronaut;

import javax.inject.Inject;


public class Application {

    public static void main(String[] args) {
        ApplicationContext context = Micronaut.run(Application.class, args);
        final HelloWorldService helloWorldService= context.getBean(HelloWorldService.class);
        helloWorldService.SayHi();
        context.close();
    }
}
