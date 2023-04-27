package sshukla.springhibernatemappingv2.onetoone.foreignkey;

import javax.persistence.*;

/**
 * Created by `Seemant Shukla` on 26-04-2023
 */

@Table(name = "users")
@Entity
public class User {

    @Id
    private String id;
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", userProfile=" + userProfile +
//                '}';
//    }
}
