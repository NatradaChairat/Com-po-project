import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthenticationService} from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  error = '';

  constructor(private router: Router,
              private authenticationService: AuthenticationService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.authenticationService.logout();

    let source: String;
    this.route.queryParams.subscribe(
      params => {
        if (params['source'])
          source = params['source'];
        else
          source = null;
      }
    );

    if (source) {
      this.error = `Please login before use ${source} page.`;
    }
  }

}
