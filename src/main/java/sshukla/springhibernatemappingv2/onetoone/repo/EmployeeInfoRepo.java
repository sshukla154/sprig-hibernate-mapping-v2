package sshukla.springhibernatemappingv2.onetoone.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sshukla.springhibernatemappingv2.onetoone.jointable.EmployeeInfo;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@Repository
public interface EmployeeInfoRepo extends JpaRepository<EmployeeInfo, String> {
}
