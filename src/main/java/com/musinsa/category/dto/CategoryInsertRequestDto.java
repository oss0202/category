package com.musinsa.category.dto;

import com.musinsa.category.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryInsertRequestDto {
    private String categoryNm;
    private Long upperCategoryId;
    private String categoryDc;
    private Long categoryIdOrder;

    @Builder
    public CategoryInsertRequestDto(String categoryNm, Long upperCategoryId, String categoryDc, Long categoryIdOrder) {
        this.categoryNm = categoryNm;
        this.upperCategoryId = upperCategoryId;
        this.categoryDc = categoryDc;
        this.categoryIdOrder = categoryIdOrder;
    }

    public Category toEntity(){
        return Category.builder()
                .categoryNm(categoryNm)
                .upperCategoryId(upperCategoryId)
                .categoryDc(categoryDc)
                .categoryIdOrder(categoryIdOrder)
                .build();
    }
}
