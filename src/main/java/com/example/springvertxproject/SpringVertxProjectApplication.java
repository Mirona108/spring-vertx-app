package com.example.springvertxproject;

import com.example.springvertxproject.verticles.ArticleRecipientVerticle;
import com.example.springvertxproject.verticles.ServerVerticle;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringVertxProjectApplication {

    @Autowired
    private ServerVerticle serverVerticle;

    @Autowired
    private ArticleRecipientVerticle articleRecipientVerticle;

    public static void main(String[] args) {
        SpringApplication.run(SpringVertxProjectApplication.class, args);
    }

    @PostConstruct
    public void deployVerticle() {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(serverVerticle);
        vertx.deployVerticle(articleRecipientVerticle);
    }
}
