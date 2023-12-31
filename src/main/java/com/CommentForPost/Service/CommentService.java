package com.CommentForPost.Service;

import com.CommentForPost.Entity.Comment;
import com.CommentForPost.Entity.Post;
import java.util.List;

public interface CommentService {
    void deleteCommentsByPost(Post post);

    Comment saveCommets(Comment comment, Long postId);

    List<Comment> getallcommets();
}
