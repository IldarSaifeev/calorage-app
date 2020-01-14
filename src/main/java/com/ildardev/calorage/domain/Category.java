package com.ildardev.calorage.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 * Категория еды
 */
@Data
@NoArgsConstructor
public class Category {

    @Id
    private String id;

    private String name;

    public Category(String name) {
        this.name = name;
    }
}
