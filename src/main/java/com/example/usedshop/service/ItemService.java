package com.example.usedshop.service;

import com.example.usedshop.DTO.ItemDto;
import com.example.usedshop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Long save(ItemDto itemDTO){
        return itemRepository.save(itemDTO.toEntity()).getId();
    }
}
