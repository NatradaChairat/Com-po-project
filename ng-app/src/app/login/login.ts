import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent {


  constructor(private router: Router,private authenService: AuthenticationService) {
  }

  ngOnInit() {

  }

  Lusername: string;
  Lpassword: string;

  onLogin() {
    this.authenService.login(this.Lusername, this.Lpassword);

  }
}
