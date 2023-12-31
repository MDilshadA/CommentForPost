package com.CommentForPost.Service;

import com.CommentForPost.Entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();

    Post getPostById(Long id);

    Post createPost(Post post);

    void deletePost(Long id);
}
