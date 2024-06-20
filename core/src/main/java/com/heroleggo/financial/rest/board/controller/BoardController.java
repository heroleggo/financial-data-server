package com.heroleggo.financial.rest.board.controller;

import com.heroleggo.financial.rest.board.dto.CreateBoardRequest;
import com.heroleggo.financial.rest.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
private final BoardService boardService;

    @PostMapping()
    public ResponseEntity<?> createBoard(@RequestBody CreateBoardRequest request) {
        return ResponseEntity.ok("hehe");
    }
}
