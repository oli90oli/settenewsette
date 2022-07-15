import { Component, OnInit } from '@angular/core';
import { Administrators } from 'src/app/services/administrator-login-services/administrators';
import { HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UsersService } from 'src/app/services/users-service/users.service';
import { Users } from 'src/app/services/users-service/users';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReturnStatement } from '@angular/compiler';



@Component({
  selector: 'app-administrator-login',
  templateUrl: './administrator-login.component.html',
  styleUrls: ['./administrator-login.component.css']
})
export class AdministratorLoginComponent implements OnInit {
  invalidLogin = false

  public usersList: Users[];
  users: Users;

  loginForm: FormGroup;
  userNotFound = false;
  sha1 = require('sha-1');

  constructor(private userService: UsersService, private router: Router, public authService: AuthenticationService, private formBuilder: FormBuilder) {
    this.users = new Users();
  }

  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      administrator_username : ['',Validators.required],
      administrator_password : ['',Validators.required]
    });
    this.getUsers();
  }

  logOut() {
    this.authService.logOut();
  }
  
  checkLogin() {
    var username = this.loginForm.controls['administrator_username'].value;
    var password = this.loginForm.controls['administrator_password'].value;
    for (var user of this.usersList) {
      if (this.authService.authenticate(username, user.user_username, this.sha1(password), user.user_password)
      ) {
        this.router.navigate([''])
        this.invalidLogin = false
      } else {
        this.loginForm.controls['administrator_password'].setValue('');
        this.userNotFound = true;
      }
      this.invalidLogin = true
    }
  }

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

}
