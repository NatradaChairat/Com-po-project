package camt.cbsd.lab05.service.shopkeeper;

import camt.cbsd.lab05.entity.security.Shopkeeper;

import java.util.List;

public interface ShopkeeperService {
    List<Shopkeeper> getAllShopkeepers();
    Shopkeeper getShopkeeper(String id);
    void addShopkeeper(Shopkeeper shopkeeper);
    void deleteShopkeeper(String shopkeeperId);
}
