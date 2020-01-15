package com.ildardev.calorage.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Единица еды (продукт)
 */
@Data
@Document
public class Item {

    @Id
    private String id;

    /**
     * Название еды (творог, грудка и т.д.)
     */
    private String name;

    /**
     * Категория, в которую входит данный продукт
     */
    private String categoryId;

    /**
     * Масса продукта в одной порции
     */
    private Integer weight;

    /**
     * Количество калорий в одной порции (измерямой в граммах weight)
     */
    private Integer calorage;
}
