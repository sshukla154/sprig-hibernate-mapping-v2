package sshukla.springhibernatemappingv2.onetoone.model.foreignkey;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@Table(name = "user_profiles")
@Entity
public class UserProfile {

    @Id
    private String id;
    private String phoneNumber;
    private Gender gender;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userProfile")
    @JsonIgnore
    private User user;

    public UserProfile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
//    @Override
//    public String toString() {
//        return "UserProfile{" +
//                 id + '\'' +
//                ", " + phoneNumber + '\'' +
//                ", " + gender +
//                '}';
//    }
}
