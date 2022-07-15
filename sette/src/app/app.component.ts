import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from './services/administrator-login-services/authentication.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  [x: string]: any;


  constructor(public authService: AuthenticationService){}

  ngOnInit() {
      
  }

  logOut() {
    this.authService.logOut();
  }


}
