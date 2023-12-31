package com.CommentForPost.Service.impl;

import com.CommentForPost.Entity.Post;
import com.CommentForPost.Repository.CommentRepository;
import com.CommentForPost.Repository.PostRepository;
import com.CommentForPost.Service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        // Other validation/logic can be added before saving
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            commentRepository.deleteByPost(post); // Deleting associated comments
            postRepository.delete(post);
        }
    }
}
