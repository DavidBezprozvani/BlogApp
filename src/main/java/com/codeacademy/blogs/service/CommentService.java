package com.codeacademy.blogs.service;

import com.codeacademy.blogs.exception.CommentNotFoundException;
import com.codeacademy.blogs.exception.PostNotFoundException;
import com.codeacademy.blogs.model.Comment;
import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // add comment
    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    // edit comment (any for admin, own for user)
    public void editComment(Long id, Comment newComment) {
        Comment existingComment = getCommentById(id);
        existingComment.setBody(newComment.getBody());
        existingComment.setUpdatedOn(LocalDateTime.now());
        commentRepository.save(existingComment);
    }

    // remove comment (any for admin, own for user)


    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
    }
}
