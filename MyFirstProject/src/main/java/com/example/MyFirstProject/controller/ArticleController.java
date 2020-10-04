package com.example.MyFirstProject.controller;

import com.example.MyFirstProject.dto.ArticleForm;
import com.example.MyFirstProject.entity.Article;
import com.example.MyFirstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles")
    public String articles(Model model) {

        Iterable<Article> articlesList = articleRepository.findAll();

        model.addAttribute("articles", articlesList);

        return "articles/index";
    }

    @GetMapping("/articles/new")
    public String newArticleForm() {

        return "articles/new";
    }

    @PostMapping("/articles/new")
    public String create(ArticleForm form, Model model) {

        Article createEntity = form.toEntity();

        Article saved = articleRepository.save(createEntity);

        return "redirect:/articles";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {

        Article findById = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", findById);

        return "articles/show";
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        articleRepository.delete(article);
        log.info(id + "번 삭제완료");
        return "redirect:/articles";
    }


}