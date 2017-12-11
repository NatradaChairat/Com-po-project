import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {PurchaseService} from './purchase.service';

@Injectable()
export class CartService {

  constructor(private router:Router/*, private cartService:CartService, private purchaseService:PurchaseService*/) {
  }
  onCheckout() {

    this.router.navigate(['purchase']);
  }
}
