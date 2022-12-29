package com.app.quest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.quest.dto.PostCreateDto;
import com.app.quest.dto.PostUpdateDto;
import com.app.quest.entity.Post;
import com.app.quest.service.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }




    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long>  userId){
        

        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){

        return postService.getOnePost(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateDto newPostCreateDto){

        return postService.createOnePost(newPostCreateDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePostById(@PathVariable Long postId){

        postService.deletePostById(postId);
    }

    @PutMapping("/{postId}")
    public Post updatePost(@PathVariable Long postId,@RequestBody PostUpdateDto postUpdateDto){
        return postService.updatePostById(postId,postUpdateDto);

    }
    



}
    


