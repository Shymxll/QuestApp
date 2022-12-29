package com.app.quest.service;

import java.util.List;
import java.util.Optional;

import com.app.quest.dto.PostCreateDto;
import com.app.quest.dto.PostUpdateDto;
import com.app.quest.entity.Post;

public interface PostService {

    List<Post> getAllPosts(Optional<Long> userId);

    Post getOnePost(Long postId);

    Post createOnePost(PostCreateDto newPost);

    void deletePostById(Long postId);

    Post updatePostById(Long postId, PostUpdateDto postUpdateDto);


}
