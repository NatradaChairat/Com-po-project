import {Router} from '@angular/router';
import {Component, Input, OnInit} from '@angular/core';
import {Product} from '../../entities/product';
import {CartService} from '../../service/cart.service';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './product-list.html',
  styleUrls: ['./product-list.css']
})
export class NoItemComponent implements OnInit {
  search: string;
  products: Product[];

  @Input() product:Product = {
    id : "",
    name : "",
    image : "",
    price : 0.0,
    stock: 0,
    selected: 0,
    description : ""
  };

  numItemsInCart:number;

  constructor(private router: Router, private cartService:CartService, private productService:ProductService) { }

  ngOnInit() {
    this.cartService.numItems.subscribe(numItems => this.numItemsInCart = numItems);
  }

  showDetail() {
    this.router.navigate(['detail', this.product.id]);
  }
  onSearch(){
    this.productService.findProduct(this.search)
      .subscribe(students => this.products = products,
      (error) => {
        if (error.status === 401) {
          this.router.navigate(['login'], {queryParams: {source: 'student'}});
        }
      });
  }


}
