package sshukla.springhibernatemappingv2.onetoone.model.primarykey;

import javax.persistence.*;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */
@Table(name = "students")
@Entity
public class Student {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private String studentId;

    private String name;
    private String house;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private StudentInfo studentInfo;

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }
}
