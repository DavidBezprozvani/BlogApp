package com.codeacademy.blogs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "Comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "body", columnDefinition = "TEXT")
    @NotEmpty(message = "*Please write something")
    private String body;

    @Column(name = "created_on", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime updatedOn;

//    @ManyToOne
//    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
//    @NotNull
//    private Post post;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
//    @NotNull
//    private User user;
}
