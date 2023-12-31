package com.CommentForPost.Service.impl;

import com.CommentForPost.Entity.Comment;
import com.CommentForPost.Entity.Post;
import com.CommentForPost.Repository.CommentRepository;
import com.CommentForPost.Repository.PostRepository;
import com.CommentForPost.Service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository=postRepository;
    }

    @Override
    @Transactional
    public void deleteCommentsByPost(Post post) {
        commentRepository.deleteByPost(post);
    }

    @Override
    public Comment saveCommets(Comment comment, Long postId) {
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        Comment save = commentRepository.save(comment);
        return save;
    }

    @Override
    public List<Comment> getallcommets() {
        List<Comment> all = commentRepository.findAll();
        return all;
    }
}
