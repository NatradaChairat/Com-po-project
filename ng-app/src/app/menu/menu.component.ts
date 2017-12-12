import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {CartService} from '../service/cart.service';
import {AuthenticationService} from '../service/authentication.service';

@Component({
 selector: 'menu',
 templateUrl: './menu.component.html',
 styleUrls:['./menu.component.css']
})
export class MenuComponent implements OnInit{
  constructor(

    private router: Router, private cartService: CartService, private authenService: AuthenticationService,

  ) {}


  ngOnInit() {
    this.authenService.login("start", "start");
    /*this.optionLog = "Logout";*/
  }

  hasRole(role: string){
    if(role == this.authenService.getStatus()){
      return true;
    }else {return false;}
  }
   onLogout(){
     this.authenService.logout();

   }

  /* optionLog :string;
   changeOption(){
     this.optionLog = "Login";
   }*/

}
