package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by andrey on 17.03.15.
 */
@Repository
public class ProductDaoJpaHibernate implements ProductDao {

    private final String FIND_PRODUCT="from Products c where c.products_id = :id";
    private final String FIND_PRODUCT_FOR_TYPE="SELECT c FROM Product as c WHERE c.productType = :type";
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public ProductDaoJpaHibernate() {
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public void create(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int productId) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public Product find(int productId) throws NoSuchFoundProductException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Product> products = entityManager.createQuery(FIND_PRODUCT)
                .setParameter("id", productId)
                .setMaxResults(1)
                .getResultList();

        if(products.isEmpty()){
            throw new NoSuchFoundProductException();
        }

        return products.get(0);

    }

    @Override
    public List<Product> findForType(ProductType type) throws NoSuchFoundProductException {
        ;EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createQuery(FIND_PRODUCT_FOR_TYPE, Product.class).setParameter("type",type);
        List<Product> products = query.getResultList();
        if(products.isEmpty()){
            throw new NoSuchFoundProductException();
        }

        return products;
    }
}
