package camt.cbsd.lab05.service.shopkeeper;

import camt.cbsd.lab05.dao.shopkeeper.ShopkeeperDao;
import camt.cbsd.lab05.entity.security.Shopkeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@ConfigurationProperties(prefix = "server")
@Service("shopkeeperService")
public class ShopkeeperServiceImpl implements ShopkeeperService {
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
    ShopkeeperDao shopkeeperDao;

    @Override
    public List<Shopkeeper> getAllShopkeepers() {
        return this.shopkeeperDao.getAllShopkeepers();
    }

    @Transactional
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
