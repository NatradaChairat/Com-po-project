import {Router} from '@angular/router';
import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../entities/product';
import {CartService} from '../../service/cart.service';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.html',
  styleUrls: ['./product-list.css']
})
export class ProductListComponent implements OnInit{

  products: Product[];


  constructor(private router: Router, private cartService:CartService, private productService:ProductService) { }

  ngOnInit() {
    this.productService.getProductData()
      .subscribe(products => this.products = products);
  }

  showDetail(product: Product) {
    this.router.navigate(['detail', product.id]);
  }

  search:string;
  onSearch(){
    this.productService.findProduct(this.search)
      .subscribe(products => this.products = products,
      (error) => {
        if (error.status === 401) {
          //this.router.navigate(['product'], {queryParams: {source: 'product'}});
        }
      });
  }

  onAddToCart(product: Product){
    this.productService.getProductIncart().push(product);

  }


}
