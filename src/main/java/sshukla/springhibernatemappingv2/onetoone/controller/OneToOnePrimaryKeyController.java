package sshukla.springhibernatemappingv2.onetoone.controller;

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
@RequestMapping("/v2/api/")
public class OneToOnePrimaryKeyController {

    Logger LOGGER = LoggerFactory.getLogger(OneToOnePrimaryKeyController.class);

    private final StudentRepo studentRepo;
    private final StudentInfoRepo studentInfoRepo;

    public OneToOnePrimaryKeyController(StudentRepo studentRepo, StudentInfoRepo studentInfoRepo) {
        this.studentRepo = studentRepo;
        this.studentInfoRepo = studentInfoRepo;
    }

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        LOGGER.info("Controller.createStudent() ---");
        student.setStudentId(UUID.randomUUID().toString());
        StudentInfo studentProfile = student.getStudentInfo();
        studentProfile.setStudentInfoId(UUID.randomUUID().toString());
        studentProfile.setStudent(null);
        return ResponseEntity.ok(studentRepo.save(student));
    }

    @PutMapping("/student/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        LOGGER.info("Controller.updateStudent() ---");
        Student savedStudent = studentRepo.findById(student.getStudentId()).orElseThrow(() -> new RuntimeException("Student Not Found!!!"));
        savedStudent.setName(student.getName());
        savedStudent.setHouse(student.getHouse());
        savedStudent.setStudentInfo(student.getStudentInfo());
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

    @PutMapping("/studentInfo/update")
    public ResponseEntity<StudentInfo> updateStudentInfo(@RequestBody StudentInfo studentInfo) {
        LOGGER.info("Controller.updateStudentInfo() ---");
        StudentInfo savedStudentInfo = studentInfoRepo.findById(studentInfo.getStudentInfoId()).orElseThrow(() -> new RuntimeException("StudentInfo Not Found!!!"));
        savedStudentInfo.setGrade(studentInfo.getGrade());
        return ResponseEntity.ok(studentInfoRepo.save(studentInfo));
    }

    @GetMapping("/studentInfo/all")
    public ResponseEntity<List<StudentInfo>> getAllStudentInfo() {
        LOGGER.info("Controller.getAllEmployeeInfo() ---");
        return ResponseEntity.ok(studentInfoRepo.findAll());
    }

    @GetMapping("/studentInfo/{studentInfoId}")
    public ResponseEntity<StudentInfo> getStudentInfoById(@PathVariable(value = "studentInfoId") String studentInfoId) throws Throwable {
        LOGGER.info("Controller.getStudentInfoById() ---");
        return ResponseEntity.ok(studentInfoRepo.findById(studentInfoId).orElseThrow(() -> new Exception("StudentInfoId Not Found!!!!")));
    }

    // Todo: Not performing delete
    @DeleteMapping("/studentInfo/{studentInfoId}")
    public ResponseEntity<HttpStatus> deleteStudentInfoById(@PathVariable(value = "studentInfoId") String studentInfoId) {
        LOGGER.info("Controller.deleteStudentInfoById() ---");
        studentInfoRepo.deleteById(studentInfoId);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
