package com.ildardev.calorage.config;

import com.github.mongobee.Mongobee;
import com.ildardev.calorage.repository.Repositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = Repositories.class)
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    private String mongoHost;
    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Bean
    public Mongobee mongobee() {
        Mongobee runner = new Mongobee("mongodb://" + mongoHost + ":27017");
        runner.setDbName(mongoDatabase);
        runner.setChangeLogsScanPackage("com.ildardev.calorage.migration");

        return runner;
    }
}
