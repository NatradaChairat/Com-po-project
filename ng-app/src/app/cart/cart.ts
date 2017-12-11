import {Component, OnInit} from '@angular/core';
import {Product} from '../entities/product';
import {Router} from '@angular/router';
import {CartService} from '../service/cart.service';
import {PurchaseService} from '../service/purchase.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.html',
  styleUrls: ['./cart.css']
})
export class CartComponent implements OnInit {


  constructor(private router:Router/*, private cartService:CartService, private purchaseService:PurchaseService*/) {
  }

  ngOnInit() {

  }



}
