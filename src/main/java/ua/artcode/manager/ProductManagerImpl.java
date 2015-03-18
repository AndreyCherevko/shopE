package ua.artcode.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.artcode.dao.ProductDao;
import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;

import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
@Service
public class ProductManagerImpl implements ProductManager {
    @Autowired
    private ProductDao dao;

    public ProductManagerImpl() {
    }

    @Override
    public void addProduct(String name, String desc, long price, ProductType type) {
        dao.create(new Product(name, desc, price, type));
    }

    @Override
    public void removeProduct(int id) {
        dao.delete(id);
    }

    @Override
    public List<Product> getProducts(int page, int length, ProductType type) throws NoSuchFoundProductException {
        return dao.findForType(type);
    }

    @Override
    public Product getProduct(int productId) throws NoSuchFoundProductException {
        return dao.find(productId);
    }

    public void setDao(ProductDao dao) {
        this.dao = dao;
    }
}
