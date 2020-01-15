package com.ildardev.calorage.migration;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import lombok.extern.slf4j.Slf4j;

@ChangeLog
@Slf4j
public class CategoryMigration_2020_01_15 {

    @ChangeSet(order = "001", id = "CategoryMigration_2020_01_15_001", author = "ildar")
    public void fillPrimaryCategories(DB db) {
        log.info("Filling primary categories.");
        DBCollection collection = db.getCollection("category");

        BasicDBObject cat = new BasicDBObject("name", "Молочные продукты");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Сладости");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Каши");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Макароны");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Замороженные блюда");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Хлебобулочные изделия");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Выпечка");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Овощи");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Фрукты");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Орехи");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Еда на заказ");
        collection.insert(cat);
        cat = new BasicDBObject("name", "Другое");
        collection.insert(cat);
    }
}
