import {Injectable} from '@angular/core';
import {Product} from "../entities/product";
import {BehaviorSubject} from "rxjs/BehaviorSubject";

@Injectable()
export class CartService {
  products: Product[] = [];

  private itemsNumSource = new BehaviorSubject<number>(0);
  numItems = this.itemsNumSource.asObservable();

  product: Product = {
    id : "CC-01",
    name : "Durian Mask Cake",
    image : "https://goo.gl/hf75yt",
    price : 480,
    stock: 4,
    selected: 1,
    description : "1 pound: vanila layer and durian cream."
  };

  constructor() {
    this.changeNumItems(this.products.length);
    this.addProduct(this.product);
  }

  changeNumItems(num: number) {
    this.itemsNumSource.next(num);
  }

  addProduct(product: Product) {
    this.products.push(product);
    this.changeNumItems(this.products.length);
    console.log(this.products);
  }

  getItems() {
    return this.products;
  }
}
