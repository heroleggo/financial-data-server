package com.heroleggo.financial.rest.board.controller;

import com.heroleggo.financial.rest.board.dto.CreateBoardRequest;
import com.heroleggo.financial.rest.board.entity.Board;
import com.heroleggo.financial.rest.board.service.BoardService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
private final BoardService boardService;

    @GetMapping()
    public ResponseEntity<?> listBoard() {
        return ResponseEntity.ok(boardService.listBoard());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findBoardById(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.findBoardById(id));
    }

    @PostMapping()
    public ResponseEntity<?> createBoard(@RequestBody CreateBoardRequest request) {
        Board board = boardService.createBoard(request);

        URI resourceURI = URI.create("/api/boards/"+board.getId());

        return ResponseEntity.created(resourceURI).body(board);
    }
}
