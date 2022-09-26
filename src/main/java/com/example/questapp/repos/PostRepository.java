package com.example.questapp.repos;

import com.example.questapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Long> {


    List<Post> findByUserId(Long userId);  // Jpareponun saglamis oldugu bir guzellik. findBy bir kalip bundan sonra bu objenin post objesinin icerisinde yer alan herhangi bir alanla findBy birlestirilebilir. Mesela postun neyi vardi, title, text. FindByText, findByTitle yazabiliriz





}
