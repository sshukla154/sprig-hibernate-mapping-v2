package sshukla.springhibernatemappingv2.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.springhibernatemappingv2.onetoone.primarykey.StudentInfo;

/**
 * Created by `Seemant Shukla` on 27-04-2023
 */

@Repository
public interface StudentInfoRepo extends JpaRepository<StudentInfo, String> {
}
