package ua.artcode.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="products_id")
    private int id;
    @Column(length = 20)
    private String name;
    @Column(name="[desc]")
    private String desc;
    @Column
    private long price;
    @Enumerated(value=EnumType.STRING)
    private ProductType productType;

    public Product() {
    }

    public Product(String name, String desc, long price, ProductType productType) {
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.productType = productType;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
