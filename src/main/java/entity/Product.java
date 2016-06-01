package entity;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created by Siry on 30.05.2016.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_CategoryBrand")
    private CategoryProduct categoryProduct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Color")
    private Color color;

    @Column(name = "weight")
    private int weight;

    @Column(name = "quantityStock")
    private int quantityStock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public CategoryProduct getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(CategoryProduct categoryProduct) {
        this.categoryProduct = categoryProduct;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (price != product.price) return false;
        if (weight != product.weight) return false;
        if (quantityStock != product.quantityStock) return false;
        if (!name.equals(product.name)) return false;
        if (!categoryProduct.equals(product.categoryProduct)) return false;
        return color.equals(product.color);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + price;
        result = 31 * result + categoryProduct.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + weight;
        result = 31 * result + quantityStock;
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryProduct=" + categoryProduct +
                ", color=" + color +
                ", weight=" + weight +
                ", quantityStock=" + quantityStock +
                '}';
    }
}
