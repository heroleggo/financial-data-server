package com.heroleggo.financial.rest.board.service;

import com.heroleggo.financial.rest.board.dto.CreatePostRequest;
import com.heroleggo.financial.rest.board.entity.Post;
import com.heroleggo.financial.rest.board.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Override
    public Post createPost(CreatePostRequest request) {
        Post post = request.toEntity();

        postRepository.save(post);
        return post;
    }

    @Override
    public List<Post> listPostByBoardId(Long boardId) {
        return postRepository.findAllByBoardId(boardId);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> listPost() {
        return postRepository.findAll();
    }
}
