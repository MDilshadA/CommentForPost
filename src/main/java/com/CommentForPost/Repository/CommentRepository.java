package com.CommentForPost.Repository;

import com.CommentForPost.Entity.Comment;
import com.CommentForPost.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
//    @Modifying
//    @Query("DELETE FROM Comment c WHERE c.post = :post")
    void deleteByPost(Post post);
    // Add custom methods if needed
}
