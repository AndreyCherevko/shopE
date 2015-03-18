package ua.artcode.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orders_id")
    private int id;
    @Column
    private Date date;
    @ManyToOne
    @JoinColumn(name="clients_id")
    private Client client;
    @Enumerated(value=EnumType.STRING)
    @Column(length = 20)
    private OrderStatus status;
    @ManyToMany
    @JoinTable(name="order_product",
    joinColumns={@JoinColumn(name="orders_id")},
    inverseJoinColumns={@JoinColumn(name="products_id")})
        private List<Product> productList;

    public Order(Date date, Client client, OrderStatus status, List<Product> productList) {
        this.date = date;
        this.client = client;
        this.status = status;
        this.productList = productList;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", client=" + client +
                ", status=" + status +
                ", productList=" + productList +
                '}';
    }
}
