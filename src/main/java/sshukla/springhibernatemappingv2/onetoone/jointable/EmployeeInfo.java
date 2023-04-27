package sshukla.springhibernatemappingv2.onetoone.jointable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@Table(name = "employee_infos")
@Entity
public class EmployeeInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_info_id")
    private String employeeInfoId;
    private String country;
    private String state;
    private String city;
    private String pinCode;
    private String phoneNumber;
    @OneToOne(mappedBy = "employeeInfo", fetch = FetchType.EAGER)
    @JsonIgnore
    private Employee employee;


    public EmployeeInfo() {
    }

    public String getEmployeeInfoId() {
        return employeeInfoId;
    }

    public void setEmployeeInfoId(String employeeInfoId) {
        this.employeeInfoId = employeeInfoId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    @Override
//    public String toString() {
//        return "EmployeeInfo{" +
//                employeeInfoId +
//                ", " + country + '\'' +
//                ", " + state + '\'' +
//                ", " + city + '\'' +
//                ", " + pinCode + '\'' +
//                ", " + phoneNumber + '\'' +
//                ", " + employee +
//                '}';
//    }
}
