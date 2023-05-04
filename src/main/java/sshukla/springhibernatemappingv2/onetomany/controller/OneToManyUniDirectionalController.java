package sshukla.springhibernatemappingv2.onetomany.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshukla.springhibernatemappingv2.onetomany.model.unidirectional.Comment;
import sshukla.springhibernatemappingv2.onetomany.model.unidirectional.Post;
import sshukla.springhibernatemappingv2.onetomany.repo.CommentRepo;
import sshukla.springhibernatemappingv2.onetomany.repo.PostRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Created by `Seemant Shukla` on 02-05-2023
 */

@RestController
@RequestMapping("/onetomany/uni/v1/api")
public class OneToManyUniDirectionalController {

    Logger LOGGER = LoggerFactory.getLogger(OneToManyUniDirectionalController.class);

    private final PostRepo postRepo;
    private final CommentRepo commentRepo;

    public OneToManyUniDirectionalController(PostRepo postRepo, CommentRepo commentRepo) {
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

    @PostMapping("/post/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        LOGGER.info("Controller.createPost() ---");
        post.setPostId(UUID.randomUUID().toString());
        post.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(postRepo.save(post));
    }

    @PutMapping("/post/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        LOGGER.info("Controller.updatePost() ---");
        Post savedPost = postRepo.findById(post.getPostId()).orElseThrow(() -> new RuntimeException("Post Not Found!!!"));
        savedPost.setContent(post.getContent());
        savedPost.setDescription(post.getDescription());
        savedPost.setTitle(post.getTitle());
        savedPost.setUpdatedAt(LocalDateTime.now());
        return ResponseEntity.ok(postRepo.save(savedPost));
    }

    @GetMapping("/post/all")
    public ResponseEntity<List<Post>> getAllPost() {
        LOGGER.info("Controller.getAllPost() ---");
        return ResponseEntity.ok(postRepo.findAll());
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "postId") String postId) throws Throwable {
        LOGGER.info("Controller.getPostById() ---");
        return ResponseEntity.ok(postRepo.findById(postId).orElseThrow(() -> new Exception("Post Not Found!!!!")));
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<HttpStatus> deletePostById(@PathVariable(value = "postId") String postId) {
        LOGGER.info("Controller.deletePostById() ---");

        Post savedPost = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post Not Found!!!"));
        savedPost.getComments().stream().findAny().ifPresent(comment -> {
            try {
                throw new Exception("Comment Exists for this Post, Please delete the comment first!!!");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/comment/create")
    public ResponseEntity<Comment> createComment(@RequestParam("postId") String postId, @RequestBody Comment comment) throws Exception {
        LOGGER.info("Controller.createComment() ---");
        Post post = postRepo.findById(postId).orElseThrow(() -> new Exception("Post Not Found!!!!"));;
        comment.setCommentId(UUID.randomUUID().toString());
        comment.setCreatedAt(LocalDateTime.now());
        commentRepo.save(comment);
        post.getComments().add(comment);
        postRepo.save(post);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/comment/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        LOGGER.info("Controller.updateComment() ---");
        Comment savedComment = commentRepo.findById(comment.getCommentId()).orElseThrow(() -> new RuntimeException("Comment Not Found!!!"));
        savedComment.setUpdatedAt(LocalDateTime.now());
        savedComment.setText(comment.getText());
        return ResponseEntity.ok(commentRepo.save(savedComment));
    }

    @GetMapping("/comment/all")
    public ResponseEntity<List<Comment>> getAllComment() {
        LOGGER.info("Controller.getAllComment() ---");
        return ResponseEntity.ok(commentRepo.findAll());
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable(value = "commentId") String commentId) throws Throwable {
        LOGGER.info("Controller.getCommentById() ---");
        return ResponseEntity.ok(commentRepo.findById(commentId).orElseThrow(() -> new Exception("Comment Not Found!!!!")));
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<HttpStatus> deleteCommentById(@PathVariable(value = "commentId") String commentId) {
        LOGGER.info("Controller.deleteCommentById() ---");
        commentRepo.deleteById(commentId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
