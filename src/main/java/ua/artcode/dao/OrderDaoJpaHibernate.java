package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.artcode.exception.NoSuchFoundOrderException;
import ua.artcode.model.Client;
import ua.artcode.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
@Repository
public class OrderDaoJpaHibernate implements OrderDao {

    private String FIND_ORDER_BY_CLIENTID="SELECT o FROM Order AS o WHERE o.client= :id";

    private String FIND_ORDER_BY_DATE="SELECT o FROM Order AS o WHERE o.date= :date";

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public OrderDaoJpaHibernate() {
    }

    @Override
    public void create(Order order) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(order);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Order order) {


    }

    @Override
    public List<Order> find(Client clientId) throws NoSuchFoundOrderException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders = entityManager.createQuery(FIND_ORDER_BY_CLIENTID)
                .setParameter("id", clientId)
                .getResultList();

        if(orders.isEmpty()){
            throw new NoSuchFoundOrderException();
        }

        return orders;

    }

    @Override
    public List<Order> findOrderByDate(Date date) throws NoSuchFoundOrderException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Order> orders = entityManager.createQuery(FIND_ORDER_BY_DATE)
                .setParameter("date", date)
                .getResultList();

        if(orders.isEmpty()){
            throw new NoSuchFoundOrderException();
        }

        return orders;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
