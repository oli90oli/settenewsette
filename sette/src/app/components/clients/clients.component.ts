import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { clientAdmin } from 'src/app/services/client-admin-services/client-admin';
import { ClientAdminService } from 'src/app/services/client-admin-services/client-admin.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DialogComponent } from '../dialog/dialog.component';
import { DndDropEvent } from 'ngx-drag-drop';
import { Tags } from 'src/app/services/tags-service/tags';
import { TagsService } from 'src/app/services/tags-service/tags.service';
import { clientTags } from 'src/app/services/client-tags-service/client-tags';
import { ClientTagsService } from 'src/app/services/client-tags-service/client-tags.service';
import { FunClientService } from 'src/app/services/functions/fun-client.service';
import { FunClients } from 'src/app/services/functions/fun-clients';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {
  public clientList!: clientAdmin[];
  public funClientList: FunClients[];
  clients!: clientAdmin;
  public searchString: string;
  public switchForm = false;
  showOptions = false;
  showMailForm = false;
  showMailTenderForm = false;

  clientForm: FormGroup;
  clientID: number;
  editMode = false;
  clientName!: string;
  trialClients: number[] = []; 
  clipForm = true;
  businessForm = false;
  tagsList: Tags[];
  clientTagList: clientTags[];
  tagsToAdd: number[] = [];

  @ViewChild('followsClips') followsClips: ElementRef;
  @ViewChild('followsAnalytics') followsAnalytics: ElementRef;
  @ViewChild('followsTenders') followsTenders: ElementRef;
  @ViewChild('followsBankruptcies') followsBankruptcies: ElementRef;
  @ViewChild('followsSales') followsSales: ElementRef;
  @ViewChild('followsNotifications') followsNotifications: ElementRef;
  @ViewChild('isTrial') isTrial: ElementRef;
  @ViewChild('isLatin') isLatin: ElementRef;
  @ViewChild('showTags') showTags: ElementRef;

  constructor(public authService: AuthenticationService, public http: HttpClient, public clientAdminService: ClientAdminService,
              private formBuilder: FormBuilder, public dialog: MatDialog, private _snackBar: MatSnackBar, 
              private tagService: TagsService, private clientTagService: ClientTagsService,
              private funClientService: FunClientService) { 
    this.clients = new clientAdmin();
  }

  ngOnInit(): void {
    this.clientForm = this.formBuilder.group({
      client_name : ['',Validators.required],
      client_username : ['',Validators.required],
      client_password: ['',Validators.required],
      client_email: ['',Validators.required],
      client_bcc: ['',Validators.required],
      mail_title: ['',Validators.required],
      pdf_title: ['',Validators.required],
      follows_clips: [],
      follows_analytics: [''],
      follows_tenders: [''],
      follows_bankruptcies: [''],
      follows_notifications: [''],
      follows_sales: [''],
      is_latin: [''],
      is_trial: [''],
      is_tags: ['']
    });
    this.getFunClients();
    this.getClients();
    this.getTags();
    this.getClientTags();
  }

  checkMailForm() {
    if (this.showMailForm == false) { this.showMailForm = true }else{ this.showMailForm = false}
  }

  checkMailTenderForm() {
    if (this.showMailTenderForm == false) { this.showMailTenderForm = true }else{ this.showMailTenderForm = false}
  }

 changeForms() {
   if (this.clipForm) this.clipForm = false; else this.clipForm = true;
   if (this.businessForm) this.businessForm = false; else this.businessForm = true;
 }

  openSnackBar(message: string, action: string, ) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  
 selectTrialClients() {
  this.trialClients = [];
  for (let client of this.clientList) {
     if (client.is_trial) {
     this.trialClients.push(client.client_id)
     }
   }
   console.log(this.trialClients)
 }

  addClient(followsClips: boolean, followsAnalytics: boolean, followsTenders: boolean, followsBankruptcies: boolean, 
            followsSales: boolean, followsNotifications: boolean, isTrial: boolean, isLatin: boolean, showTags: boolean, ) {
    if(this.clientForm.valid) {
      this.clientForm.controls['follows_clips'].setValue(followsClips);
      this.clientForm.controls['follows_analytics'].setValue(followsAnalytics);
      this.clientForm.controls['follows_tenders'].setValue(followsTenders);
      this.clientForm.controls['follows_bankruptcies'].setValue(followsBankruptcies);
      this.clientForm.controls['follows_sales'].setValue(followsSales);
      this.clientForm.controls['follows_notifications'].setValue(followsNotifications);
      this.clientForm.controls['is_trial'].setValue(isTrial);
      this.clientForm.controls['is_latin'].setValue(isLatin);
      this.clientForm.controls['is_tags'].setValue(showTags);
      this.clientAdminService.addClient(this.clientForm.value).subscribe(result => this.getClients());
      this.resetForm();
      this.openSnackBar("Успешно додаден клиент!", "Затвори");
    }
  }

  print(a: boolean) {
    console.log(a);
  }

  editClient(clientID: number, followsClips : boolean,followsAnalytics,followsTenders,followsBankruptcies,
    followsSales, followsNotifications, isTrial, isLatin: boolean, showTags) {
    this.clients.client_name = this.clientForm.controls['client_name'].value;
    this.clients.client_username = this.clientForm.controls['client_username'].value;
    this.clients.client_password = this.clientForm.controls['client_password'].value;
    this.clients.client_email = this.clientForm.controls['client_email'].value;
    this.clients.client_bcc = this.clientForm.controls['client_bcc'].value;
    this.clients.mail_title = this.clientForm.controls['mail_title'].value;
    this.clients.pdf_title = this.clientForm.controls['pdf_title'].value;
    this.clients.follows_clips = followsClips;
    this.clients.follows_analytics = followsAnalytics;
    this.clients.follows_tenders =  followsTenders;
    this.clients.follows_bankruptcies = followsBankruptcies;
    this.clients.follows_sales = followsSales;
    this.clients.follows_notifications = followsNotifications;
    this.clients.is_latin = isLatin;
    this.clients.is_trial = isTrial;
    this.clients.is_tags = showTags;
    this.clientAdminService.updateClient(this.clients, clientID).subscribe(result => this.getClients());
    this.resetForm();
    this.openSnackBar('Клиентот е успешно изменет!','Затвори');
  }

  loadClient(name,username,password,email,bcc,mailTitle,pdfTitle,followsClips,followsAnalytics,followsTenders,followsBankruptcies,
             followsSales, followsNotifications, isTrial, isLatin, showTags) {
    this.clientForm.controls['client_name'].setValue(name)
    this.clientForm.controls['client_username'].setValue(username)
    this.clientForm.controls['client_password'].setValue(password)
    this.clientForm.controls['client_email'].setValue(email)
    this.clientForm.controls['client_bcc'].setValue(bcc)
    this.clientForm.controls['mail_title'].setValue(mailTitle)
    this.clientForm.controls['pdf_title'].setValue(pdfTitle)
    this.followsClips['checked'] = followsClips;
    this.followsAnalytics['checked'] = followsAnalytics;
    this.followsTenders['checked'] = followsTenders;
    this.followsBankruptcies['checked'] = followsBankruptcies;
    this.followsSales['checked'] = followsSales;
    this.followsNotifications['checked'] = followsNotifications;
    this.isLatin['checked'] = isLatin;
    this.isTrial['checked'] = isTrial;
    this.showTags['checked'] = showTags;
  }

  deleteClient(clientID: number, clientName: string) {
    /*this.clientAdminService.deleteClient(clientID).subscribe(result => this.getClients());
    this.resetForm();*/
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши клиент',
        message: 'Дали сте сигурни дека сакате да го избришите клиентот: ' + clientName + '?',
        true: 'Избриши',
        false: 'Откажи'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.clientAdminService.deleteClient(clientID).subscribe(result => this.getClients());
        this.resetForm()
        this.openSnackBar("Клиентот е успешно избришан!", "Затвори");
        this.editMode = false;
      }
    });
   }
  
   resetForm() {
     this.clientForm.reset();
     this.followsClips['checked'] = false;
     this.followsAnalytics['checked'] = false;
     this.followsTenders['checked'] = false;
     this.followsBankruptcies['checked'] = false;
     this.followsSales['checked'] = false;
     this.followsNotifications['checked'] = false;
     this.isLatin['checked'] = false;
     this.isTrial['checked'] = false;
     this.showTags['checked'] = false;
   }

  logOut() {
    this.authService.logOut();
  }

  public getClients(): void {
    this.clientAdminService.getClient().subscribe(
      (response: clientAdmin[]) => {
        this.clientList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getFunClients(): void {
    this.funClientService.fun_clients().subscribe(
      (response: FunClients[]) => {
        this.funClientList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getTags(): void {
    this.tagService.getTags().subscribe(
      (response: Tags[]) => {
        this.tagsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getClientTags(): void {
    this.clientTagService.getClientTags().subscribe(
      (response: clientTags[]) => {
        this.clientTagList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  onDrop(event:DndDropEvent) {
  }

  onDraggableCopied(event:DragEvent, tagID: number) {
  /*  var checkExistingTag = false;
    for (let clientTags of this.clientTagList) {
      if (clientTags.tag_id == tagID && clientTags.client_id == this.clipTagID) {
        checkExistingTag = true;
      }
    }
    if (!checkExistingTag) {
      this.clipTags.tag_id = tagID;
      if (this.selectedClips.length == 0) {
        this.clipTags.clip_id = this.clipTagID;
        this.clipTagService.addClipTag(this.clipTags).subscribe(result => this.getClipTags());
      } 
       if (this.selectedClips.length != 0) {
          for (let clipID of this.selectedClips) {
          this.clipTags.clip_id = clipID;
          this.clipTagService.addClipTag(this.clipTags).subscribe(result => this.getClipTags())
        }
        this.selectedClips = [];      
      }  
    } */
    if (!this.editMode) {
    if (!this.tagsToAdd.includes(tagID))
    this.tagsToAdd.push(tagID);
  }
}

removeTagFromClient(tagID: number) {
  this.tagsToAdd = this.tagsToAdd.filter(item => item !== tagID);
} 

onDraggableMoved(event:DragEvent) {}
    
onDragCanceled(event:DragEvent) {}

draggable = {
  data: "myDragData",
  effectAllowed: "all",
  disable: false,
  handle: false
};

onDragEnd(event:DragEvent) { }

}