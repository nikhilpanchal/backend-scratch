package com.nikhil.reactor.web;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/demo")
public class DemoController {
    DataBufferFactory factory = new DefaultDataBufferFactory();

    @GetMapping("/devoxx")
    public String devoxx() {
        return "Hello World!";
    }

    @GetMapping("/hello")
    public Mono<String> hello(@RequestParam String name) {
        return Mono.just("Hello, " + name);
    }

    /**
     * How responses work under the hood
     * @param exchange
     * @return
     */
    @GetMapping("/exchange")
    public Mono<Void> exchange(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();

        response.setStatusCode(HttpStatus.OK);
        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
        DataBuffer buffer = factory.allocateBuffer().write("Exchange".getBytes(StandardCharsets.UTF_8));

        return response.writeWith(Mono.just(buffer));
    }

    @GetMapping("/waitforit")
    public Mono<String> never() {
        return Mono.never();
    }

    @GetMapping("/error")
    public Mono<String> error() {
        return Mono.error(new IllegalStateException("Something went horribly wrong!!"));
    }
}
