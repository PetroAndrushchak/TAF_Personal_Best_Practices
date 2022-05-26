package com.petroandrushchak.services;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class AuthTwoApiFlow {

    public static void main(String[] args) throws IOException {

        AtomicReference<String> name = new AtomicReference<>("Testt");

        Javalin app = Javalin.create();
        app.start();
        app.get("/code", (ctx) -> {
            System.out.println("Hi code");
        });
        app.get("/", ctx -> ctx.result("Hello World"));

    }
}
