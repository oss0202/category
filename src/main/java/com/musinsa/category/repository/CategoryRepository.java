package com.musinsa.category.repository;

import com.musinsa.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    void deleteByUpperCategoryId(Long categoryId);
}
