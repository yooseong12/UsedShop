package com.example.usedshop.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "item_name")
    private String itemName;
    private Integer quantity;
    @Column(nullable = true, name = "file_id")
    private Long fileId;

    @Builder
    public Item(Long id,String itemName, Integer quantity, Long fileId) {
        this.id = id;
        this.itemName = itemName;
        this.quantity = quantity;
        this.fileId = fileId;
    }
}
