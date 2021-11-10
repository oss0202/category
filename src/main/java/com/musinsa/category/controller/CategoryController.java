package com.musinsa.category.controller;

import com.musinsa.category.dto.CategoryInsertRequestDto;
import com.musinsa.category.dto.CategoryResponseDto;
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

    /** 카테고리 - 목록 조회  */
    @GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<CategoryResponseDto>> findAll() {

        List<CategoryResponseDto> boardResponseDtoList = categoryService.findAll();

        return new ResponseEntity<>(boardResponseDtoList, HttpStatus.OK);
    }

    /** 카테고리 - 등록 */
    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> save(@RequestBody CategoryInsertRequestDto categoryInsertRequestDto) {

        Long categoryId = categoryService.save(categoryInsertRequestDto);

        return new ResponseEntity<>(categoryId, HttpStatus.CREATED);
    }
}
