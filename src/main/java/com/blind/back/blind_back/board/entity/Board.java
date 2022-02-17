package com.blind.back.blind_back.board.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long no;

    @NotNull
    @Size(min=2, max=100, message="제목은 2자 이상 50자 미만입니다.")
    private String title;

    @NotNull
    private String contents;
}
