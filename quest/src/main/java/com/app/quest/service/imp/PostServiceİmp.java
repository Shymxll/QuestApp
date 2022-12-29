package com.app.quest.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.quest.dto.PostCreateDto;
import com.app.quest.dto.PostUpdateDto;
import com.app.quest.entity.Post;
import com.app.quest.entity.User;
import com.app.quest.repos.PostRepository;
import com.app.quest.service.PostService;
import com.app.quest.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
public class PostServiceİmp implements PostService{
    private PostRepository postRepository;
    private UserService userSercive;
    

    public PostServiceİmp(PostRepository postRepository, UserService userSercive) {
        this.postRepository = postRepository;
        this.userSercive = userSercive;
    }

    @Override
    public List<Post> getAllPosts(Optional<Long> userId) {
        if(userId.isPresent())
           return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    @Override
    public void deletePostById(Long postId) {
         postRepository.deleteById(postId);
        
    }

    @Override
    public Post getOnePost(Long postId) {
        // Tek bir post getirme
       
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Post createOnePost(PostCreateDto newPostCreateDto) {
        // yeni post olusturma
        User user = userSercive.getUserById(newPostCreateDto.getUserId());
        if(user==null)
            return null;
        
        Post newPost = new Post();
        newPost.setId(newPostCreateDto.getId());
        newPost.setText(newPostCreateDto.getText());
        newPost.setTitle(newPostCreateDto.getTitle());
        newPost.setUser(user);
        return postRepository.save(newPost
        );
    }

    @Override
    public Post updatePostById(Long postId, PostUpdateDto postUpdateDto) {
        Optional<Post> post = postRepository.findById(postId);
        
        if(post.isPresent()){
            Post tPost = post.get();
            tPost.setText(postUpdateDto.getText());
            tPost.setTitle(postUpdateDto.getTitle());
            return postRepository.save(tPost);
        }
        return null;
        
    }
        
    
    


}
