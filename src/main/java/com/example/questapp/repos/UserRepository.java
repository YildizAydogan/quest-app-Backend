package com.example.questapp.repos;

import com.example.questapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository <User, Long> { //bu repo hangi objeyi kullanack ve id sinin tipi ne olmali

    //JPA repo nedir?
    //Repolar bizim, db a istek, query atmamizin methodlu hali.
    // jpa reponun icinde findAll() methodu var; tüm userlara erismemizi saglayacak

}
