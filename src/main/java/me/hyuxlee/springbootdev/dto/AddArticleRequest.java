package me.hyuxlee.springbootdev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hyuxlee.springbootdev.domain.Article;

@NoArgsConstructor//기본생성자
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(){//생성자를 사용해 객체 생성
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
