package me.kdh.controller.view;

import lombok.RequiredArgsConstructor;
import me.kdh.domain.Article;
import me.kdh.dto.AddArticleRequest;
import me.kdh.dto.ArticleListViewResponse;
import me.kdh.dto.ArticleResponse;
import me.kdh.dto.ArticleViewResponse;
import me.kdh.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model) {
        List<ArticleListViewResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles);
        return "articleList";
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Article article = blogService.findById(id);

        model.addAttribute("article", new ArticleViewResponse(article));
        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("article", new ArticleViewResponse());
            return "newArticle";
        }

        Article article = blogService.findById(id);
        model.addAttribute("article", new ArticleViewResponse(article));
        return "newArticle";
    }
}