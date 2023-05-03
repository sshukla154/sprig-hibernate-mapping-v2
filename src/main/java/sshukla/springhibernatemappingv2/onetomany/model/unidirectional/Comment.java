package sshukla.springhibernatemappingv2.onetomany.model.unidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by `Seemant Shukla` on 02-05-2023
 */
@Table(name = "comments")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @Column(name = "comment_id")
    private String commentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String text;
}
