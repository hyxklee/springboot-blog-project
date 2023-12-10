package me.hyuxlee.springbootdev.dto;

import lombok.Getter;
import me.hyuxlee.springbootdev.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
