package com.ildardev.calorage.controller;

import com.ildardev.calorage.domain.CalorageDay;
import com.ildardev.calorage.model.CalorageDayDTO;
import com.ildardev.calorage.model.ServingDTO;
import com.ildardev.calorage.service.CalorageDayService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/day")
@AllArgsConstructor
public class CalorageDayController {

    private CalorageDayService calorageDayService;

    @PostMapping
    public ResponseEntity createCalorageDay(@RequestBody @Valid CalorageDayDTO calorageDay) {
        String calorageDayId = calorageDayService.createCalorageDay(calorageDay);
        return ResponseEntity.created(URI.create("/day/" + calorageDayId)).build();
    }

    @GetMapping("/{calorageDayId}")
    public ResponseEntity<CalorageDay> getCalorageDay(@PathVariable String calorageDayId) {
        return calorageDayService.getCalorageDay(calorageDayId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{calorageDayId}/serving")
    public ResponseEntity addService(@PathVariable String calorageDayId,
                                     @RequestBody @Valid ServingDTO serving) {
        calorageDayService.addServing(calorageDayId, serving);
        return ResponseEntity.ok().build();
    }
}
