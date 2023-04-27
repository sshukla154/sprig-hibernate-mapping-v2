package sshukla.springhibernatemappingv2.onetoone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshukla.springhibernatemappingv2.onetoone.foreignkey.User;
import sshukla.springhibernatemappingv2.onetoone.foreignkey.UserProfile;
import sshukla.springhibernatemappingv2.onetoone.jointable.Employee;
import sshukla.springhibernatemappingv2.onetoone.jointable.EmployeeInfo;
import sshukla.springhibernatemappingv2.onetoone.primarykey.Student;
import sshukla.springhibernatemappingv2.onetoone.primarykey.StudentInfo;
import sshukla.springhibernatemappingv2.onetoone.repo.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@RestController
@RequestMapping("/v2/api")
public class OneToOneController {

    Logger LOGGER = LoggerFactory.getLogger(OneToOneController.class);

    private final EmployeeRepo employeeRepo;
    private final EmployeeInfoRepo employeeInfoRepo;
    private final UserRepo userRepo;
    private final UserProfileRepo userProfileRepo;
    private final StudentRepo studentRepo;
    private final StudentInfoRepo studentInfoRepo;

    public OneToOneController(EmployeeRepo employeeRepo, EmployeeInfoRepo employeeInfoRepo, UserRepo userRepo, UserProfileRepo userProfileRepo, StudentRepo studentRepo, StudentInfoRepo studentInfoRepo) {
        this.employeeRepo = employeeRepo;
        this.employeeInfoRepo = employeeInfoRepo;
        this.userRepo = userRepo;
        this.userProfileRepo = userProfileRepo;
        this.studentRepo = studentRepo;
        this.studentInfoRepo = studentInfoRepo;
    }

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        LOGGER.info("Controller.createEmployee() ---");
        employee.setEmployeeId(UUID.randomUUID().toString());
        EmployeeInfo employeeInfo = employee.getEmployeeInfo();
        employeeInfo.setEmployeeInfoId(UUID.randomUUID().toString());
        return ResponseEntity.ok(employeeRepo.save(employee));
    }

    @PutMapping("/employee/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        LOGGER.info("Controller.updateEmployee() ---");
        Employee savedEmployee = employeeRepo.findById(employee.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee Not Found!!!"));
        savedEmployee.setName(employee.getName());
        savedEmployee.setDepartment(employee.getDepartment());
        savedEmployee.setSalary(employee.getSalary());
        savedEmployee.setEmployeeInfo(employee.getEmployeeInfo());
        return ResponseEntity.ok(employeeRepo.save(employee));
    }

    @GetMapping("/employee/all")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        LOGGER.info("Controller.getAllEmployee() ---");
        return ResponseEntity.ok(employeeRepo.findAll());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "employeeId") String employeeId) throws Throwable {
        LOGGER.info("Controller.getEmployeeById() ---");
        return ResponseEntity.ok(employeeRepo.findById(employeeId).orElseThrow(() -> new Exception("Employee Not Found!!!!")));
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable(value = "employeeId") String employeeId) {
        LOGGER.info("Controller.deleteEmployeeById() ---");
        employeeRepo.deleteById(employeeId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        LOGGER.info("Controller.createUser() ---");
        user.setId(UUID.randomUUID().toString());
        UserProfile userProfile = user.getUserProfile();
        userProfile.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(userRepo.save(user));
    }

    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUser() {
        LOGGER.info("Controller.getAllUser() ---");
        return ResponseEntity.ok(userRepo.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") String userId) throws Throwable {
        LOGGER.info("Controller.getUserById() ---");
        return ResponseEntity.ok(userRepo.findById(userId).orElseThrow(() -> new Exception("User Not Found!!!!")));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable(value = "userId") String userId) {
        LOGGER.info("Controller.deleteUserById() ---");
        userRepo.deleteById(userId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        LOGGER.info("Controller.createUser() ---");
        student.setStudentId(UUID.randomUUID().toString());
        StudentInfo studentProfile = student.getStudentInfo();
        studentProfile.setStudentInfoId(UUID.randomUUID().toString());
        studentProfile.setStudent(null);
        return ResponseEntity.ok(studentRepo.save(student));
    }

    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        LOGGER.info("Controller.getAllStudent() ---");
        return ResponseEntity.ok(studentRepo.findAll());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "studentId") String studentId) throws Throwable {
        LOGGER.info("Controller.getStudentById() ---");
        return ResponseEntity.ok(studentRepo.findById(studentId).orElseThrow(() -> new Exception("Student Not Found!!!!")));
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable(value = "studentId") String studentId) {
        LOGGER.info("Controller.deleteStudentById() ---");
        studentRepo.deleteById(studentId);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
