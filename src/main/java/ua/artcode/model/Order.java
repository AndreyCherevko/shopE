package ua.artcode.model;

import javax.persistence.*;
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



}
