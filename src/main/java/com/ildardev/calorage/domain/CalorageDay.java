package com.ildardev.calorage.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
public class CalorageDay {

    @Id
    private String id;

    /**
     * День, за который фиксируется кол-во съеденного
     */
    private Date date;

    /**
     * Пользователь
     */
    private String userLogin;

    /**
     * Количество съеденных порций за день
     */
    private List<Serving> servings = new ArrayList<>();

    /**
     * Дневная норма (макс. кол-во) калорий
     */
    private int dailyLimit;

    public BigDecimal getTotalCalorage() {
        return servings.stream()
                .map(Serving::getTotalCalorage)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
