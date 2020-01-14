package com.ildardev.calorage.service;

import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MongoQueryService {

    private MongoTemplate mongoTemplate;


}
