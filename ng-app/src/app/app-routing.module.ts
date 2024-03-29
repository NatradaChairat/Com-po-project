import {NgModule}              from '@angular/core';
import {RouterModule, Routes}  from '@angular/router';
import {FileNotFoundComponent} from "./filenotfound/file-not-found.component";
import {ProductListComponent} from './product/list-product/product-list';
import {ProductDetailComponent} from './product/detail-product/product-detail';
import {ProductAddComponent} from './product/add-product/product-add';
import {CartComponent} from './cart/cart';
import {PurchaseService} from './service/purchase.service';
import {PurchaseComponent} from './purchase/purchase';
import {LoginComponent} from './login/login';
import {TransferComponent} from './transfer/transfer';

const appRoutes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'product', component: ProductListComponent},
  {path: 'detail/:id', component: ProductDetailComponent,
    data: {
      product: {
        productId : "CC-01",
        name : "Durian Mask Cake",
        image : "https://goo.gl/hf75yt",
        price : 480,
        stock: 4,
        selected: 1,
        description : "1 pound: vanilla layer and durian cream."
      }
    }
  },
  {path: 'addProduct', component: ProductAddComponent},
  {
    path: '',
    redirectTo: '/product',
    pathMatch: 'full'
  },
  {path: 'cart', component: CartComponent},
  {path: 'purchase', component:PurchaseComponent},
  {path: 'transfer', component:TransferComponent},
  {path: '**', component: FileNotFoundComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {
}
