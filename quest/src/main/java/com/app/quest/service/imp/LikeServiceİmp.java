package com.app.quest.service.imp;

import java.util.List;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.LikeEscapeContext;
import org.springframework.stereotype.Service;

import com.app.quest.dto.LikeCreateDto;
import com.app.quest.entity.Like;
import com.app.quest.entity.Post;
import com.app.quest.entity.User;
import com.app.quest.repos.LikeRepository;
import com.app.quest.service.LikeService;
import com.app.quest.service.PostService;
import com.app.quest.service.UserService;

@Service
public class LikeServiceİmp implements LikeService{
    private UserService userService;
    private PostService postService;
    private LikeRepository likeRepository;

    
    public LikeServiceİmp(UserService userService, PostService postService, LikeRepository likeRepository) {
        this.userService = userService;
        this.postService = postService;
        this.likeRepository = likeRepository;
    }


    @Override
    public List<Like> getAllLikes(Optional<Long> postId,Optional<Long> userId) {
        if(postId.isPresent() && userId.isPresent()){
           
           return likeRepository.findByUserIdAndPostId(userId.get(),postId.get()); 
        }
        else if(postId.isPresent()){

           return likeRepository.findByPostId(postId.get());
        }
        else if(userId.isPresent()){
            return likeRepository.findByUserId(userId.get());
        }
        else{
            return likeRepository.findAll();
        }

        
    }


    @Override
    public Like getOneLike(Long likeId) {
        
        return likeRepository.findById(likeId).orElse(null);
    }


    @Override
    public Like createLike(LikeCreateDto likeCreateDto) {
       User user = userService.getUserById(likeCreateDto.getUserId());
       Post post = postService.getOnePost(likeCreateDto.getPostId()); 
       
       if(user==null || post==null)
            return null;
        Like like = new Like();
        like.setId(likeCreateDto.getId());
        like.setUser(user);
        like.setPost(post);
        return likeRepository.save(like);
    }


    @Override
    public void deleteLike(Long likeId) {
        Optional<Like> like = likeRepository.findById(likeId);
        if(like.isPresent())
            likeRepository.deleteById(likeId);

    }
    
    
}
