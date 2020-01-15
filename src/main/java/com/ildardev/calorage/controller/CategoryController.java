package com.ildardev.calorage.controller;

import com.ildardev.calorage.domain.Category;
import com.ildardev.calorage.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> categories() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @PostMapping("/{name}")
    public ResponseEntity addCategory(@PathVariable String name) {
        Category category = categoryRepository.findByName(name)
                .orElseGet(() -> categoryRepository.save(new Category(name)));

        return ResponseEntity.created(URI.create("/categories/" + category.getId())).build();
    }
}
