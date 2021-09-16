package com.chandrahas.udemy;

import javax.inject.Singleton;

@Singleton
public class HelloWorldService {

    public String SayHi() {
        return "Hello World - Service";
    }

}
