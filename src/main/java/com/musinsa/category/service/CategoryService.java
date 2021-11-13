package com.musinsa.category.service;

import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
import com.musinsa.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    /*
    카테고리 등록
     */
    public Long save(CategoryInsertRequestDto categoryInsertRequestDto){
        return categoryRepository.save(categoryInsertRequestDto.toEntity()).getCategoryId();
    }
    /*
    카테고리 조회
     */
    @Transactional(readOnly = true)
    public List<CategoryResponseDto> findAll() {
            return categoryRepository.findAll()
                    .stream()
                    .map(CategoryResponseDto::new)
                    .sorted()
                    .collect(Collectors.toList());
    }
}
