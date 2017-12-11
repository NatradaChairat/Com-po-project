package camt.cbsd.lab05.controller;


import camt.cbsd.lab05.entity.security.Shopkeeper;
import camt.cbsd.lab05.service.shopkeeper.ShopkeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopkeeperController {

    @Autowired
    ShopkeeperService shopkeeperService;

    @GetMapping("/shopkeeper")
    public ResponseEntity<?> getAllShopkeepers() {
        List<Shopkeeper> shopkeepers = this.shopkeeperService.getAllShopkeepers();
        if (shopkeepers != null) {
            return ResponseEntity.ok(shopkeepers);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/shopkeeper/{id}")
    public ResponseEntity<Shopkeeper> getShopkeeper(@PathVariable String id) {
        Shopkeeper shopkeeper = this.shopkeeperService.getShopkeeper(id);
        if (shopkeeper != null) {
            return ResponseEntity.ok(shopkeeper);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/shopkeeper")
    public ResponseEntity<Shopkeeper> addShopkeeper(@RequestBody Shopkeeper shopkeeper) {
        this.shopkeeperService.addShopkeeper(shopkeeper);
        return ResponseEntity.ok(shopkeeper);
    }

    @DeleteMapping("/shopkeeper/{shopkeeperId}")
    public boolean deleteShopkeeper(@PathVariable String shopkeeperId) {
        this.shopkeeperService.deleteShopkeeper(shopkeeperId);
        return true;
    }
}
