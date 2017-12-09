package camt.cbsd.lab05.dao.product;

import camt.cbsd.lab05.entity.security.Product;

import java.util.List;

public interface ProductDao {
    Product add(Product product);
    void updateProduct(Product product);
    void deleteProduct(String productId);

    Product findById(long id);
    Product findByCode(String id);
    List<Product> getAllProducts();
    List<Product> searchProductsByName(String query);
    List<Product> searchProductsByDescription(String query);
    List<Product> searchProductsByPrice(double low, double high);
}
