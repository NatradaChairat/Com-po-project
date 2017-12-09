package camt.cbsd.lab05.repository;

import camt.cbsd.lab05.entity.security.Shopkeeper;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShopkeeperRepository extends CrudRepository<Shopkeeper, Long> {
    List<Shopkeeper> findAll();
    Shopkeeper findByShopkeeperId(String id);
    Shopkeeper findByShopkeeperName(String name);
}
