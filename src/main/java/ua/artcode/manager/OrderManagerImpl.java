package ua.artcode.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.artcode.dao.ClientDao;
import ua.artcode.dao.OrderDao;
import ua.artcode.exception.NoSuchFoundOrderException;
import ua.artcode.model.Client;
import ua.artcode.model.Order;
import ua.artcode.model.OrderStatus;
import ua.artcode.model.Product;

import java.util.Date;
import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
@Service
public class OrderManagerImpl implements OrderManager{

    @Autowired
    private OrderDao dao;


    public OrderManagerImpl() {
    }


    public void setDao(OrderDao dao) {
        this.dao = dao;
    }

    @Override
    public void newOrder(Client client, List<Product> products) {
        Order order = new Order(new Date(),client, OrderStatus.NEW,products);
        dao.create(order);
    }


    @Override
    public List<Order> getOrderByClient(Client client) throws NoSuchFoundOrderException {
        return dao.find(client);
    }
}
