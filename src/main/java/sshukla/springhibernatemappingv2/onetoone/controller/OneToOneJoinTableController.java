package sshukla.springhibernatemappingv2.onetoone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sshukla.springhibernatemappingv2.onetoone.model.jointable.Employee;
import sshukla.springhibernatemappingv2.onetoone.model.jointable.EmployeeInfo;
import sshukla.springhibernatemappingv2.onetoone.repo.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by `Seemant Shukla` on 27-04-2023
 */

@RestController
@RequestMapping("/v2/api")
public class OneToOneJoinTableController {

    Logger LOGGER = LoggerFactory.getLogger(OneToOneJoinTableController.class);

    private final EmployeeRepo employeeRepo;
    private final EmployeeInfoRepo employeeInfoRepo;

    public OneToOneJoinTableController(EmployeeRepo employeeRepo, EmployeeInfoRepo employeeInfoRepo) {
        this.employeeRepo = employeeRepo;
        this.employeeInfoRepo = employeeInfoRepo;
    }

    /**
     * Employee and Employee Info using OneToOne with Join Table approach
     */

    @PostMapping("/employee/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        LOGGER.info("Controller.createEmployee() ---");
        employee.setEmployeeId(UUID.randomUUID().toString());
        EmployeeInfo employeeInfo = employee.getEmployeeInfo();
        employeeInfo.setEmployeeInfoId(UUID.randomUUID().toString());
        employee.setEmployeeInfo(employeeInfo);
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
        return ResponseEntity.ok(employeeRepo.save(savedEmployee));
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

    @PutMapping("/employeeInfo/update")
    public ResponseEntity<EmployeeInfo> updateEmployeeInfo(@RequestBody EmployeeInfo employeeInfo) {
        LOGGER.info("Controller.updateEmployeeInfo() ---");
        EmployeeInfo savedEmployeeInfo = employeeInfoRepo.findById(employeeInfo.getEmployeeInfoId()).orElseThrow(() -> new RuntimeException("EmployeeInfo Not Found!!!"));
        savedEmployeeInfo.setCountry(employeeInfo.getCountry());
        savedEmployeeInfo.setState(employeeInfo.getState());
        savedEmployeeInfo.setCity(employeeInfo.getCity());
        savedEmployeeInfo.setPinCode(employeeInfo.getPinCode());
        savedEmployeeInfo.setPhoneNumber(employeeInfo.getPhoneNumber());
        return ResponseEntity.ok(employeeInfoRepo.save(savedEmployeeInfo));
    }

    @GetMapping("/employeeInfo/all")
    public ResponseEntity<List<EmployeeInfo>> getAllEmployeeInfo() {
        LOGGER.info("Controller.getAllEmployeeInfo() ---");
        return ResponseEntity.ok(employeeInfoRepo.findAll());
    }

    @GetMapping("/employeeInfo/{employeeInfoId}")
    public ResponseEntity<EmployeeInfo> getEmployeeInfoById(@PathVariable(value = "employeeInfoId") String employeeInfoId) throws Throwable {
        LOGGER.info("Controller.getEmployeeInfoById() ---");
        return ResponseEntity.ok(employeeInfoRepo.findById(employeeInfoId).orElseThrow(() -> new Exception("EmployeeInfo Not Found!!!!")));
    }

    // Todo: Not performing delete
    @DeleteMapping("/employeeInfo/{employeeInfoId}")
    public ResponseEntity<HttpStatus> deleteEmployeeInfoById(@PathVariable(value = "employeeInfoId") String employeeInfoId) {
        LOGGER.info("Controller.deleteEmployeeInfoById() ---");
        employeeInfoRepo.deleteById(employeeInfoId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
