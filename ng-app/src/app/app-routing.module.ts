import {NgModule}              from '@angular/core';
import {RouterModule, Routes}  from '@angular/router';
import {FileNotFoundComponent} from "./filenotfound/file-not-found.component";
import {ProductListComponent} from './product/list-product/product-list';

const appRoutes: Routes = [
  {path: 'product', component: ProductListComponent},
  {
    path: '',
    redirectTo: '/product',
    pathMatch: 'full'
  },
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
