import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import {FileNotFoundComponent} from './filenotfound/file-not-found.component';
import {MenuComponent} from './menu/menu.component';


@NgModule({
  declarations: [AppComponent,

    MenuComponent, FileNotFoundComponent,
    ],
  imports: [BrowserModule, FormsModule, HttpModule,
    AppRoutingModule],
  bootstrap: [AppComponent],

})
export class AppModule {
}
