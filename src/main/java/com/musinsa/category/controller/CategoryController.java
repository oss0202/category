package com.musinsa.category.controller;

import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
import com.musinsa.category.dto.CategoryUpdateRequestDto;
import com.musinsa.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/musinsa/category")
@RestController
public class CategoryController {
    private final CategoryService categoryService;

    /**
     * 카테고리 - 목록 조회
     * */
    @GetMapping(value = {"/{categoryId}","/"}, produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<CategoryResponseDto>> selectCategory(@PathVariable(value = "categoryId", required = false) Long categoryId) {
        List<CategoryResponseDto> boardResponseDtoList = categoryService.findByUpperCategoryId(categoryId);
        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    /**
     * 카테고리 - 등록
     * */
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> saveCategory(@RequestBody CategoryInsertRequestDto categoryInsertRequestDto) {
        Long categoryId = categoryService.saveCategory(categoryInsertRequestDto);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }

    /**
     * 카테고리 - 수정
     * */
    @PutMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> updateCategory(@RequestBody CategoryUpdateRequestDto categoryUpdateRequestDto) {
        Long categoryId = categoryService.updateCategory(categoryUpdateRequestDto);
        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }

    /**
     * 카테고리 - 삭제
     * */
    @DeleteMapping(value = "/{categoryId}", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(categoryId, HttpStatus.NO_CONTENT);
    }
}
