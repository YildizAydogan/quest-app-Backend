package com.example.questapp.requestsDTO;


import lombok.Data;

@Data
public class CommentCreateRequest {


    Long Id;
    Long userId;
    Long postId;
    String text;


}
