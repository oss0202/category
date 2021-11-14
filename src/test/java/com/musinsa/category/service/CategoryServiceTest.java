package com.musinsa.category.service;

import com.musinsa.category.domain.Category;
import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
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

    @Autowired
    private CategoryService categoryService;

    private static Long aLong1;
    @BeforeEach
    public void cleanUp(){
        categoryRepository.deleteAll();

//        categoryRepository.save(new Category().builder().categoryNm("첫번째").upperCategoryId("").categoryDc("카테고리 설명1").categoryIdOrder(100L).build());
//        categoryRepository.save(new Category().builder().categoryNm("두번째").upperCategoryId("").categoryDc("카테고리 설명2").categoryIdOrder(200L).build());
//        categoryRepository.save(new Category().builder().categoryNm("세번째").upperCategoryId("").categoryDc("카테고리 설명3").categoryIdOrder(300L).build());
//        categoryRepository.save(new Category().builder().categoryNm("네번째").upperCategoryId("").categoryDc("카테고리 설명4").categoryIdOrder(400L).build());

        aLong1 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("첫번째").categoryDc("카테고리 설명1").categoryIdOrder(400L).build());
        Long aLong2 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("두번째").categoryDc("카테고리 설명2").categoryIdOrder(400L).build());
        Long aLong3 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("세번째").categoryDc("카테고리 설명3").categoryIdOrder(400L).build());
        Long aLong4 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("네번째").categoryDc("카테고리 설명4").categoryIdOrder(400L).build());
        Long aLong5 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("다섯번째").categoryDc("카테고리 설명5").categoryIdOrder(400L).build());

//        System.out.println("---------------- aLong ----------------");
//        System.out.println(aLong5);

        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("첫번째서브").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명1").categoryIdOrder(10L).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("두번째서브").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명2").categoryIdOrder(400L).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("세번째서브").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명3").categoryIdOrder(400L).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("네번째서브").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명4").categoryIdOrder(400L).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("다섯번째서브").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명5").categoryIdOrder(400L).build());

//        categoryRepository.save(new Category().builder().categoryNm("첫번째서브").upperCategoryId("1").categoryDc("카테고리 설명1").categoryIdOrder(aLong1).build());
//        categoryRepository.save(new Category().builder().categoryNm("두번째서브").upperCategoryId("2").categoryDc("카테고리 설명2").categoryIdOrder(aLong2).build());
//        categoryRepository.save(new Category().builder().categoryNm("세번째서브").upperCategoryId("3").categoryDc("카테고리 설명3").categoryIdOrder(aLong3).build());
//        categoryRepository.save(new Category().builder().categoryNm("네번째서브").upperCategoryId("4").categoryDc("카테고리 설명4").categoryIdOrder(aLong4).build());
//        categoryRepository.save(new Category().builder().categoryNm("네번째서브").upperCategoryId("4").categoryDc("카테고리 설명4").categoryIdOrder(aLong5).build());
        System.out.println("데이터 Insert");
    }

    @Test
    public void 모든_리스트_조회(){
        List<Category> categories = categoryRepository.findAll();
        categories.stream().forEach(category -> {
            System.out.println(category.toString());
        });
    }

    @Test
    public void queryDSL_리스트_조회(){
        System.out.println("---------null-----------");
        List<CategoryResponseDto> categories = categoryService.findByUpperCategoryId("");
        categories.stream().forEach(category -> {
            System.out.println(category.toString());
        });
        System.out.println("---------not null-----------");
        categories = categoryService.findByUpperCategoryId("1");
        categories.stream().forEach(category -> {
            System.out.println(category.toString());
        });
    }
}