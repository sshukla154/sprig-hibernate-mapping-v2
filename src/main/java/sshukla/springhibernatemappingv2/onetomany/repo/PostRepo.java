package sshukla.springhibernatemappingv2.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.springhibernatemappingv2.onetomany.model.Post;

/**
 * Created by `Seemant Shukla` on 02-05-2023
 */
@Repository
public interface PostRepo extends JpaRepository<Post, String> {
}
