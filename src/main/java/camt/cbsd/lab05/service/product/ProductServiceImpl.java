package camt.cbsd.lab05.service.product;

import camt.cbsd.lab05.dao.product.ProductDao;
import camt.cbsd.lab05.entity.security.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ReportAsSingleViolation;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public Product add(Product product) {
        return this.productDao.add(product);
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
    public Product getProduct(String productId) {
        return this.productDao.findByProductId(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDao.getAllProducts();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        if (name.equals(null))
            return this.productDao.getAllProducts();
        return this.productDao.searchProductsByName(name);
    }

    @Override
    public List<Product> searchProductByDescription(String description) {
        if (description.equals(null))
            return this.productDao.getAllProducts();
        return this.productDao.searchProductsByDescription(description);
    }

    @Override
    public List<Product> searchProductByPrice(double low, double high) {
        return this.productDao.searchProductsByPrice(low, high);
    }
}
