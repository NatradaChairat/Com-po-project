import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../entities/product';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.html',
  styleUrls: ['./product-add.css']
})
export class ProductAddComponent implements OnInit {

  product: any = {};

  constructor(private productService: ProductService, private router: Router) {
  };

  ngOnInit() {
    this.product = new Product();
  }


  @ViewChild('fileInput') inputEl: ElementRef;

  addProduct(product: Product) {
    let result: Product;
    console.log(product)
    let inputEl: HTMLInputElement = this.inputEl.nativeElement;
    this.productService.addProduct(product, inputEl.files.item(0))
      .subscribe(resultProduct => {
        result = resultProduct
        if (result != null) {
          this.router.navigate(['/product']);
        } else {
          alert('Error in adding the Product');
        }
      });
  }


  onFileChange(event, product: any) {
    var filename = event.target.files[0].name;
    console.log(filename);
    this.product.image = filename;
  }
}
