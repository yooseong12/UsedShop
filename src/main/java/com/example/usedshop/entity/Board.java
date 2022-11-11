package com.example.usedshop.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String goodsTitle;

    private String goodsEx;

    private Integer money;

    private String uuid;

    private String folderPath;

    @Builder
    public Board(Long id, String goodsTitle, String goodsEx){
        this.id = id;
        this.goodsTitle = goodsTitle;
        this.goodsEx = goodsEx;
    }
}
