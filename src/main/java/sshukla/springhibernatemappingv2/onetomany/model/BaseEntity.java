package sshukla.springhibernatemappingv2.onetomany.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by `Seemant Shukla` on 04-05-2023
 */

@Setter
@Getter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column(name = "id")
    private String id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
