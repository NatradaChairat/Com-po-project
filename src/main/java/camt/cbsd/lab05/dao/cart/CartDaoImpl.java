package camt.cbsd.lab05.dao.cart;

import camt.cbsd.lab05.entity.security.Cart;
import camt.cbsd.lab05.repository.CartRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartDaoImpl implements CartDao {
    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Cart> getAllCarts() {
        return Lists.newArrayList(cartRepository.findAll());
    }
}
