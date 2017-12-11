package camt.cbsd.lab05.service.product;

import camt.cbsd.lab05.dao.product.ProductDao;
import camt.cbsd.lab05.entity.security.Product;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.validation.ReportAsSingleViolation;
import java.util.List;


@ConfigurationProperties(prefix = "server")
@Service
public class ProductServiceImpl implements ProductService{
    String imageBaseUrl;
    String baseUrl;
    String imageUrl;
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @PostConstruct
    protected void setImageBaseUrl(){
        this.imageBaseUrl = this.baseUrl + this.imageUrl;
    }


    @Autowired
    ProductDao productDao;
    @Override
    public List<Product> getAllProducts() {
        return this.productDao.getAllProducts();
    }


    @Override
    public Product addProduct(Product product) {
        return this.productDao.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    @Override
    public void deleteProduct(String productId) {
        this.productDao.deleteProduct(productId);
    }

    @Override
    @Transactional
    public Product findById(long id) {
        Product product = productDao.findById(id);
        //Hibernate.initialize(product.get);
        return product;
    }

    @Override
    public Product findByProductId(String productId) {
        return productDao.findByProductId(productId);
    }


    @Override
    public List<Product> searchProductsByName(String name) {
        if (name.equals(null))
            return this.productDao.getAllProducts();
        return this.productDao.searchProductsByName(name);
    }

    @Override
    public List<Product> searchProductsByDescription(String description) {
        if (description.equals(null))
            return this.productDao.getAllProducts();
        return this.productDao.searchProductsByDescription(description);
    }

    @Override
    public List<Product> searchProductsByPrice(double low, double high) {
        return this.productDao.searchProductsByPrice(low, high);
    }


}
