package com.CommentForPost.Controller;

import com.CommentForPost.Entity.Post;
import com.CommentForPost.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    //http://localhost:8080/posts
    @PostMapping
    public String savePost(
            @RequestBody Post post
            ){
        Post post1 = postService.createPost(post);
        return "post saved";
    }

    @GetMapping
    public List<Post> GetALLPost(){
        List<Post> allPosts =postService.getAllPosts();
        return allPosts;
    }

    @GetMapping("/{id}")
    public Post getPostById(
            @PathVariable Long id
    ){
        Post postById = postService.getPostById(id);
        return postById;
    }

    @DeleteMapping("{id}")
    public String deletePost(
            @PathVariable Long id
    ){
        postService.deletePost(id);
        return "post is deleted";
    }
}
