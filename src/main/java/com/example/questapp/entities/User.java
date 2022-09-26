package com.example.questapp.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Data //bu annnatasyon lomboktan gelecek ve bizim icin getter ve setterlari otomatik generic etmis olacak
public class User { //db objelerimizi tutacak. Entitiy demek bu klass db a maplenecek demek

    @Id
    Long id;


    String userName;

    String password;
}
