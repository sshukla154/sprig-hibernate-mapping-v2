package sshukla.springhibernatemappingv2.onetoone.model.jointable;

import javax.persistence.*;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@Table(name = "employees")
@Entity
public class Employee {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private String employeeId;

    private String name;
    private String department;
    private Double salary;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_employee_info",
            joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_info_id", referencedColumnName = "employee_info_id")})
    private EmployeeInfo employeeInfo;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                employeeId +
//                ", " + name + '\'' +
//                ", " + department + '\'' +
//                ", " + salary +
//                ", " + employeeInfo +
//                '}';
//    }
}
