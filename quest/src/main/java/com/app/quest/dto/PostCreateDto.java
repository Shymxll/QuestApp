package com.app.quest.dto;

import lombok.Data;

@Data
public class PostCreateDto {
    Long id;
    String title;
    String text;
    Long userId;
}
