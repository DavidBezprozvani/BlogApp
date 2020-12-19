package com.codeacademy.blogs.exception;

import com.codeacademy.blogs.util.Translator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super(Translator.getMessage("post.not_found"));
    }

}
