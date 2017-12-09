package camt.cbsd.lab05.service.cart;

import camt.cbsd.lab05.dao.cart.CartDao;
import camt.cbsd.lab05.entity.security.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao;

    @Override
    public List<Cart> getAllCarts() {
        return this.cartDao.getAllCarts();
    }
}
