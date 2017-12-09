package camt.cbsd.lab05.service.shopkeeper;

import camt.cbsd.lab05.dao.shopkeeper.ShopkeeperDao;
import camt.cbsd.lab05.entity.security.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopkeeperServiceImpl implements ShopkeeperService {
    @Autowired
    ShopkeeperDao shopkeeperDao;

    @Override
    public List<Shopkeeper> getAllShopkeepers() {
        return this.shopkeeperDao.getAllShopkeepers();
    }

    @Override
    public Shopkeeper getShopkeeper(String id) {
        return this.shopkeeperDao.getShopkeeperByID(id);
    }

    @Override
    public void addShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeperDao.addShopkeeper(shopkeeper);
    }

    @Override
    public void deleteShopkeeper(String shopkeeperId) {
        this.shopkeeperDao.deleteShopkeeper(shopkeeperId);
    }
}
