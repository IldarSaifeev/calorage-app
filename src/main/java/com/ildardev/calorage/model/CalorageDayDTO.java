package com.ildardev.calorage.model;

import com.ildardev.calorage.domain.Serving;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CalorageDayDTO {

    /**
     * День, за который фиксируется кол-во съеденного
     */
    @NotNull
    private Date date;

    /**
     * Количество съеденных порций за день
     */
    private List<Serving> servings;

    /**
     * Дневная норма (макс. кол-во) калорий
     */
    @NotNull
    @Min(1)
    @Max(10000)
    private Integer dailyLimit;
}
