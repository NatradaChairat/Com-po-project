import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {PurchaseService} from './purchase.service';
import {Product} from '../entities/product';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

@Injectable()
export class CartService {

  products: Product[] = [];

  private productCount = new BehaviorSubject<number>(0);
  count = this.productCount.asObservable();


  constructor(
    private router:Router, private purchaseService:PurchaseService) {
    this.addCountProduct(this.products.length);
  }
  onCheckout() {

    this.router.navigate(['purchase']);
  }

  addProduct(product: Product) {
    this.products.push(product);
    this.addCountProduct(this.products.length);
  }

  getItems() {
    return this.products;
  }

  addCountProduct(num: number) {
    this.productCount.next(num);
  }
}
