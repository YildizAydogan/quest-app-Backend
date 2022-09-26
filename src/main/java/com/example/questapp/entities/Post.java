package com.example.questapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name="post")
public class Post {
    @Id
    Long id;

    @ManyToOne(fetch =  FetchType.LAZY) //eager olsaydi, post u cektigimde user in tum userlar gelirdi. Bu sekilde sadece ilgili user gelecek
    @JoinColumn(name = "user_id", nullable = false) //bagladigimiz column in adi
    @OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiginde bunun tüm postlari da silinsin
    @JsonIgnore
    User user;

    String title;

    @Lob
    @Column(columnDefinition = "text")  //burda hibernate in sql de String i text olarak algilayabilmesi icin columndefinition yazilir yoksa varchar(255) algilayip sayisal deger atiyor
    String text;




}
