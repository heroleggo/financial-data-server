package com.heroleggo.financial.rest.board.service;

import com.heroleggo.financial.rest.board.dto.CreateBoardRequest;
import com.heroleggo.financial.rest.board.entity.Board;
import com.heroleggo.financial.rest.board.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public Board createBoard(CreateBoardRequest request) {
        Board board = request.toEntity();
        return boardRepository.save(board);
    }

    @Override
    public List<Board> listBoard() {
        return boardRepository.findAll();
    }

    @Override
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    @Override
    public Board findBoardByName(String name) {
        return boardRepository.findByName(name).orElse(null);
    }
}
