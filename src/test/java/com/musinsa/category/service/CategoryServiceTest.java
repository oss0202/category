package com.musinsa.category.service;

import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
import com.musinsa.category.dto.CategoryUpdateRequestDto;
import com.musinsa.category.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    private static Long aLong1;

    //총 11건 데이터 등록
    private static Long categoryCnt;

    @BeforeEach
    public void cleanUp(){
        categoryRepository.deleteAll();

        aLong1 = categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("첫번째").categoryDc("카테고리 설명1").categoryIdOrder(100).build());
        Long aLong2 = categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("두번째").categoryDc("카테고리 설명2").categoryIdOrder(200).build());
        Long aLong3 = categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("세번째").categoryDc("카테고리 설명3").categoryIdOrder(300).build());
        Long aLong4 = categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("네번째").categoryDc("카테고리 설명4").categoryIdOrder(400).build());
        Long aLong5 = categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("다섯번째").categoryDc("카테고리 설명5").categoryIdOrder(500).build());

        categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("첫번째서브1").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명1").categoryIdOrder(10).build());
        categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("첫번째서브2").upperCategoryId(aLong1).categoryDc("카테고리 서브 설명1").categoryIdOrder(20).build());
        categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("두번째서브").upperCategoryId(aLong2).categoryDc("카테고리 서브 설명2").categoryIdOrder(20).build());
        categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("세번째서브").upperCategoryId(aLong3).categoryDc("카테고리 서브 설명3").categoryIdOrder(30).build());
        categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("네번째서브").upperCategoryId(aLong4).categoryDc("카테고리 서브 설명4").categoryIdOrder(40).build());
        categoryCnt = categoryService.saveCategory(new CategoryInsertRequestDto().builder().categoryNm("다섯번째서브").upperCategoryId(aLong5).categoryDc("카테고리 서브 설명5").categoryIdOrder(50).build());
    }

    @Test
    public void 카테고리_모두조회(){
        //given
        Long parameter = null;

        //when
        List<CategoryResponseDto> categories = categoryService.findByUpperCategoryId(parameter);

        //then
        //BeforeEach - cleanUp 메서드에서 등록한 데이터는 총 11건
        assertThat(categories.size()).isEqualTo(categoryCnt);
    }

    @Test
    public void 카테고리_조건_조회(){
        //given
        Long parameter = aLong1;

        //when
        List<CategoryResponseDto> categories = categoryService.findByUpperCategoryId(parameter);

        //then
        assertThat(categories.get(0).getUpperCategoryId()).isEqualTo(aLong1);
    }

    @Test
    public void 카테고리_수정(){
        //given
        CategoryUpdateRequestDto categoryUpdateRequestDto = new CategoryUpdateRequestDto().builder()
                .categoryId(aLong1)
                .categoryNm("첫번째_수정")
                .categoryDc("카테고리 설명1_수정")
                .categoryIdOrder(100)
                .build();

        //when
        Long updateCategoryID = categoryService.updateCategory(categoryUpdateRequestDto);

        //then
        List<CategoryResponseDto> categories = categoryService.findByUpperCategoryId(null);
        List<CategoryResponseDto> result = categories.stream().filter(categoryResponseDto -> categoryResponseDto.getCategoryId() == updateCategoryID).collect(Collectors.toList());
        CategoryResponseDto categoryResponseDto = result.get(0);
        assertThat(categoryResponseDto.getCategoryId()).isEqualTo(updateCategoryID);
    }

    @Test
    public void 카테고리_삭제(){
        //given
        Long parameter = aLong1;
        categoryService.deleteCategory(parameter);

        //when
        List<CategoryResponseDto> categoryFirstDepth = categoryService.findByUpperCategoryId(null);
        List<CategoryResponseDto> categorySecondDepth = categoryService.findByUpperCategoryId(aLong1);

        //then
        List<CategoryResponseDto> result = categoryFirstDepth.stream().filter(categoryResponseDto -> categoryResponseDto.getCategoryId() == parameter).collect(Collectors.toList());
        assertThat(result.size()).isZero();
        assertThat(categorySecondDepth.size()).isZero();
    }
}