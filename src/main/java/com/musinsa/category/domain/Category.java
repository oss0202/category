package com.musinsa.category.domain;

import com.musinsa.common.CommonEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "CT_CATEGORY")
public class Category extends CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String categoryNm;

    @Column
    private Long upperCategoryId;

    @Column
    private String categoryDc;

    @Column(nullable = false)
    private Long categoryIdOrder;

    @Builder
    public Category(Long categoryId, String categoryNm, Long upperCategoryId, String categoryDc, Long categoryIdOrder) {
        this.categoryId = categoryId;
        this.categoryNm = categoryNm;
        this.upperCategoryId = upperCategoryId;
        this.categoryDc = categoryDc;
        this.categoryIdOrder = categoryIdOrder;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryNm='" + categoryNm + '\'' +
                ", upperCategoryId='" + upperCategoryId + '\'' +
                ", categoryDc='" + categoryDc + '\'' +
                ", categoryIdOrder=" + categoryIdOrder +
                '}';
    }
}
