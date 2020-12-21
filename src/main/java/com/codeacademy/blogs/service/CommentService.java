package com.codeacademy.blogs.service;

import com.codeacademy.blogs.exception.CommentNotFoundException;
import com.codeacademy.blogs.exception.PostNotFoundException;
import com.codeacademy.blogs.model.Comment;
import com.codeacademy.blogs.model.Post;
import com.codeacademy.blogs.repository.CommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    // get all comments paginated
    public Page<Comment> getAllPageableComments(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    // get comment by id
    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
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

    public Comment editComment(Comment commentFromModel) {
        Comment commentToEdit = commentRepository.getOne(commentFromModel.getId());
        commentToEdit.setBody(commentFromModel.getBody());
        return commentRepository.save(commentToEdit);
    }

    // remove comment (any for admin, own for user)
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

}
