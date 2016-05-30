import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "SecondName")
    private String SecondName;

    @Temporal(TemporalType.DATE)
    @Column(name = "Bithday")
    private Date birthday;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Position")
    private PositionEmployee position;

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

    public PositionEmployee getPosition() {
        return position;
    }

    public void setPosition(PositionEmployee position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!login.equals(employee.login)) return false;
        if (!FirstName.equals(employee.FirstName)) return false;
        if (!SecondName.equals(employee.SecondName)) return false;
        if (!birthday.equals(employee.birthday)) return false;
        if (!email.equals(employee.email)) return false;
        if (!password.equals(employee.password)) return false;
        return position.equals(employee.position);

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
        result = 31 * result + position.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", SecondName='" + SecondName + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", position=" + position +
                '}';
    }
}
