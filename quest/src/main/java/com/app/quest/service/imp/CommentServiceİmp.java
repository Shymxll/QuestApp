package com.app.quest.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.quest.dto.CommentCreateDto;
import com.app.quest.dto.CommentUpdateDto;
import com.app.quest.entity.Comment;
import com.app.quest.entity.Post;
import com.app.quest.entity.User;
import com.app.quest.repos.CommentRepository;
import com.app.quest.service.CommentService;
import com.app.quest.service.PostService;
import com.app.quest.service.UserService;

@Service
public class CommentServiceİmp implements CommentService{
    UserService userService;
    PostService postService;
    CommentRepository commentRepository;

    
    

    public CommentServiceİmp(UserService userService, PostService postService, CommentRepository commentRepository) {
        this.userService = userService;
        this.postService = postService;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllComments(Optional<Long> postId, Optional<Long> userId) {
        if(postId.isPresent() && userId.isPresent()){
           
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get()); 
         }
         else if(postId.isPresent()){
 
            return commentRepository.findByPostId(postId.get());
         }
         else if(userId.isPresent()){
             return commentRepository.findByUserId(userId.get());
         }
         else{
             return commentRepository.findAll();
         }
 
    }

    @Override
    public Comment createComment(CommentCreateDto commentCreateDto) {
        User user = userService.getUserById(commentCreateDto.getUserId());
        Post post = postService.getOnePost(commentCreateDto.getPostId()); 
        
        if(user==null || post==null)
             return null;

        Comment comment = new Comment();
        comment.setId(commentCreateDto.getId());
        comment.setText(commentCreateDto.getText());
        comment.setUser(user);
        comment.setPost(post);
        return commentRepository.save(comment);
    
    }

    @Override
    public Comment getOneComment(Long commentId) {
       
        return commentRepository.findById(commentId).orElse(null);        
    }

    @Override
    public void deleteComment(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent())
            commentRepository.deleteById(commentId);

        
    }

    @Override
    public Comment updateComment(Long commentId,CommentUpdateDto commentUpdateDto) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment updateComment = comment.get();
            
            updateComment.setText(commentUpdateDto.getText());
             return commentRepository.save(updateComment);

        }
        return null;
    }
        
}
