import { Injectable } from '@angular/core';
import {Http,  Headers, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class AuthenticationService {
 /* private authUrl = 'http://localhost:8080/auth';
  private headers = new Headers({'Content-Type': 'application/json'})*/

  status: string;
  error: string;
  constructor(private http: Http) {
    this.status = "start";
  }

  login(username: string , password: string){

    if(username == "customer" && password == "customer"){
      this.status = "customer";
    }
    else if(username == "admin" && password == "admin"){
      this.status = "admin";
    }
    else if(username == "shopkeeper" && password == "shopkeeper"){
      this.status = "shopkeeper";
    }
    else if(username == "start" && password == "start"){
      this.status = "start";
    }

    else {this.error = "please check username & password";}
  }

  logout(){
    this.status = "start";
    console.log(this.getStatus());
  }

  getStatus(){
    return this.status;
  }

 /* login(username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl, JSON.stringify({
      username: username,
      password: password
    }), {headers: this.headers})
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let token = response.json() && (response.json() as any).token;
        if (token) {
          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify({username: username, token: token}));
          let product = response.json().product;
          console.log(product);
          localStorage.setItem('userDetails', JSON.stringify(product));
          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      }).catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }*/

  /*getToken(): string {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var token = currentUser && currentUser.token;
    return token ? token : '';
  }

  getCurrentUser() {
    let details = localStorage.getItem('userDetails');
    if (!details) {
      return null;
    }
    return JSON.parse(details);
  }*/

  /*hasRole(role: string) {
    let user: any = this.getCurrentUser();
    if (user) {
      let roleList: string[] = role.split(",");
      for (let j = 0; j < roleList.length; j++) {
        let authList = user.authorities;
        let userRole = 'ROLE_' + roleList[j].trim().toUpperCase();
        for (let i = 0; i < authList.length; i++) {
          if (authList[i].name == userRole) {
            return true;
          }
        }
      }
      return false;
    }
  }*/

  /*logout(): void {
    // clear token remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    localStorage.removeItem('userDetails');
  }*/

}
