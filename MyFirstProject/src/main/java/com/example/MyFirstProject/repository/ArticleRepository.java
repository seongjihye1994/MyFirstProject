package com.example.MyFirstProject.repository;

import com.example.MyFirstProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}