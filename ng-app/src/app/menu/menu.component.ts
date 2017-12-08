import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {isUndefined} from 'util';

@Component({
 selector: 'menu',
 templateUrl: './menu.component.html',
 styleUrls:['./menu.component.css']
})
export class MenuComponent {
  constructor(

    private router: Router

  ) {}


  ngOnInit() {

  }


  hasRole(role:string) {
    return 0; //this.authenService.hasRole(role);
  }
}
