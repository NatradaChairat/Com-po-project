package camt.cbsd.lab05.controller;

import camt.cbsd.lab05.entity.security.Product;
import camt.cbsd.lab05.service.product.ProductService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class ProductController {
    ProductService productService;
    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/product")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }


    @GetMapping("product/{id}")
    public ResponseEntity getProduct(@PathVariable("id")long id){
        Product product = productService.findById(id);
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

    @GetMapping("/product/query")
    public ResponseEntity<?> queryProduct(@RequestParam("search") String query) {
        List<Product> products = productService.queryProduct(query);
        if (products != null)
            return ResponseEntity.ok(products);
        else
            //http code 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


    @Value("${server.imageServerDir}")
    String imageServerDir;
    @GetMapping(
            value = "/images/{fileName:.+}",
            produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    public @ResponseBody
    ResponseEntity<?> getProductImage(@PathVariable("fileName")String fileName) throws IOException {
        File file = Paths.get(imageServerDir+fileName).toFile();
        if (file.exists()) {
            InputStream in = new FileInputStream(file);
            return ResponseEntity.ok(IOUtils.toByteArray(in));
        }else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file")MultipartFile file){
        if (file.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{
            byte[] bytes = file.getBytes();
            String oldFilename = file.getOriginalFilename();
            //String ext = FilenameUtils.getExtension(oldFilename);
            ///String newFilename = Integer.toString(LocalTime.now().hashCode(),16)+Integer.toString(oldFilename.hashCode(),16)+"."+ext;
            Path path = Paths.get(imageServerDir+oldFilename);
            Files.write(path,bytes);
            return ResponseEntity.ok(oldFilename);
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    };

}
