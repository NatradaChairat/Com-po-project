
import {Injectable, OnInit} from '@angular/core';
import {Product} from '../entities/product';
import {Http} from '@angular/http';

@Injectable()
export class ProductService implements OnInit{
  constructor(
    private http: Http
  ) {}
  products: Product[] = [{
      productId : "CC-01",
      name : "Durian Mask Cake",
      image : "https://goo.gl/hf75yt",
      price : 480,
      stock: 4,
      selected: 1,
      description : "1 pound: vanilla layer and durian cream."
  },{
      productId : "CC-02",
      name : "Pony Mask Cake",
      image : "https://goo.gl/8NCHTz",
      price : 480,
      stock: 5,
      selected: 2,
      description : "1 pound: vanilla layer with strawberry cream."
  },{
    productId : "CC-03",
    name : "Samurai Mask Cake",
    image : "https://goo.gl/KNasVF",
    price : 480,
    stock: 4,
    selected: 1,
    description : "1 pound: hokkaido milk flavor."
  },{
    productId : "CC-04",
    name : "Sumo Mask Cake",
    image : "https://goo.gl/hf75yt",
    price : 480,
    stock: 4,
    selected: 1,
    description : "1 pound: hokkaido milk flavor."
  }];

  findProduct(search: string){
    let product: Product;
    let params: URLSearchParams = new URLSearchParams();
    params.set('search', search);
    let headers = new Headers({
      'Content-Type': 'application/json'
    });
    return this.http.get('http://localhost:8080/products', {headers: headers, search:params})
      .map(res => res.json());
  }
}
