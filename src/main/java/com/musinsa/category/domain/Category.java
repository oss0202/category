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

    @Column
    private String categoryNm;

    @Column
    private String upperCategoryId;

    @Column
    private String categoryEp;

    @Column
    private Long categoryIdOrder;

    @Builder
    public Category(Long categoryId, String categoryNm, String upperCategoryId, String categoryEp, Long categoryIdOrder) {
        this.categoryId = categoryId;
        this.categoryNm = categoryNm;
        this.upperCategoryId = upperCategoryId;
        this.categoryEp = categoryEp;
        this.categoryIdOrder = categoryIdOrder;
    }
}
