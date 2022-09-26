package com.example.questapp.controllers;


import com.example.questapp.services.UserService;
import com.example.questapp.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;  //controllerlarin altinda oncelik ilgili repoyu tanimlamamiz lazim.

    public UserController(UserService userService){ //burada da constructor injection le inject ediyoruz. Spring boot benim icin userReponun bean ini bulup icerisine atayacak. qAutowired, setterinject, constructor injeck gibi methodlar var. Burda construcktor kullanildi
        this.userService = userService;
    }



    @GetMapping
    public List<User> getAllUsers(){

     return userService.getAllUsers();

    }

    @PostMapping
    public User createUser(@RequestBody User newUser ){ // post istegiyle gelen kullanicinin yazmis oldugu bilgilerdeki body kismini al yeni bir usera maple, jpanin methoduyla bu elemani db kaydet
        return userService.saveOneUser(newUser); //yeni userim bu kaydedildi
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        return userService.getOneUserById(userId);
    }


    @PutMapping("/{userId}")   // (var olan bir id li kullaniciyi guncellicek)
    public User updateOneUser(@PathVariable Long userId, @RequestBody User newUser) {

            return userService.updateOneUser(userId, newUser);
    }


     @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
     }





















}
