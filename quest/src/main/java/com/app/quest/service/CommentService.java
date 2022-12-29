package com.app.quest.service;

import java.util.List;
import java.util.Optional;

import com.app.quest.dto.CommentCreateDto;
import com.app.quest.dto.CommentUpdateDto;
import com.app.quest.entity.Comment;

public interface CommentService {

    List<Comment> getAllComments(Optional<Long> postId, Optional<Long> userId);

    Comment getOneComment(Long commentId);

    void deleteComment(Long commentId);

    Comment createComment(CommentCreateDto commentCreateDto);

    Comment updateComment(Long commentId, CommentUpdateDto commentUpdateDto);

}
