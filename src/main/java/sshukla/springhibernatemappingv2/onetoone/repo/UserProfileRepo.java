package sshukla.springhibernatemappingv2.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.springhibernatemappingv2.onetoone.model.foreignkey.UserProfile;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@Repository
public interface UserProfileRepo extends JpaRepository<UserProfile, String> {
}
