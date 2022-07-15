import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/services/format-datepicker';
import { Notifications } from 'src/app/services/notifications-service/notifications';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NotificationsService } from 'src/app/services/notifications-service/notifications.service';
import { DatePipe } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import pdfMake from "pdfmake/build/pdfmake";  
import pdfFonts from "pdfmake/build/vfs_fonts";  
import { FunTagService } from 'src/app/services/functions/fun-tag.service';
import { FunTags } from 'src/app/services/functions/fun-tags';
import { NotificationTagsService } from 'src/app/services/notification-tags-service/notification-tags.service';
import { NotificationTags } from 'src/app/services/notification-tags-service/notificationTags';
import { DndDropEvent } from 'ngx-drag-drop';
pdfMake.vfs = pdfFonts.pdfMake.vfs;  

@Component({
  selector: 'app-nostrifications',
  templateUrl: './nostrifications.component.html',
  styleUrls: ['./nostrifications.component.css'], 
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
})
export class NostrificationsComponent implements OnInit {

  notificationsList: Notifications[];
  tagsList: FunTags[];
  notificationTagsList: NotificationTags[];
  filteredList: Notifications[];
  notificationsForm: FormGroup;
  mailForm: FormGroup;
  notificationID: number;
  editMode = false;
  notifications: Notifications;
  notificationTags: NotificationTags;
  searchString: string;
  selectedNotifications: number[] = [];
  filterMode = false;
  srcResult: any;
  notificationTagID: number;
  openedTags: number[] = [];
  
  @ViewChild('to') dateTo: ElementRef;
  @ViewChild('from') dateFrom: ElementRef;

  title: string;
  showNotificationsForm: boolean = false;
  showMailForm: boolean = false;
  deptCtrl;
  required;
  datepickerRef1;

  constructor(public authService: AuthenticationService, private notificationsService: NotificationsService, private formBuilder: FormBuilder,
              private datePipe: DatePipe, private _snackBar: MatSnackBar, private http: HttpClient,
              private funTagService: FunTagService, private notificationTagsService: NotificationTagsService) { 
                this.notifications = new Notifications();
                this.notificationTags = new NotificationTags();
              }

  ngOnInit(): void {
    this.notificationsForm = this.formBuilder.group({
      notification_medium : ['',Validators.required],
      notification_publisher : ['',Validators.required],
      notification_subject: ['',Validators.required],
      notification_holder: ['', Validators.required],
      notification_url: [''],
      notification_description: [''],
      notification_date: ['', Validators.required],
    });
    this.mailForm = this.formBuilder.group({
      client_name: ['', Validators.required],
      client_mail: ['', Validators.required]
    })
    this.getNotifications();
    this.getTags();
    this.getNotificationTags();
  }

  addTagToNotificationByCheck(tagID: number) {
    var checkExistingTag = false;
      for (let notificationTags of this.notificationTagsList) {
        if (notificationTags.tag_id == tagID && this.selectedNotifications.includes(notificationTags.notification_id)) {
          checkExistingTag = true;
        }
      }
    if (!checkExistingTag) {
    for (let notificationID of this.selectedNotifications) {
      this.notificationTags.notification_id = notificationID;
      this.notificationTags.tag_id = tagID;
      this.notificationTagsService.addNotificationTag(this.notificationTags).subscribe(result => this.getNotificationTags());
    }
  }
  }

  draggable = {
    data: "myDragData",
    effectAllowed: "all",
    disable: false,
    handle: false
  };

  onDraggableCopied(event:DragEvent, tagID: number) {
    var checkExistingTag = false;
    for (let notificationTag of this.notificationTagsList) {
      if ( notificationTag.tag_id == tagID && notificationTag.notification_id == this.notificationTagID) {
        checkExistingTag = true;
      }
    }
    if (!checkExistingTag) {
      this.notificationTags.tag_id = tagID;
      if (this.selectedNotifications.length == 0) {
        this.notificationTags.notification_id = this.notificationTagID;
        this.notificationTagsService.addNotificationTag(this.notificationTags).subscribe(result => this.getNotificationTags());
      } 
       if (this.selectedNotifications.length != 0) {
          for (let notificationID of this.selectedNotifications) {
          this.notificationTags.notification_id = notificationID;
          this.notificationTagsService.addNotificationTag(this.notificationTags).subscribe(result => this.getNotificationTags())
        }
        this.selectedNotifications = [];      
      }  
    }
  }

  tagOpened(tagID: number) {
    if(this.openedTags.includes(tagID)) {
      for (let i = 0; i < this.openedTags.length; i++) {
      if (this.openedTags[i] == tagID) {
      this.openedTags.splice(i, 1);
       }
     }
    } else {
      this.openedTags.push(tagID);
    }
    console.log(this.openedTags)
  }

  onDragEnd(event:DragEvent) { }

  onDraggableMoved(event:DragEvent) {}
    
  onDragCanceled(event:DragEvent) {}  
  
  onDrop(event:DndDropEvent,  notificationID: number) {
    this.notificationTagID = notificationID;
  }

  selectNotification(notificationID: number, notificationCheckbox: boolean) {    
    if (notificationCheckbox) { 
       this.selectedNotifications.push(notificationID);
    } 
    else {  
       for (let i = 0; i < this.selectedNotifications.length; i++) {
          if (this.selectedNotifications[i] == notificationID) {
              this.selectedNotifications.splice(i, 1);
      }
    }
  }
  console.log(this.selectedNotifications);
  } 

  removeTagFromNotification(tagID: number) {
    this.notificationTagsService.deleteNotificationTag(tagID).subscribe(result => this.getNotificationTags());
}

  transformDate(date) {
    var dateToDB = this.datePipe.transform(date, 'dd-MM-yyyy'); 
    return dateToDB;
  }

  addNotifications() {
    if(this.notificationsForm.valid) {
      this.notificationsService.addNotifications(this.notificationsForm.value).subscribe(result => this.getNotifications());
      this.resetForm();
      this.openSnackBar("Успешно додадено известување!", "Затвори");
    }
  }

  deleteNotification(notificationID: number) {
        this.notificationsService.deleteNotifications(notificationID).subscribe(result => this.getNotifications());
        this.resetForm();
        this.openSnackBar("Известувањето е успешно избришано!", "Затвори");
  }

  loadNotification(medium: string, publisher: string, subject: string, holder: boolean, url: string, description: string, date: string) {
    this.notificationsForm.controls['notification_medium'].setValue(medium);
    this.notificationsForm.controls['notification_publisher'].setValue(publisher); 
    this.notificationsForm.controls['notification_subject'].setValue(subject);
    this.notificationsForm.controls['notification_holder'].setValue(holder);
    this.notificationsForm.controls['notification_url'].setValue(url); 
    this.notificationsForm.controls['notification_description'].setValue(description);
    this.notificationsForm.controls['notification_date'].setValue(date);
  }

  editNotification(notificationID: number) {
    this.notifications.notification_medium = this.notificationsForm.controls['notification_medium'].value;
    this.notifications.notification_publisher = this.notificationsForm.controls['notification_publisher'].value;
    this.notifications.notification_subject = this.notificationsForm.controls['notification_subject'].value;
    this.notifications.notification_holder = this.notificationsForm.controls['notification_holder'].value;
    this.notifications.notification_url = this.notificationsForm.controls['notification_url'].value;
    this.notifications.notification_description = this.notificationsForm.controls['notification_description'].value;
    this.notifications.notification_date = this.notificationsForm.controls['notification_date'].value;
    this.notificationsService.updateNotifications(this.notifications, notificationID).subscribe(result => this.getNotifications());
    this.resetForm();
    this.openSnackBar("Известувањето е успешно изменето!", "Затвори");
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  reverseDate(date: string) {
    const reverse = new Date(date.split("-").reverse().join("-"));
    return reverse.getTime();
  }

  filterByDate(dateFrom: string, dateTo: string) {
      this.filterMode = true;
      if(dateFrom == "") {
        this.filteredList = this.notificationsList.filter(res => {
        return this.reverseDate(this.transformDate(res.notification_date)) <= this.reverseDate(dateTo);
        })
      }
      if(dateTo == "") {
          this.filteredList = this.notificationsList.filter(res => {
          return this.reverseDate(this.transformDate(res.notification_date)) >= this.reverseDate(dateFrom);
          })
      }
      if(dateTo != "" && dateFrom != "") {
        this.filteredList = this.notificationsList.filter(res => {
        return this.reverseDate(this.transformDate(res.notification_date)) >= this.reverseDate(dateFrom) && this.reverseDate(this.transformDate(res.notification_date)) <= this.reverseDate(dateTo);
        })
  }
  }

  resetFilter() {
    this.filterMode = false;
  }


deleteMultipleNotifications() {
  for (let notificationID of this.selectedNotifications) {
    this.notificationsService.deleteNotifications(notificationID).subscribe(result => this.getNotifications());
  }
  this.selectedNotifications = [];
  this.openSnackBar("Селектираните известувања се успешно избришани!", "Затвори");
}


  resetForm() {
    this.notificationsForm.reset();
  }


  logOut() {
    this.authService.logOut();
  }

  Search() {
    if (this.title == "") {
      this.ngOnInit();
    }
    /*this.clipList = this.clipList.filter(res => {
      return res.clip_title.toLocaleLowerCase().match(this.title.toLocaleLowerCase());
    })*/
  }

  checkNotificationsForm(){
      if (this.showNotificationsForm == false) { this.showNotificationsForm = true }else{ this.showNotificationsForm = false}
  }

  checkMailForm() {
    if (this.showMailForm == false) { this.showMailForm = true }else{ this.showMailForm = false}
  }
  
  public getNotifications(): void {
    this.notificationsService.getNotifications().subscribe(
      (response: Notifications[]) => {
        this.notificationsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getTags(): void {
    this.funTagService.fun_tags().subscribe(
      (response: FunTags[]) => {
        this.tagsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getNotificationTags(): void {
    this.notificationTagsService.getNotificationTags().subscribe(
      (response: NotificationTags[]) => {
        this.notificationTagsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

/* PDF */
generatePDF(action = 'open', medium: string, publisher: string, subject: string, holder: string, date: string, desc: string) { 
  let docDefinition = {  
    content: [ 
      {
        // Header content
      },
      {
      columns: [
        [
        {},
        {text: "Медиум", bold: true},
        {text: "Договорен орган", bold: true},
        {text: "Предмет на договор", bold: true},
        {text: "Носител", bold: true},
        {text: "Датум", bold: true},
        ],
        [
        {},
        {text: medium},
        {text: publisher},
        {text: subject},
        {text: holder},
        {text: this.transformDate(date)},
        ],
      ],
      },
     {
      // Footer content
    },
    {
      /*layout: 'lightHorizontalLines', // optional*/
      table: {
        style: 'center',
        headerRows: 1,
        widths: [ '*', '0', 4, '0' ],

        body: [
          [ 'Опис'],
          [desc],
        ]
      }
    }
    ],
      styles: {
        center: {
          alignment: 'center'
        }
      } // Styles 
  }

  if(action==='download'){    
    pdfMake.createPdf(docDefinition).download();    
  }else if(action === 'print'){    
    pdfMake.createPdf(docDefinition).print();          
  }else{    
    pdfMake.createPdf(docDefinition).open();          
  }
}   


}