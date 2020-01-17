package com.ildardev.calorage.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Один прием конкретной пищи
 */
@Data
public class ServingDTO {

    private String id;

    /**
     * Съеденный продукт
     */
    @NotEmpty
    private String itemId;

    /**
     * Кол-во единиц съеденного;
     * Например, если единица (пачка) творога - 100г, то amount = 1.5 означает, что съедено полторы пачки (150г).
     */
    @NotNull
    @Min(0)
    @Max(100)
    private BigDecimal amount;

    /**
     * Количество съеденных калорий;
     * Если съедено 1.5 стандартные порции, то будет item.calorage * 1.5.
     */
    @NotNull
    @Min(0)
    @Max(5000)
    private BigDecimal totalCalorage;
}
