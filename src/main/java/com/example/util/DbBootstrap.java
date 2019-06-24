package com.example.util;

import com.example.springvertxproject.model.Article;
import com.example.springvertxproject.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class DbBootstrap implements CommandLineRunner {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void run(String... args) throws Exception {
        this.articleRepository.save(new Article(1L, "new test"));
        IntStream.range(0, 10)
                .forEach(count -> this.articleRepository.save(new Article(new Random().nextLong(), UUID.randomUUID()
                        .toString())));
    }
}
