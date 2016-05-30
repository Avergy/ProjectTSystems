import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */

@Entity
@Table(name = "categoryproduct")
public class CategoryProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Category")
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryProduct that = (CategoryProduct) o;

        if (id != that.id) return false;
        return category.equals(that.category);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CategoryProduct{" +
                "id=" + id +
                ", Category='" + category + '\'' +
                '}';
    }
}
