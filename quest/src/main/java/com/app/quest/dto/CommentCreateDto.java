package com.app.quest.dto;

import lombok.Data;

@Data
public class CommentCreateDto {
    
    Long id;
    Long userId;
    Long postId;
    String text;
}
