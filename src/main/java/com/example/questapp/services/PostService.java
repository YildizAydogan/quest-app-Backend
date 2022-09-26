package com.example.questapp.services;


import com.example.questapp.repos.PostRepository;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;
import com.example.questapp.requestsDTO.PostCreateRequest;
import com.example.questapp.requestsDTO.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


  private PostRepository postRepository;


  private UserService userService;



    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<Post> getAllPosts(Optional<Long> userId) {
      if (userId.isPresent()){
        return postRepository.findByUserId(userId.get()); // postrepo da bu methodu create ettik oraya bak

      }return postRepository.findAll();
    }


  public Post getOnePostById(Long postId) {
      return postRepository.findById(postId).orElse(null);
  }


  public Post createOnePost(PostCreateRequest newPostRequest) {  //bir post olusturmak istiyorum ama bu gelen objede userin id si db imde var mi. Bunun icin Userservice deki getOneUser methodunu kullandik
    User user =  userService.getOneUserById(newPostRequest.getUserId()); //userin serviceine baglandik. servicenin icinde baska bir service baglandik. 20. satir
    if (user == null) {
      return null;
    }
    Post toSave= new Post();
    toSave.setId(newPostRequest.getId());
    toSave.setText(newPostRequest.getText());
    toSave.setTitle(newPostRequest.getTitle());
    toSave.setUser(user); //43. satirda db deki useri koyucaz buraya
      return postRepository.save(toSave);
  }

  public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) { //sadece text ve titke icin bir request objesi yani dto olusturulabilir.
  Optional<Post> post = postRepository.findById(postId); // bana verdigi id ile bir post var mi kontrolu yapildi
  if (post.isPresent()){
  Post toUpdate = post.get();
  toUpdate.setText(updatePost.getText());
  toUpdate.setTitle(updatePost.getTitle());
  postRepository.save(toUpdate);
  return toUpdate;

}
    return null;
  }


  public void deleteOnePostById(Long postId) {
      postRepository.deleteById(postId);
  }


}
