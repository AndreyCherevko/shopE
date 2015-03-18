package ua.artcode.model;

import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
public class Bucket {

    private List<Product> productList;

    public Bucket() {
    }

    public Bucket(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }


}
