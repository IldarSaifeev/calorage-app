package com.ildardev.calorage.controller;

import com.ildardev.calorage.service.MongoQueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

@RestController
@RequestMapping("/stats")
@AllArgsConstructor
public class StatsController {

    private MongoQueryService mongoQueryService;

    @GetMapping("/averageCalorage")
    public ResponseEntity<BigDecimal> averageCalorage(Principal principal,
                                                      @RequestParam("from") Date from,
                                                      @RequestParam("to") Date to) {
        BigDecimal result = mongoQueryService.averageCalorage(principal.getName(), from, to);
        return ResponseEntity.ok(result);
    }
}
