package com.ildardev.calorage.service;

import com.ildardev.calorage.domain.Item;
import com.ildardev.calorage.exception.CategoryDoesNotExistException;
import com.ildardev.calorage.exception.ItemAlreadyExistsException;
import com.ildardev.calorage.exception.ItemNotExistException;
import com.ildardev.calorage.model.ItemDTO;
import com.ildardev.calorage.repository.CategoryRepository;
import com.ildardev.calorage.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    /**
     * @return item.id
     */
    public String createItem(@NonNull ItemDTO itemDTO) {
        if (itemRepository.existsByName(itemDTO.getName())) {
            throw new ItemAlreadyExistsException();
        }
        if (!categoryRepository.existsById(itemDTO.getCategoryId())) {
            throw new CategoryDoesNotExistException();
        }

        Item item = modelMapper.map(itemDTO, Item.class);
        return itemRepository.save(item).getId();
    }

    public void updateItem(String itemId, ItemDTO itemDTO) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(ItemNotExistException::new);
        if (!item.getName().equals(itemDTO.getName()) && itemRepository.existsByName(itemDTO.getName())) {
            throw new ItemAlreadyExistsException();
        }

        modelMapper.map(itemDTO, item);
        itemRepository.save(item);
    }
}
