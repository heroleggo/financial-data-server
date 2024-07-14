package com.heroleggo.financial.rest.board.controller;

import com.heroleggo.financial.rest.board.dto.CreatePostRequest;
import com.heroleggo.financial.rest.board.entity.Post;
import com.heroleggo.financial.rest.board.service.PostService;
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
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping()
    public ResponseEntity<?> listPost() {
        return ResponseEntity.ok(postService.listPost());
    }

    @GetMapping("boards/{boardId}")
    public ResponseEntity<?> listPostByBoardId(@PathVariable Long boardId) {
        return ResponseEntity.ok(postService.listPostByBoardId(boardId));
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody CreatePostRequest request) {
        Post post = postService.createPost(request);

        URI resourceURI = URI.create("/api/posts" + post.getId());

        return ResponseEntity.created(resourceURI).body(post);
    }
}
