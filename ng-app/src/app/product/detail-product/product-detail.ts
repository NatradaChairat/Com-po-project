import {Component, Input, OnInit} from '@angular/core';

import {Product} from '../../entities/product';
import {ActivatedRoute, Params} from '@angular/router';
import 'rxjs/add/operator/switchMap'
import {ProductService} from "app/service/product.service";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.html',
  styleUrls: ['./product-detail.css']
})
export class ProductDetailComponent implements OnInit {

  constructor(private route: ActivatedRoute, private productService:ProductService) { }

  @Input() product: Product = {
    id : 0,
    productId: "",
    name: "",
    image: "",
    price: 0.0,
    stock: 0.0,
    selected: 0.0,
    description: "",
  };
  isNoData:boolean;

  ngOnInit() {
    this.route.params
      .switchMap((params:Params) => this.productService.getProduct(+params['id']))
      .subscribe((product:Product) => {
          if (product != null)
            this.product = product;
          else
            this.isNoData = true;
        }
      );
  }

}
