package com.example.questapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comment")
public class Comment {

    @Id
    Long id;

    @ManyToOne(fetch =  FetchType.LAZY) //eager olsaydi, post u cektigimde  tum userlar gelirdi. Bu sekilde sadece ilgili user gelecek
    @JoinColumn(name = "post_id", nullable = false) //bagladigimiz column in adi
    @OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiginde bunun tüm postlari da silinsin
    @JsonIgnore
    Post post;



    @ManyToOne(fetch =  FetchType.LAZY) //eager olsaydi, post u cektigimde user in tum userlar gelirdi. Bu sekilde sadece ilgili user gelecek
    @JoinColumn(name = "user_id", nullable = false) //bagladigimiz column in adi
    @OnDelete(action = OnDeleteAction.CASCADE) //bir user silindiginde bunun tüm postlari da silinsin
    @JsonIgnore
    User user;

    @Lob
    @Column(columnDefinition = "text")
    String text;





}
