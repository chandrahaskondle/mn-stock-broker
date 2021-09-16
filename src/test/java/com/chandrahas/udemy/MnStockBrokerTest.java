package com.chandrahas.udemy;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class MnStockBrokerTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/") RxHttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testHelloWorldController() {
        final String result = client.toBlocking().retrieve("/hello");
        assertEquals("Hello World - Service", result);
    }

    @Test
    void returnsGermanGreeting() {
        final String result = client.toBlocking().retrieve("/hello/de");
        assertEquals("hallo", result);
    }

    @Test
    void returnsEnglishGreeting() {
        final String result = client.toBlocking().retrieve("/hello/en");
        assertEquals("hello", result);
    }

}
