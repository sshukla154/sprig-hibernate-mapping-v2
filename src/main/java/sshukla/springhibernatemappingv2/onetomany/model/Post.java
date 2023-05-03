package sshukla.springhibernatemappingv2.onetomany.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by `Seemant Shukla` on 02-05-2023
 */
@Table(name = "posts")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @Column(name = "post_id")
    private String postId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String content;
    private String description;
    private String title;

    // one to many unidirectional mapping
    // default fetch type for OneToMany: LAZY

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    @JsonIgnore
    private Set<Comment> comments = new HashSet<>();
}
