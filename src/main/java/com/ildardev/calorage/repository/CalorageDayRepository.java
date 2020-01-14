package com.ildardev.calorage.repository;

import com.ildardev.calorage.domain.CalorageDay;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface CalorageDayRepository extends MongoRepository<CalorageDay, String> {

    boolean existsByDate(Date date);
}
