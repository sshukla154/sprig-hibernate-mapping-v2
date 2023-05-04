package sshukla.springhibernatemappingv2.onetomany.model.bidirectional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sshukla.springhibernatemappingv2.onetomany.model.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by `Seemant Shukla` on 03-05-2023
 */
@Table(name = "carts")
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Cart extends BaseEntity {

    private String content;
    private String description;
    private String title;

    // one to many unidirectional mapping
    // default fetch type for OneToMany: LAZY

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cart")
    private Set<Item> items = new HashSet<>();

    @Override
    public String toString() {
        return "Cart{" +
                "content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", items=" + items +
                '}';
    }
}
