package com.codeacademy.blogs.exception;

import com.codeacademy.blogs.util.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CommentNotFoundException extends RuntimeException {
    public CommentNotFoundException() {
        super(Translator.getMessage("comment.not_found"));
    }
}
