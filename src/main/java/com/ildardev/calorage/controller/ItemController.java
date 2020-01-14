package com.ildardev.calorage.controller;

import com.ildardev.calorage.domain.Item;
import com.ildardev.calorage.model.ItemDTO;
import com.ildardev.calorage.repository.ItemRepository;
import com.ildardev.calorage.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;
    private ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity createItem(@RequestBody @Valid ItemDTO item) {
        String itemId = itemService.createItem(item);
        return ResponseEntity.created(URI.create("/items/" + itemId)).build();
    }

    @PutMapping("/{itemId}")
    public ResponseEntity updateItem(@PathVariable String itemId,
                                     @RequestBody @Valid ItemDTO item) {
        itemService.updateItem(itemId, item);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/byCategory/{categoryId}")
    public List<Item> getItemsByCategory(@PathVariable String categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }
}
