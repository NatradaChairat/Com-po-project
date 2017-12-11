package camt.cbsd.lab05.service.cart;

import camt.cbsd.lab05.dao.cart.CartDao;
import camt.cbsd.lab05.entity.security.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@ConfigurationProperties(prefix = "server")
@Service
public class CartServiceImpl implements CartService {
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
    CartDao cartDao;

    @Override
    public List<Cart> getAllCarts() {
        return this.cartDao.getAllCarts();
    }
}
