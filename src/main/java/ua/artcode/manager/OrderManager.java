package ua.artcode.manager;

import ua.artcode.exception.NoSuchFoundOrderException;
import ua.artcode.model.Client;
import ua.artcode.model.Order;
import ua.artcode.model.Product;

import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
public interface OrderManager {

    void newOrder(Client client,List<Product> products);

    List<Order> getOrderByClient(Client client) throws NoSuchFoundOrderException;
}
