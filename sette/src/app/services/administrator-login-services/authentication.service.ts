import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { Observable, tap } from 'rxjs';
import { AdministratorLoginComponent } from 'src/app/components/administrator-login/administrator-login.component';
import { Users } from '../users-service/users';
import { UsersService } from '../users-service/users.service';
import { Administrators } from './administrators';
import { AdministratorsService } from './administrators.service';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  usersList: Users[];

  constructor(private userService: UsersService, private adminService: AdministratorsService, private http: HttpClient) { }

  public getUsers(): void {
    this.userService.getUsers().subscribe(
      (response: Users[]) => {
        this.usersList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  authenticate(username: string,usernameDB: string, password: string, passwordDB: string) {
    this.getUsers();
    if (username === usernameDB && password === passwordDB ) {
      for (let user of this.usersList) {
        if (user.user_username == usernameDB) {
          sessionStorage.setItem('allowClips', user.allow_clips.toString());
          sessionStorage.setItem('allowTenders', user.allow_tenders.toString());
          sessionStorage.setItem('allowBankruptcies', user.allow_bankruptcies.toString());
          sessionStorage.setItem('allowNotifications', user.allow_notifications.toString());
          sessionStorage.setItem('allowSales', user.allow_sales.toString());
          sessionStorage.setItem('allowMediums', user.allow_mediums.toString());
          sessionStorage.setItem('allowAuthors', user.allow_authors.toString());
          sessionStorage.setItem('allowTags', user.allow_tags.toString());
          sessionStorage.setItem('allowClients', user.allow_clients.toString());
          sessionStorage.setItem('allowSocials', user.allow_socials.toString());
          sessionStorage.setItem('allowAdministrators', user.allow_administrators.toString());
        }
      }
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    } 
}
  
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }

  }

