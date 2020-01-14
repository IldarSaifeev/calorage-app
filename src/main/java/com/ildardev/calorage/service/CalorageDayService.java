package com.ildardev.calorage.service;

import com.ildardev.calorage.domain.CalorageDay;
import com.ildardev.calorage.domain.Serving;
import com.ildardev.calorage.exception.CalorageDayExistsException;
import com.ildardev.calorage.exception.CalorageDayNotExistException;
import com.ildardev.calorage.exception.ItemNotExistException;
import com.ildardev.calorage.model.CalorageDayDTO;
import com.ildardev.calorage.model.ServingDTO;
import com.ildardev.calorage.repository.CalorageDayRepository;
import com.ildardev.calorage.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CalorageDayService {

    private CalorageDayRepository calorageDayRepository;
    private ItemRepository itemRepository;
    private ModelMapper modelMapper;

    /**
     * @return calorageDay.id
     */
    public String createCalorageDay(@NonNull CalorageDayDTO calorageDayDTO) {
        if (calorageDayRepository.existsByDate(calorageDayDTO.getDate())) {
            throw new CalorageDayExistsException();
        }

        CalorageDay calorageDay = modelMapper.map(calorageDayDTO, CalorageDay.class);
        return calorageDayRepository.save(calorageDay).getId();
    }

    public Optional<CalorageDay> getCalorageDay(String calorageDayId) {
        return calorageDayRepository.findById(calorageDayId);
    }

    public void addServing(String calorageDayId, @NonNull ServingDTO servingDTO) {
        CalorageDay calorageDay = calorageDayRepository.findById(calorageDayId)
                .orElseThrow(CalorageDayNotExistException::new);
        itemRepository.findById(servingDTO.getItemId())
                .orElseThrow(ItemNotExistException::new);

        Serving serving = modelMapper.map(servingDTO, Serving.class);
        calorageDay.getServings().add(serving);
        calorageDayRepository.save(calorageDay);
    }
}
