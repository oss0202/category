package com.musinsa.category.dto;

import com.musinsa.category.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryResponseDto {
    private Long categoryId;
    private String categoryNm;
    private Long upperCategoryId;
    private String categoryDc;
    private int categoryIdOrder;

    public CategoryResponseDto(Category category) {
        this.categoryId = category.getCategoryId();
        this.categoryNm = category.getCategoryNm();
        this.upperCategoryId = category.getUpperCategoryId();
        this.categoryDc = category.getCategoryDc();
        this.categoryIdOrder = category.getCategoryIdOrder();
    }

    @Override
    public String toString() {
        return "CategoryResponseDto{" +
                "categoryId=" + categoryId +
                ", categoryNm='" + categoryNm + '\'' +
                ", upperCategoryId='" + upperCategoryId + '\'' +
                ", categoryDc='" + categoryDc + '\'' +
                ", categoryIdOrder=" + categoryIdOrder +
                '}';
    }
}
