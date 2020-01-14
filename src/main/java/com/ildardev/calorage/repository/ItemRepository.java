package com.ildardev.calorage.repository;

import com.ildardev.calorage.domain.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findByCategoryId(String categoryId);

    boolean existsByName(String name);
}
