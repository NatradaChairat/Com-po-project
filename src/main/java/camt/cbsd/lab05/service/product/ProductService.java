package camt.cbsd.lab05.service.product;

import camt.cbsd.lab05.entity.security.Product;

import java.util.List;

public interface ProductService {
    Product add(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);

    Product getProduct(String productId);
    List<Product> getAllProducts();
    List<Product> searchProductByName(String name);
    List<Product> searchProductByDescription(String description);
    List<Product> searchProductByPrice(double low, double high);
}
