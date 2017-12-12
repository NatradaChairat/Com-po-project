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
import {CartComponent} from './cart/cart';
import {PurchaseService} from './service/purchase.service';
import {PurchaseComponent} from './purchase/purchase';
import {LoginComponent} from './login/login';
import {AuthenticationService} from './service/authentication.service';
import {TransferComponent} from './transfer/transfer';


@NgModule({
  declarations: [AppComponent,
    ProductListComponent,
    ProductDetailComponent,
    ProductAddComponent,
    CartComponent,
    PurchaseComponent,
    LoginComponent,
    TransferComponent,
    MenuComponent, FileNotFoundComponent,
    ],
  imports: [BrowserModule, FormsModule, HttpModule,
    AppRoutingModule],
  bootstrap: [AppComponent],
  providers: [CartService,ProductService,PurchaseService,AuthenticationService],
})
export class AppModule {
}
