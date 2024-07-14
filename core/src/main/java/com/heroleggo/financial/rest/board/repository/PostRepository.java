package com.heroleggo.financial.rest.board.repository;

import com.heroleggo.financial.rest.board.entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    public List<Post> findAllByBoardId(Long boardId);
}
