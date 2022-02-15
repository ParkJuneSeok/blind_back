package com.blind.back.blind_back.board.vo;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long no;
    private String title;
    private String contents;
}
