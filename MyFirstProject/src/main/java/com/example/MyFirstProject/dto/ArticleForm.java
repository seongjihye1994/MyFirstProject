package com.example.MyFirstProject.dto;

import com.example.MyFirstProject.entity.Article;

public class ArticleForm{

    private String title;
    private String content;

    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "dto : ArticleForm { title : " + title + ", content : " + content + " }";
    }

    public Article toEntity() {
        return new Article(null, title, content); // id가 null인 이유는? 클라이언트는 id를 입력하지 않음
    }


}