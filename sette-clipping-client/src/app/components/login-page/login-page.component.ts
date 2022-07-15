import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/clients-login-service/authentication.service';
import { Clients } from 'src/app/services/clients-service/clients';
import { ClientsService } from 'src/app/services/clients-service/clients.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent /* implements OnInit */{

  userNotFound = false;
  username: string;
  password: string;
  invalidLogin = false;
  public clientsList: Clients[];
  clients: Clients;
  constructor(public clientsService: ClientsService, private router: Router, public authService: AuthenticationService) {
    this.clients = new Clients;
  }

  ngOnInit(): void {
    this.getClients();
  }

  logOut() {
    this.authService.logOut();
  }
  
  checkLogin() {
    for (var client of this.clientsList) {
      if (this.authService.authenticate(this.username, client.client_username, this.password, client.client_password, client.client_id,
        client.is_latin, client.follows_clips, client.follows_bankruptcies, client.follows_tenders, client.follows_notifications, client.follows_notifications)
      ) {
        this.router.navigate(['/home'])
        this.invalidLogin = false
      } else {
        this.userNotFound = true;
      }
      this.invalidLogin = true
    }
  }

  public getClients(): void {
    this.clientsService.getAllClients().subscribe(
      (response: Clients[]) => {
        this.clientsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
