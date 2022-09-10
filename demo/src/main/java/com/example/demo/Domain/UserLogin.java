package com.example.demo.Domain;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "userlogin",schema = "local")
public class UserLogin {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String userName;
    @Column(name = "pwd")
    private String password;
    @Column(name = "time_stamps")
    private Timestamp timeStamps;
    @Column(name = "e_mail")
    private String userEmail;
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public Timestamp getTimeStamps() {return timeStamps;}
    public void setTimeStamps(Timestamp timeStamps) {this.timeStamps = timeStamps;}
    public String getUserEmail() {return userEmail;}
    public void setUserEmail(String userEmail) {this.userEmail = userEmail;}
    public Integer getId() {
        return id;
    }
    public String getUsername() {
        return userName;
    }
    public void setUsername(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
