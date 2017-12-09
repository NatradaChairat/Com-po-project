package camt.cbsd.lab05.dao.product;

import camt.cbsd.lab05.entity.security.Product;
import camt.cbsd.lab05.repository.ProductRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(String productId) {
        Product product = findByProductId(productId);
        this.productRepository.delete(product);

    }

    @Override
    public Product findById(long id) {

        return this.productRepository.findById(id);
    }

    @Override
    public Product findByProductId(String productId) {
        return this.productRepository.findByProductId(productId);
    }


    @Override
    public List<Product> getAllProducts() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return Lists.newArrayList(productRepository.findByNameIgnoreCaseContainingOrderByName(name));
    }

    @Override
    public List<Product> searchProductsByDescription(String description) {
        return Lists.newArrayList(productRepository.findByNameIgnoreCaseContainingOrderByName(description));
    }

    @Override
    public List<Product> searchProductsByPrice(double low, double high) {
        return Lists.newArrayList(productRepository.findByPrice(low, high));
    }
}
