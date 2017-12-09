package camt.cbsd.lab05.dao.shopkeeper;

import camt.cbsd.lab05.entity.security.Shopkeeper;

import java.util.List;

public interface ShopkeeperDao {
    List<Shopkeeper> getAllShopkeepers();
    Shopkeeper getShopkeeper(String id);
    Shopkeeper getShopkeeperByID(String shopkeeperId);
    Shopkeeper getShopkeeperByName(String name);
    void addShopkeeper(Shopkeeper sp2);
    void deleteShopkeeper(String shopkeeperId);
}
