package camt.cbsd.lab05.controller;

import camt.cbsd.lab05.entity.security.Product;
import camt.cbsd.lab05.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductService productService;
    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }

    @CrossOrigin
    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @CrossOrigin
    @GetMapping("product/{productId}")
    public ResponseEntity getProduct(@PathVariable("id")String id){
        Product product = productService.findByProductId(id);
        if(product!= null){
            return ResponseEntity.ok(product);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    @GetMapping("/product/name")
    public ResponseEntity<?> searchProductByName(@RequestParam String name) {
        List<Product> products = productService.searchProductsByName(name);
        if (products.size() != 0)
            return ResponseEntity.ok(products);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/product/description")
    public ResponseEntity<?> searchProductByDescription(@RequestParam String description) {
        List<Product> products = productService.searchProductsByDescription(description);
        if (products.size() != 0)
            return ResponseEntity.ok(products);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/product/price")
    public ResponseEntity<?> searchProductByPriceInterval(@RequestParam String low, @RequestParam String high) {
        try {
            double lowPoint = Double.parseDouble(low);
            double highPoint = Double.parseDouble(high);

            List<Product> products = productService.searchProductsByPrice(lowPoint, highPoint);
            if (products.size() != 0)
                return ResponseEntity.ok(products);
            else
                //http code 204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        this.productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        this.productService.updateProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/product/{productId}")
    public boolean deleteProduct(@PathVariable String id) {
        this.productService.deleteProduct(id);
        return true;
    }
}
