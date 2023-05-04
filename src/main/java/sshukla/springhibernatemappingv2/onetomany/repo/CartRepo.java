package sshukla.springhibernatemappingv2.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.springhibernatemappingv2.onetomany.model.bidirectional.Cart;

/**
 * Created by `Seemant Shukla` on 04-05-2023
 */

@Repository
public interface CartRepo extends JpaRepository<Cart, String> {
}
