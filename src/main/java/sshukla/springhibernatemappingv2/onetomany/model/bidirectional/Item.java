package sshukla.springhibernatemappingv2.onetomany.model.bidirectional;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sshukla.springhibernatemappingv2.onetomany.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by `Seemant Shukla` on 03-05-2023
 */
@Table(name = "items")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Item extends BaseEntity {

    private String itemName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate expirationDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate manufacturingDate;

    private String manufacturer;

    // default fetch type for ManyToOne: EAGER
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Cart cart;

}
