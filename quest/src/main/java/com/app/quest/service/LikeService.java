package com.app.quest.service;

import java.util.List;
import java.util.Optional;

import com.app.quest.dto.LikeCreateDto;
import com.app.quest.entity.Like;

public interface LikeService {

    List<Like> getAllLikes(Optional<Long> postId,Optional<Long> userId);

    Like getOneLike(Long likeId);

    Like createLike(LikeCreateDto likeCreateDto);

    void deleteLike(Long likeId);
    
}
