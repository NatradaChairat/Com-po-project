package camt.cbsd.lab05.repository;

import camt.cbsd.lab05.entity.security.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
