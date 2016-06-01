package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Siry on 29.05.2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Login")
    private String login;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "SecondName")
    private String SecondName;

    @Temporal(TemporalType.DATE)
    @Column(name = "Birthday")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "Password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRole")
    private Position role;

    public User() {
    }

    public User(String login, String firstName, String secondName, Date birthday, String email, String password, Position role) {
        this.login = login;
        FirstName = firstName;
        SecondName = secondName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Position getRole() {
        return role;
    }

    public void setRole(Position role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!login.equals(user.login)) return false;
        if (!FirstName.equals(user.FirstName)) return false;
        if (!SecondName.equals(user.SecondName)) return false;
        if (!birthday.equals(user.birthday)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + FirstName.hashCode();
        result = 31 * result + SecondName.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
