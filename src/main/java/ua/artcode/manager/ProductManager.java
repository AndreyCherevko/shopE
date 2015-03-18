package ua.artcode.manager;

import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.model.Product;
import ua.artcode.model.ProductType;

import java.util.List;

/**
 * Created by serhii on 24.02.15.
 */
public interface ProductManager {

    public void addProduct(String name,
                           String desc, long price, ProductType type);

    public void removeProduct(int id);

    public List<Product> getProducts(int page, int length, ProductType type) throws NoSuchFoundProductException;

    public Product getProduct(int productId) throws NoSuchFoundProductException;


}
