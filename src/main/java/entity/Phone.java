package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;


@Entity
@Table(name = "phones")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private long price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(name = "idBrand", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(name = "idColor", nullable = false)
    private Color color;

    @Column(name = "weight", nullable = false)
    private int weight;

    @Column(name = "quantityStock", nullable = false)
    private int quantityStock;

    @Column(name = "image", length = 1048576)
    @Lob()
    private byte[] image;

    private String imageURL;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (id != phone.id) return false;
        if (price != phone.price) return false;
        if (weight != phone.weight) return false;
        if (!name.equals(phone.name)) return false;
        if (!brand.equals(phone.brand)) return false;
        return color != null ? color.equals(phone.color) : phone.color == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + brand.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", brand=" + brand +
                ", color=" + color +
                ", weight=" + weight +
                ", quantityStock=" + quantityStock +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
