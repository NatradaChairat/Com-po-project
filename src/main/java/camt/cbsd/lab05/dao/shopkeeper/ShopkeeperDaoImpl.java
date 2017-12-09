package camt.cbsd.lab05.dao.shopkeeper;

import camt.cbsd.lab05.entity.security.Shopkeeper;
import camt.cbsd.lab05.repository.ShopkeeperRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopkeeperDaoImpl implements ShopkeeperDao {
    @Autowired
    ShopkeeperRepository shopkeeperRepository;

    @Override
    public List<Shopkeeper> getAllShopkeepers() {
        return this.shopkeeperRepository.findAll();
    }


    @Override
    public Shopkeeper getShopkeeperByID(String shopkeeperId) {
        return this.shopkeeperRepository.findByShopkeeperId(shopkeeperId);
    }

    @Override
    public Shopkeeper getShopkeeperByName(String name) {
        return  this.shopkeeperRepository.findByShopkeeperName(name);
    }

    @Override
    public void addShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeperRepository.save(shopkeeper);
    }

    @Override
    public void deleteShopkeeper(String shopkeeperId) {
        Shopkeeper shopkeeper =  this.getShopkeeperByID(shopkeeperId);
        this.shopkeeperRepository.delete(shopkeeper);
    }
}
