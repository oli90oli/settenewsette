import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Users } from 'src/app/services/users-service/users';
import { UsersService } from 'src/app/services/users-service/users.service';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})

export class UsersComponent implements OnInit {

usersList: Users[];
users: Users;  
searchString: string;
userForm: FormGroup;
userID: number; 
selectedUserID: number;
userName: string;
editMode = false;
selectAll = false;
selectedUsers = [];
allowClips: boolean = false;
allowTenders: boolean = false;
allowBankruptcies: boolean = false;
allowSales: boolean = false;
allowNotifications: boolean = false;
allowMediums: boolean = false;
allowAuthors: boolean = false;
allowTags: boolean = false;
allowClients: boolean = false;
allowSocials: boolean = false;
allowAdministrators: boolean = false;
sha1 = require('sha-1');

@ViewChild('aClips') aClips: ElementRef;
@ViewChild('aTenders') aTenders: ElementRef;
@ViewChild('aBankruptcies') aBankruptcies: ElementRef;
@ViewChild('aSales') aSales: ElementRef;
@ViewChild('aNotifications') aNotifications: ElementRef;
@ViewChild('aMediums') aMediums: ElementRef;
@ViewChild('aAuthors') aAuthors: ElementRef;
@ViewChild('aTags') aTags: ElementRef;
@ViewChild('aClients') aClients: ElementRef;
@ViewChild('aSocials') aSocials: ElementRef;
@ViewChild('aAdministrators') aAdministrators: ElementRef;

  constructor(private userService: UsersService, private formBuilder: FormBuilder, private dialog: MatDialog, private _snackBar: MatSnackBar) 
  { 
    this.users = new Users();
  }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      user_name : ['',Validators.required],
      user_username : ['',Validators.required],
      user_password: ['',Validators.required],
      allow_clips: [],
      allow_tenders: [],
      allow_bankruptcies: [],
      allow_notifications: [],
      allow_sales: [],
      allow_mediums: [],
      allow_authors: [],
      allow_tags: [],
      allow_clients: [],
      allow_socials: [],
      allow_administrators: [],
    });
    this.getUsers();
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

  selectUsers(userID: number) {
      if(this.selectedUsers.includes(userID)) {
        for (let i = 0; i < this.selectedUsers.length; i++) {
        if (this.selectedUsers[i] == userID) {
        this.selectedUsers.splice(i, 1);
         }
       }
      } else {
        this.selectedUsers.push(userID);
      }
      console.log(this.selectedUsers)
  }

  selectAllUsers() {
    this.selectAll=true;
    for (let user of this.usersList) {
      this.selectedUsers.push(user.user_id);
    }
  }
  
  deleteMultipleUsers() {
    for (let userID of this.selectedUsers) {
      this.userService.deleteUser(userID).subscribe(result => this.getUsers());
    }
    this.selectedUsers = [];
  }

  openSnackBar(message: string, action: string, ) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  addUser(allowClips: boolean, allowBankruptcies: boolean, allowTenders: boolean, allowNotifications: boolean,
          allowSales: boolean, allowMediums: boolean, allowAuthors: boolean, allowTags: boolean, allowClients: boolean,
          allowSocial: boolean, allowAdministrators: boolean) {
    if(this.userForm.valid) {
      console.log(this.userForm.value)
      this.userForm.controls['user_password'].setValue(this.sha1(this.userForm.controls['user_password'].value));
      this.userForm.controls['allow_clips'].setValue(allowClips);
      this.userForm.controls['allow_bankruptcies'].setValue(allowBankruptcies);
      this.userForm.controls['allow_tenders'].setValue(allowTenders);
      this.userForm.controls['allow_notifications'].setValue(allowNotifications);
      this.userForm.controls['allow_sales'].setValue(allowSales);
      this.userForm.controls['allow_mediums'].setValue(allowMediums);
      this.userForm.controls['allow_authors'].setValue(allowAuthors);
      this.userForm.controls['allow_tags'].setValue(allowTags);
      this.userForm.controls['allow_clients'].setValue(allowClients);
      this.userForm.controls['allow_socials'].setValue(allowSocial);
      this.userForm.controls['allow_administrators'].setValue(allowAdministrators); 
      this.userService.addUser(this.userForm.value).subscribe(result => this.getUsers());
      this.resetForm();
      this.openSnackBar("Успешно додаден корисник!", "Затвори");
    }
  }

  editUser(userID: number, allowClips: boolean, allowBankruptcies: boolean, allowTenders: boolean, allowNotifications: boolean,
    allowSales: boolean, allowMediums: boolean, allowAuthors: boolean, allowTags: boolean, allowClients: boolean,
    allowSocial: boolean, allowAdministrators: boolean) {
    this.users.user_name = this.userForm.controls['user_name'].value;
    this.users.user_username = this.userForm.controls['user_username'].value;
    this.users.user_password = this.userForm.controls['user_password'].value;
    this.users.allow_clips = allowClips;
    this.users.allow_tenders = allowTenders;
    this.users.allow_bankruptcies = allowBankruptcies;
    this.users.allow_sales = allowSales;
    this.users.allow_notifications = allowNotifications;
    this.users.allow_mediums = allowMediums;
    this.users.allow_authors = allowAuthors;
    this.users.allow_tags = allowTags;
    this.users.allow_clients = allowClients;
    this.users.allow_socials = allowSocial;
    this.users.allow_administrators = allowAdministrators;
    this.userService.updateUser(userID, this.users,).subscribe(result => this.getUsers());
    this.resetForm();
    this.openSnackBar('Корисникот е успешно изменет!','Затвори');
  }

  loadUsers(userName: string, userUsername: string, userPassword: string, allowClips: boolean, allowTenders: boolean,
            allowBankruptcies: boolean,  allowSales: boolean,  allowNotifications: boolean,  allowMediums: boolean,  
            allowAuthors: boolean, allowTags: boolean,  allowClients: boolean,  allowSocials: boolean,  allowAdministrators: boolean) {
    this.userForm.controls['user_name'].setValue(userName);
    this.userForm.controls['user_username'].setValue(userUsername);
    this.userForm.controls['user_password'].setValue(userPassword);
    this.aClips['checked'] = allowClips;
    this.aTenders['checked'] = allowTenders;
    this.aBankruptcies['checked'] = allowBankruptcies;
    this.aSales['checked'] = allowSales;
    this.aNotifications['checked'] = allowNotifications;
    this.aMediums['checked'] = allowMediums;
    this.aAuthors['checked'] = allowAuthors;
    this.aTags['checked'] = allowTags;
    this.aClients['checked'] = allowClients;
    this.aSocials['checked'] = allowSocials;
    this.aAdministrators['checked'] = allowAdministrators;
  } 

  deleteUser(userID: number, userName: string) {
    /*this.clientAdminService.deleteClient(clientID).subscribe(result => this.getClients());
    this.resetForm();*/
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши корисник',
        message: 'Дали сте сигурни дека сакате да го избришите корисникот: ' + userName + '?',
        true: 'Избриши',
        false: 'Откажи'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.userService.deleteUser(userID).subscribe(result => this.getUsers());
        this.resetForm()
        this.openSnackBar("Корисникот е успешно избришан!", "Затвори");
        this.editMode = false;
      }
    });
   }
  
   resetForm() {
     this.userForm.reset();
     this.aClips['checked'] = false;
     this.aTenders['checked'] = false;
     this.aBankruptcies['checked'] = false;
     this.aSales['checked'] = false;
     this.aNotifications['checked'] = false;
     this.aMediums['checked'] = false;
     this.aAuthors['checked'] = false;
     this.aTags['checked'] = false;
     this.aClients['checked'] = false;
     this.aSocials['checked'] = false;
     this.aAdministrators['checked'] = false;
   }

}
