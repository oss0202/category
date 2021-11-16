package com.musinsa.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class CategoryUpdateRequestDto {
    private Long categoryId;
    private String categoryNm;
    private Long upperCategoryId;
    private String categoryDc;
    private int categoryIdOrder;

    @Builder
    public CategoryUpdateRequestDto(Long categoryId, String categoryNm, Long upperCategoryId, String categoryDc, int categoryIdOrder) {
        this.categoryId = categoryId;
        this.categoryNm = categoryNm;
        this.upperCategoryId = upperCategoryId;
        this.categoryDc = categoryDc;
        this.categoryIdOrder = categoryIdOrder;
    }
}
