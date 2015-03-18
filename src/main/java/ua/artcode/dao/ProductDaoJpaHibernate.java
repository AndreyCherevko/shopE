package ua.artcode.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by andrey on 17.03.15.
 */
@Repository
public class ProductDaoJpaHibernate implements ProductDao {

    private final String FIND_PRODUCT="from Product c where c.id = :id";
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public ProductDaoJpaHibernate() {
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public void addProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteProduct(int productId) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public Product findProduct(int productId) throws NoUserFoundException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Product> products = entityManager.createQuery(FIND_PRODUCT)
                .setParameter("id", productId)
                .setMaxResults(1)
                .getResultList();

        if(products.isEmpty()){
            throw new NoUserFoundException();
        }

        return products.get(0);

    }

    @Override
    public List<Product> findProductForType(ProductType type) {
        return null;
    }
}
