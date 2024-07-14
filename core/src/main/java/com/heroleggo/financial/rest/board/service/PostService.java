package com.heroleggo.financial.rest.board.service;

import com.heroleggo.financial.rest.board.dto.CreatePostRequest;
import com.heroleggo.financial.rest.board.entity.Post;
import java.util.List;
import java.util.Optional;

public interface PostService {
    Post createPost(CreatePostRequest request);
    List<Post> listPost();
    List<Post> listPostByBoardId(Long boardId);
    Optional<Post> getPostById(Long id);
}
