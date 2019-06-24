package com.example.springvertxproject.model;

import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    private Long id;
    private String articleText;

    private Article() {
    }

    @PersistenceConstructor
    public Article(Long id, String articleText) {
        super();
        this.id = id;
        this.articleText = articleText;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", article=" + articleText + "]";
    }

    public Long getArticleId() {
        return id;
    }

    public void setArticleId(Long id) {
        this.id = id;
    }

    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

}
