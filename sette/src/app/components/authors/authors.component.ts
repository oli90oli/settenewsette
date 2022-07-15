import { HttpClient, HttpClientModule, HttpErrorResponse } from '@angular/common/http';
import { Component, HostListener, Inject, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { Authors } from 'src/app/services/authors-service/authors';
import { AuthorsService } from 'src/app/services/authors-service/authors.service';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrls: ['./authors.component.css']
})

export class AuthorsComponent implements OnInit {
  public authorsList: Authors[];
  authors: Authors;
  
  public searchString: string;
  authorForm: FormGroup;
  authorID: number;
  editMode = false;
  authorName: string;

  private mode = 'create';
  private authorId: string;

  constructor(public http: HttpClient, private authorService: AuthorsService, public authService: AuthenticationService, 
              private formBuilder: FormBuilder, public dialog: MatDialog, private _snackBar: MatSnackBar) {
    this.authors = new Authors();
  }

  ngOnInit(): void {
    this.authorForm = this.formBuilder.group({
      full_name_c : ['',Validators.required],
      full_name_l : ['',Validators.required]
    });
    this.getAuthors();
  }

  openSnackBar(message: string, action: string, ) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

 addAuthor() {
   if(this.authorForm.valid) {
     this.authorService.addAuthors(this.authorForm.value).subscribe(result => this.getAuthors());
     this.resetForm();
   }
 }

 editAuthor(authorID: number) {
   this.authors.full_name_c = this.authorForm.controls['full_name_c'].value;
   this.authors.full_name_l = this.authorForm.controls['full_name_l'].value;
   this.authorService.updateAuthors(this.authors, authorID).subscribe(result => this.getAuthors());
   this.resetForm();
 }

 loadAuthor(fullNameLatin: string, fullNameCyrilic: string) {
   this.authorForm.controls['full_name_c'].setValue(fullNameCyrilic)
   this.authorForm.controls['full_name_l'].setValue(fullNameLatin)
 }

 deleteAuthor(authorID: number, authorName: string) {
      this.authorService.deleteAuthors(authorID).subscribe(result => this.getAuthors());
      this.resetForm();
      this.openSnackBar("Авторот е успешно избришан!", "Затвори");
      this.editMode = false;
 }

 resetForm() {
   this.authorForm.reset();
 }

 logOut() {
    this.authService.logOut();
  }

  public getAuthors(): void {
    this.authorService.getAuthors().subscribe(
      (response: Authors[]) => {
        this.authorsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
}



