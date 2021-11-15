package com.musinsa.category.service;

import com.musinsa.category.domain.Category;
import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
import com.musinsa.category.dto.CategoryUpdateRequestDto;
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

        aLong1 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("첫번째").categoryDc("카테고리 설명1").categoryIdOrder(100).build());
        Long aLong2 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("두번째").categoryDc("카테고리 설명2").categoryIdOrder(200).build());
        Long aLong3 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("세번째").categoryDc("카테고리 설명3").categoryIdOrder(300).build());
        Long aLong4 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("네번째").categoryDc("카테고리 설명4").categoryIdOrder(400).build());
        Long aLong5 = categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("다섯번째").categoryDc("카테고리 설명5").categoryIdOrder(500).build());

//        System.out.println("---------------- aLong ----------------");
//        System.out.println(aLong5);

        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("첫번째서브1").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명1").categoryIdOrder(10).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("첫번째서브2").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명1").categoryIdOrder(20).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("두번째서브").upperCategoryId(aLong2).categoryDc("카테고리 서브 설명2").categoryIdOrder(20).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("세번째서브").upperCategoryId(aLong3).categoryDc("카테고리 서브 설명3").categoryIdOrder(30).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("네번째서브").upperCategoryId(aLong4).categoryDc("카테고리 서브 설명4").categoryIdOrder(40).build());
        categoryService.save(new CategoryInsertRequestDto().builder().categoryNm("다섯번째서브").upperCategoryId(aLong5).categoryDc("카테고리 서브 설명5").categoryIdOrder(50).build());

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
        Long aa = null;
        List<CategoryResponseDto> categories = categoryService.findByUpperCategoryId(aa);
        categories.stream().forEach(category -> {
            System.out.println(category.toString());
        });
        System.out.println("---------not null-----------");
        categories = categoryService.findByUpperCategoryId(aLong1);
        categories.stream().forEach(category -> {
            System.out.println(category.toString());
        });
    }

    @Test
    public void 카테고리_수정(){
        CategoryUpdateRequestDto categoryUpdateRequestDto = new CategoryUpdateRequestDto().builder()
                .categoryId(aLong1)
                .categoryNm("첫번째_수정")
                .categoryDc("카테고리 설명1_수정")
                .categoryIdOrder(100)
                .build();
        categoryService.update(categoryUpdateRequestDto);
        List<CategoryResponseDto> categories = categoryService.findByUpperCategoryId(null);
        for (CategoryResponseDto category : categories) {
            if(category.getCategoryId().equals(aLong1)){
                System.out.println(category.toString());
            }
        }
    }
    @Test
    public void 카테고리_삭제(){
        categoryService.delete(aLong1);
        List<CategoryResponseDto> categoryResponseDtos1 = categoryService.findByUpperCategoryId(null);
        List<CategoryResponseDto> categoryResponseDtos2 = categoryService.findByUpperCategoryId(aLong1);

        for (CategoryResponseDto categoryResponseDto : categoryResponseDtos1) {
            System.out.println(categoryResponseDto.toString());
        }
        System.out.println(categoryResponseDtos2.size());

    }
}