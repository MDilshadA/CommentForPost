package com.CommentForPost.Controller;
import com.CommentForPost.Entity.Comment;
import com.CommentForPost.Entity.Post;
import com.CommentForPost.Service.CommentService;
import com.CommentForPost.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService,PostService postService) {
        this.commentService = commentService;
        this.postService= postService;
    }

    @DeleteMapping("/{postId}/comm")
    public String deletecommenetsByPostId(
            @PathVariable Long postId
    ){
        Post postById = postService.getPostById(postId);
        commentService.deleteCommentsByPost(postById);
        return "comment deleted";
    }

    @PostMapping
    public String CreateComments(
            @RequestParam Long postId,
            @RequestBody Comment comment
            ){
        Comment comment1 = commentService.saveCommets(comment, postId);

        return "data saved";
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getALlCommets(){
        List<Comment> getallcommets = commentService.getallcommets();
        return new ResponseEntity<>(getallcommets, HttpStatus.OK);
    }
}
