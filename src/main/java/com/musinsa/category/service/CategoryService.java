package com.musinsa.category.service;

import com.musinsa.category.domain.Category;
import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
import com.musinsa.category.dto.CategoryUpdateRequestDto;
import com.musinsa.category.repository.CategoryRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.h2.util.StringUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.musinsa.category.domain.QCategory.category;

//@RequiredArgsConstructor
@Service
public class CategoryService extends QuerydslRepositorySupport {

    private final CategoryRepository categoryRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public CategoryService(CategoryRepository categoryRepository, JPAQueryFactory jpaQueryFactory) {
        super(CategoryService.class);
        this.categoryRepository = categoryRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    /*
        카테고리 등록
         */
    public Long save(CategoryInsertRequestDto categoryInsertRequestDto){
        return categoryRepository.save(categoryInsertRequestDto.toEntity()).getCategoryId();
    }
    /*
    카테고리 모두조회
     */
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> findAll() {
            return categoryRepository.findAll()
                    .stream()
                    .map(CategoryResponseDto::new)
                    .sorted()
                    .collect(Collectors.toList());
    }

    /*
    카테고리 조건조회
     */
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> findByUpperCategoryId(Long upperCategoryId) {
        return jpaQueryFactory.selectFrom(category)
        .where(eqUpperCategoryId(upperCategoryId))
//        .where(category.upperCategoryId.eq(upperCategoryId))
        .fetch()
                .stream()
                .map(CategoryResponseDto::new)
                .collect(Collectors.toList());
    }
    /*
    카테고리 업데이트
     */
    @Transactional
    public Long update(CategoryUpdateRequestDto categoryUpdateRequestDto){
        Optional<Category> category = categoryRepository.findById(categoryUpdateRequestDto.getCategoryId());

        category.ifPresent(selectCategory -> {
            selectCategory.update(categoryUpdateRequestDto.getCategoryNm(), categoryUpdateRequestDto.getUpperCategoryId(), categoryUpdateRequestDto.getCategoryDc(), categoryUpdateRequestDto.getCategoryIdOrder());
            categoryRepository.save(selectCategory);
        });

        return categoryUpdateRequestDto.getCategoryId();
    }
    /*
    카테고리 지우기
     */
    @Transactional
    public Long delete(Long categoryId){
        Optional<Category> category = categoryRepository.findById(categoryId);
        category.ifPresent(selectCategory -> {
           categoryRepository.deleteById(categoryId);
           categoryRepository.deleteByUpperCategoryId(categoryId);
        });
        return category.get().getCategoryId();
    }

    private BooleanExpression eqUpperCategoryId(Long upperCategoryId){
        if(upperCategoryId==null){
            return null;
        }
        return category.upperCategoryId.eq(upperCategoryId);
    }
}
