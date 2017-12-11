import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {FileNotFoundComponent} from './filenotfound/file-not-found.component';
import {MenuComponent} from './menu/menu.component';
import {ProductListComponent} from './product/list-product/product-list';
import {ProductDetailComponent} from './product/detail-product/product-detail';
import {ProductAddComponent} from './product/add-product/product-add';
import {CartService} from './service/cart.service';
import {ProductService} from './service/product.service';
import {ProductSearchComponent} from './product/search-product/product-search';
import {CartComponent} from './cart/cart';


@NgModule({
  declarations: [AppComponent,
    ProductListComponent,
    ProductDetailComponent,
    ProductAddComponent,
    ProductSearchComponent,
    CartComponent,
    MenuComponent, FileNotFoundComponent,
    ],
  imports: [BrowserModule, FormsModule, HttpModule,
    AppRoutingModule],
  bootstrap: [AppComponent],
  providers: [CartService,ProductService],
})
export class AppModule {
}
