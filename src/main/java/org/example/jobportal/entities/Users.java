package org.example.jobportal.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    @Column(unique = true)
    private String email;
    @NotEmpty
    private String password;
    private boolean isActive;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date registrationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userTypeId", referencedColumnName = "userTypeId")
    private UsersType usersTypeId;

    public Users() {
    }
    public Users(int userid, String email, String password, boolean isActive, Date registrationDate, UsersType usersTypeId) {
        this.userid = userid;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.registrationDate = registrationDate;
        this.usersTypeId = usersTypeId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UsersType getUsersTypeId() {
        return usersTypeId;
    }

    public void setUsersTypeId(UsersType usersTypeId) {
        this.usersTypeId = usersTypeId;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", registrationDate=" + registrationDate +
                ", usersTypeId=" + usersTypeId +
                '}';
    }
}
