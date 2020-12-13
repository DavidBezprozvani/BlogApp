package com.codeacademy.blogs.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @NotEmpty
    @Lob
    @Column
    private String body;

    @CreationTimestamp
    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @NotBlank
    @Column
    private String username;

    @ManyToOne
    @JoinTable
            (name = "Posts_Users",
                    joinColumns = {@JoinColumn(name = "user_id")},
                    inverseJoinColumns = {@JoinColumn(name = "post_id")})
    @NotNull
    private User user;
}
