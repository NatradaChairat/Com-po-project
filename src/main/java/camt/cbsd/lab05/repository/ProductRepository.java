package camt.cbsd.lab05.repository;

import camt.cbsd.lab05.entity.security.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    Product findById(Long id);
    Product findByProductId(String productId);
    List<Product> findByNameIgnoreCaseContainingOrderByName(String name);
    List<Product> findByDescriptionIgnoreCaseContaining(String description);
    List<Product> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String searchProduct,String searchDes);
    List<Product> findByPrice(double low, double high);
}
