package ua.artcode.dao;

import ua.artcode.exception.NoUserFoundException;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;

import java.util.List;

/**
 * Created by andrey on 17.03.15.
 */
public interface ProductDao {

    void addProduct(Product product);

    void deleteProduct(int productId);

    void updateProduct(Product product);

    Product findProduct(int productId) throws NoUserFoundException;

    List<Product> findProductForType(ProductType type);
}
