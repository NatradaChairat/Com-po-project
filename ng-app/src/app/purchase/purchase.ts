import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {CartService} from '../service/cart.service';
import {Product} from '../entities/product';
import * as _ from "lodash";
import {ProductService} from '../service/product.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.html',
  styleUrls: ['./purchase.css']
})
export class PurchaseComponent implements OnInit {

  constructor(private router:Router, private cartService:CartService, private productService: ProductService) { }


  private numProduct: number;
  productCart: Product[] =[];


  ngOnInit() {
    this.cartService.count.subscribe(numProduct => this.numProduct = numProduct);
    this.productCart = this.productService.getProductIncart();
    window.console.log(this.productCart);

  }

  total: number;

  getTotalPrice(){
    this.total = 480*this.productCart.length;

    return this.total;
  }

  onConfirm(option:string){
    if(option == "Transfer" ){
      this.router.navigate(['transfer']);
    }
  }


}
