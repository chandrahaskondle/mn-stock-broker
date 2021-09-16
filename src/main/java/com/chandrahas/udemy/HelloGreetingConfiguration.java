package com.chandrahas.udemy;

import io.micronaut.context.annotation.ConfigurationInject;
import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@ConfigurationProperties("hello.config.greeting")
public class HelloGreetingConfiguration {

    private final String de;
    private final String en;

    @ConfigurationInject
    public HelloGreetingConfiguration(@NotBlank String de, @NotEmpty String en) {
        this.de = de;
        this.en = en;
    }

    public String getDe() {
        return de;
    }

    public String getEn() {
        return en;
    }
}
