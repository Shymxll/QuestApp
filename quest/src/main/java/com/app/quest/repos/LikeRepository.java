package com.app.quest.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.quest.entity.Like;

public interface LikeRepository  extends JpaRepository<Like,Long>{

    List<Like> findByPostId(Long postId);

    List<Like> findByUserId(Long userId);

    List<Like> findByUserIdAndPostId(Long userId, Long postId);
    
}
