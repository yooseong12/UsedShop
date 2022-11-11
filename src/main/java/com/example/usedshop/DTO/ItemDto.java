package com.example.usedshop.DTO;

import com.example.usedshop.entity.Item;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ItemDto {
    private Long id;
    private String itemName;
    private Integer quantity;
    private Long fileId;

    public Item toEntity(){
        return Item.builder()
                .id(this.id)
                .itemName(this.itemName)
                .quantity(this.quantity)
                .fileId(this.fileId)
                .build();
    }

    @Builder
    public ItemDto(String itemName, Integer quantity, Long fileId){
        this.itemName = itemName;
        this.quantity = quantity;
        this.fileId = fileId;
    }
}
