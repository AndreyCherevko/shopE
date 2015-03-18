package ua.artcode.dao;

import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.exception.NoUserFoundException;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;

import java.util.List;

/**
 * Created by andrey on 17.03.15.
 */
public interface ProductDao {

    void create(Product product);

    void delete(int productId);

    void update(Product product);

    Product find(int productId) throws  NoSuchFoundProductException;

    List<Product> findForType(ProductType type) throws NoSuchFoundProductException;
}
