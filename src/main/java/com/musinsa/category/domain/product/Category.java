package com.musinsa.category.domain.product;

import com.musinsa.category.domain.common.CommonEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
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

    @Builder
    public Category(Long categoryId, String categoryNm, String upperCategoryId, String categoryEp) {
        this.categoryId = categoryId;
        this.categoryNm = categoryNm;
        this.upperCategoryId = upperCategoryId;
        this.categoryEp = categoryEp;
    }
}
