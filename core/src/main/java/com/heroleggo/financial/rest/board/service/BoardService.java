package com.heroleggo.financial.rest.board.service;

import com.heroleggo.financial.rest.board.dto.CreateBoardRequest;
import com.heroleggo.financial.rest.board.entity.Board;
import java.util.List;

public interface BoardService {
    public void createBoard(CreateBoardRequest request);
    public List<Board> listBoard();
    public Board findBoardById(Long id);
    public Board findBoardByName(String name);
}
