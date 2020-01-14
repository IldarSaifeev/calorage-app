package com.ildardev.calorage.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ItemDTO {

    /**
     * Название еды (творог, грудка и т.д.)
     */
    @NotEmpty
    private String name;

    /**
     * Категория, в которую входит данный продукт
     */
    @NotEmpty
    private String categoryId;

    /**
     * Масса продукта в одной порции (грамм)
     */
    @NotNull
    @Min(1)
    @Max(1000)
    private Integer weight;

    /**
     * Количество калорий в одной порции (в weight граммах)
     */
    @NotNull
    @Min(1)
    @Max(1000)
    private Integer calorage;
}
