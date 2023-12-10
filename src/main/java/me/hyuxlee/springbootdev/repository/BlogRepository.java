package me.hyuxlee.springbootdev.repository;

import me.hyuxlee.springbootdev.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {//엔티티, 기본키 속성
}
