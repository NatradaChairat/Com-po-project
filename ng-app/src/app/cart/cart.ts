import {Component, OnInit} from '@angular/core';
import {Product} from '../entities/product';
import {Router} from '@angular/router';
import {CartService} from '../service/cart.service';
import {PurchaseService} from '../service/purchase.service';
import {ProductService} from '../service/product.service';
import {AuthenticationService} from '../service/authentication.service';
import {isUndefined, log} from 'util';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.html',
  styleUrls: ['./cart.css']
})
export class CartComponent implements OnInit {


  constructor(private router:Router, private cartService:CartService, private productService: ProductService , private authenService: AuthenticationService){
    this.checkT = this.authenService.getStatus();

  }
  cartList: Product[] =[];
  checkT: string;

  ngOnInit() {
    this.cartList= this.productService.getProductIncart();

  }

  upQuantity(product: Product) {
    product.selected++;
  }

  downQuantity(product: Product) {
    if (product.selected > 1)
      product.selected--;
    else{
      this.removeProductCart(product);
    }
  }

  removeProductCart(product: Product){
    const index: number = this.cartList.indexOf(product);
    if (index !== -1) {
      this.cartList.splice(index, 1);
    }
  }

  onPurchase() {
    window.console.log(this.authenService.getStatus());
    if (this.authenService.getStatus() == "start") {
      this.router.navigate(['login']);
    }
    else {
      this.cartService.onCheckout();
    }


  }



}
