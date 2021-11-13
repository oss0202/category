package com.musinsa.category.service;

import com.musinsa.category.domain.Category;
import com.musinsa.category.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void cleanUp(){
        categoryRepository.deleteAll();

        categoryRepository.save(new Category().builder().categoryNm("첫번째").upperCategoryId("").categoryDc("카테고리 설명1").categoryIdOrder(100L).build());
        categoryRepository.save(new Category().builder().categoryNm("두번째").upperCategoryId("").categoryDc("카테고리 설명2").categoryIdOrder(200L).build());
        categoryRepository.save(new Category().builder().categoryNm("세번째").upperCategoryId("").categoryDc("카테고리 설명3").categoryIdOrder(300L).build());
        categoryRepository.save(new Category().builder().categoryNm("네번째").upperCategoryId("").categoryDc("카테고리 설명4").categoryIdOrder(400L).build());
        System.out.println("데이터 Insert");
    }

    @Test
    public void 모든_리스트_조회(){
        List<Category> categories = categoryRepository.findAll();
        categories.stream().forEach(category -> {
            System.out.println(category.getCategoryNm());
        });
    }
}