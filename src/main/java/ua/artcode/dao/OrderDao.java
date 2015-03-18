package ua.artcode.dao;

import ua.artcode.exception.NoSuchFoundOrderException;
import ua.artcode.model.Client;
import ua.artcode.model.Order;

import java.util.Date;
import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */

public interface  OrderDao {

    void create(Order order);

    void update(Order order);

    List<Order> find(Client clientId) throws NoSuchFoundOrderException;

    List<Order> findOrderByDate(Date date) throws NoSuchFoundOrderException;
}
