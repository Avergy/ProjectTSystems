import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */

@Entity
@Table(name = "country")
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CountryName")
    private String CountryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (id != country.id) return false;
        return CountryName.equals(country.CountryName);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + CountryName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", CountryName='" + CountryName + '\'' +
                '}';
    }
}
