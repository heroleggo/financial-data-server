package com.heroleggo.financial.rest.board.dto;

import com.heroleggo.financial.rest.board.entity.Board;
import com.heroleggo.financial.rest.board.entity.Post;
import lombok.Data;

@Data
public class CreatePostRequest {
    private String title;
    private String content;
    private Long boardId;

    public Post toEntity() {
        return Post.builder()
            .title(title)
            .content(content)
            .board(Board.of(boardId))
            .build();
    }
}
