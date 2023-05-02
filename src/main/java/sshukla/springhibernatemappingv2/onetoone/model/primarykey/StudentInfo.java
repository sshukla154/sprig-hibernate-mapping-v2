package sshukla.springhibernatemappingv2.onetoone.model.primarykey;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */
@Table(name = "student_infos")
@Entity
public class StudentInfo {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_info_id")
    private String studentInfoId;
    private Grade grade;

    @OneToOne(mappedBy = "studentInfo")
    @MapsId
    @JoinColumn(name = "student_info_id")
    @JsonIgnore
    private Student student;

    public StudentInfo() {
    }

    public String getStudentInfoId() {
        return studentInfoId;
    }

    public void setStudentInfoId(String studentInfoId) {
        this.studentInfoId = studentInfoId;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
