package com.musinsa.category.dto;

import com.musinsa.category.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoryInsertRequestDto {
    private String categoryNm;
    private String upperCategoryId;
    private String categoryEp;
    private Long categoryIdOrder;

    @Builder
    public CategoryInsertRequestDto(String categoryNm, String upperCategoryId, String categoryEp, Long categoryIdOrder) {
        this.categoryNm = categoryNm;
        this.upperCategoryId = upperCategoryId;
        this.categoryEp = categoryEp;
        this.categoryIdOrder = categoryIdOrder;
    }

    public Category toEntity(){
        return Category.builder()
                .categoryNm(categoryNm)
                .upperCategoryId(upperCategoryId)
                .categoryEp(categoryEp)
                .categoryIdOrder(categoryIdOrder)
                .build();
    }
}
