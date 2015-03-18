package ua.artcode.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.artcode.exception.NoSuchFoundProductException;
import ua.artcode.manager.ProductManager;
import ua.artcode.model.Bucket;
import ua.artcode.model.Product;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrey on 18.03.15.
 */
@Service
public class BucketFromCookieUtills {
        @Autowired
        private static ProductManager manager;

    public static Bucket getBucket(Cookie cookie) throws NoSuchFoundProductException {
        String value = cookie.getValue();
        String[] cookieContent = value.split("#");
        List<Product> productList = new ArrayList<Product>();
        for(int i=2;i<cookieContent.length;i++){
            productList.add(manager.getProduct(Integer.parseInt(cookieContent[i])));
        }
        return new Bucket(productList);
    }
    public static Cookie getCookie(Bucket bucket, Cookie cookie){
        StringBuilder value = new StringBuilder(cookie.getValue());
        for(Product product:bucket.getProductList()){
            value.append(product.getId()+"#");
        }
        cookie.setValue(value.toString());
        return cookie;
    }
}
