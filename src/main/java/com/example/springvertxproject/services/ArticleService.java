package com.example.springvertxproject.services;

import com.example.springvertxproject.model.Article;
import com.example.springvertxproject.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }
}
