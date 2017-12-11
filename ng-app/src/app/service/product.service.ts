import 'rxjs/add/operator/map';
import {Injectable, OnInit} from '@angular/core';
import {Http, RequestOptions, Response,Headers,URLSearchParams} from '@angular/http';
import {Product} from '../entities/product';
import {Observable} from 'rxjs/Observable';
import "rxjs/add/operator/mergeMap";

@Injectable()
export class ProductService {
  constructor(private http: Http) {}

  public productInCart : Product[] = [];

  getProductData() {
    let products: Product[];
    return this.http.get('http://localhost:8080/product')
      .map(res => res.json());
  }

  getProduct(id: number) {
    let product:Product;
    return this.http.get('http://localhost:8080/product/'+id)
      .map((res:Response) => {
        if (res){
          if (res.status === 200){
            return res.json();
          }
          if (res.status === 204){
            return null;
          }
        }
      });
  }

  getProductIncart(){
    return this.productInCart;
  }

  addToCart(product: Product) {
    this.productInCart.push(product);
  }

  findProduct(search:string){
    let product: Product;
    let params:URLSearchParams = new URLSearchParams();
    params.set('search',search);
    let headers = new Headers({
      'content-type': 'application/json',
      //'Authorization': 'Bearer' + this.authenticationService.getToken()
    });
    return this.http.get('http://localhost:8080/product/query',{search:params})
      .map(res => res.json());
  }

  addProduct(product: Product,file:any):Observable<Product>{
    const formData = new FormData();
    let fileName: string;
    formData.append('file',file);
    return this.http.post('http://localhost:8080/upload',formData)
      .flatMap(filename => {
        product.image = filename.text();
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers, method: 'post'});
        let body = JSON.stringify(product);
        return this.http.post('http://localhost:8080/product',body,options)
          .map(res =>{
            return res.json()
          })
      })
  }
}
