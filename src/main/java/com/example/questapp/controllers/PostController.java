package com.example.questapp.controllers;

import com.example.questapp.services.PostService;
import com.example.questapp.entities.Post;
import com.example.questapp.requestsDTO.PostCreateRequest;
import com.example.questapp.requestsDTO.PostUpdateRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

   private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId){ //requestparam sonrasinda yazilan tüm parametreleri yan yana yazip pars eder
                                                                        //requestin icindeki parametreleri parcalayip aliyor
    return postService.getAllPosts(userId);

    }

    @GetMapping("/{postId}")
    public Post getOnePost(@PathVariable Long postId){  //digeri path in kendisinde yani slash tan sonra path deki degiskenin degerini postId nin icerisine atiyor

        return postService.getOnePostById(postId);

    }


    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){ //sadece post objesini body den aldi
        return postService.createOnePost(newPostRequest); //dto dan post olayina girdik. Service bunu sak diye almicak. Oncelikle Validation yapmamiz lazim

    }


    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost){

        return postService.updateOnePostById(postId, updatePost);
    }


    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId){
       postService.deleteOnePostById(postId);
    }




}
