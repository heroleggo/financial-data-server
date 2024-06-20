package com.heroleggo.financial.rest.board.dto;


import com.heroleggo.financial.rest.board.entity.Board;

public class CreateBoardRequest {
    private String name;

    public Board toEntity() {
        return Board.builder()
            .name(name)
            .build();
    }
}
