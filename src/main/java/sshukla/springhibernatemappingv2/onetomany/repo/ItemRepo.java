package sshukla.springhibernatemappingv2.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.springhibernatemappingv2.onetomany.model.bidirectional.Item;

/**
 * Created by `Seemant Shukla` on 03-05-2023
 */

@Repository
public interface ItemRepo extends JpaRepository<Item, String> {
}
