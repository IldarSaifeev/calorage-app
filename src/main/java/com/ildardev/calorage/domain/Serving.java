package com.ildardev.calorage.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Один прием конкретной пищи
 */
@Data
public class Serving {

    private String id;

    /**
     * Съеденный продукт
     */
    private String itemId;

    /**
     * Кол-во единиц съеденного;
     * Например, если единица (пачка) творога - 100г, то amount = 1.5 означает, что съедено полторы пачки (150г).
     */
    private BigDecimal amount;

    /**
     * Количество съеденных калорий;
     * Если съедено 1.5 стандартные порции, то будет item.calorage * 1.5.
     */
    private BigDecimal totalCalorage;
}
