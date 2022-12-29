package com.app.quest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.quest.dto.LikeCreateDto;
import com.app.quest.entity.Like;
import com.app.quest.service.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){


        return likeService.getAllLikes(postId,userId);
    }

    @GetMapping("/{likeId}")
    public Like getOneLike(@PathVariable Long likeId){
        return likeService.getOneLike(likeId);

    }

    @PostMapping
    public Like createLike(@RequestBody LikeCreateDto likeCreateDto){

        return likeService.createLike(likeCreateDto);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Long likeId){

        likeService.deleteLike(likeId);
    }
    



}
