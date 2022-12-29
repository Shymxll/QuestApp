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

import com.app.quest.dto.CommentCreateDto;
import com.app.quest.dto.CommentUpdateDto;
import com.app.quest.entity.Comment;
import com.app.quest.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
        


        return commentService.getAllComments(postId,userId);
    }

    @GetMapping("/{commentId}")
    public Comment getOnecomment(@PathVariable Long commentId){
        return commentService.getOneComment(commentId);
    }

    @PostMapping
    public Comment createcomment(@RequestBody CommentCreateDto commentCreateDto){

        return commentService.createComment(commentCreateDto);

    }

    @DeleteMapping("/{commentId}")
    public void deletecomment(@PathVariable Long commentId){

        commentService.deleteComment(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId,@RequestBody CommentUpdateDto commentUpdateDto){

        return commentService.updateComment(commentId,commentUpdateDto);
    }

}
