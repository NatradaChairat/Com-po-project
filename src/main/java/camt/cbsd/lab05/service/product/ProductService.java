package camt.cbsd.lab05.service.product;

import camt.cbsd.lab05.entity.security.Product;

import java.util.List;

public interface ProductService {

    Product addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);
    List<Product> queryProduct(String query);
    Product findById(long id);
    Product findByProductId(String productId);
    List<Product> getAllProducts();
    List<Product> searchProductsByName(String name);
    List<Product> searchProductsByDescription(String description);
    List<Product> searchProductsByPrice(double low, double high);
}
