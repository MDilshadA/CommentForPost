package com.CommentForPost.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // Other attributes, getters, setters, constructors

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)



    private List<Comment> comments = new ArrayList<>();

    // Getters, setters, and methods to manage comments
//    public void addComment(Comment comment) {
//        comments.add(comment);
//        comment.setPost(this);
//    }
//
//    public void removeComment(Comment comment) {
//        comments.remove(comment);
//        comment.setPost(null);
//    }
}
