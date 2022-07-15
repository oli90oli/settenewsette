import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { Tenders } from 'src/app/services/tenders-service/tenders';
import { TendersService } from 'src/app/services/tenders-service/tenders.service';
import { DialogComponent } from '../dialog/dialog.component';
import pdfMake from "pdfmake/build/pdfmake";  
import pdfFonts from "pdfmake/build/vfs_fonts";  
import { DialogTagsComponent } from '../dialog-tags/dialog-tags.component';
import { DialogTenderClientsComponent } from '../dialog-tender-clients/dialog-tender-clients.component';
import { StringDecoder } from 'string_decoder';
import { clientTags } from 'src/app/services/client-tags-service/client-tags';
import { ClientTagsService } from 'src/app/services/client-tags-service/client-tags.service';
import { ClientsService } from 'src/app/services/clients-service/clients.service';
import { clientAdmin } from 'src/app/services/client-admin-services/client-admin';
import { ClientAdminService } from 'src/app/services/client-admin-services/client-admin.service';
import { DndDropEvent } from 'ngx-drag-drop';
import { Tags } from 'src/app/services/tags-service/tags';
import { TagsService } from 'src/app/services/tags-service/tags.service';
import { TenderTagsService } from 'src/app/services/tender-tags-services/tender-tags.service';
import { TenderTags } from 'src/app/services/tender-tags-services/tenderTags';
import { FunTagService } from 'src/app/services/functions/fun-tag.service';
import { FunTags } from 'src/app/services/functions/fun-tags';
pdfMake.vfs = pdfFonts.pdfMake.vfs;   


@Component({
  selector: 'app-tenders',
  templateUrl: './tenders.component.html',
  styleUrls: ['./tenders.component.css']
})
export class TendersComponent implements OnInit {

  public tendersList: Tenders[];
  public tagsList: FunTags[];
  public tenderTagList: TenderTags[];
  tenders: Tenders;
  tenderTags: TenderTags;
  showTenderForm = false;
  showMailForm = false;
  showTenderClients = false;
  editMode = false;
  tenderID: number;
  tenderSubject: string;
  selectedTenders = [];
  openedTags: number[] = [];
  tenderTagID: number;

  tenderForm: FormGroup;
  tenderi: Tenders;    
  additionalDetails: string; 
  enteredUrl = true;
  enteredImage = true;
  enteredDescription = true;
  clientTagsList: clientTags[];
  clientTags: clientTags;
  clientList: clientAdmin[];
  client: clientAdmin;
  tenderTagsList: number[] = [];
  tenderClientsList: number[];

  constructor(public authService: AuthenticationService, private formBuilder: FormBuilder,
     private tenderService: TendersService, private dialog: MatDialog, private tenderTagService: TenderTagsService,
     private _snackBar: MatSnackBar, private datePipe: DatePipe, private funTagService: FunTagService,
     private clientTagService: ClientTagsService, private clientAdminService: ClientAdminService) { 
    this.tenders = new Tenders();
    this.clientTags = new clientTags();
    this.client = new clientAdmin();
    this.tenderTags = new TenderTags();
  }

  ngOnInit(): void {
    this.tenderForm = this.formBuilder.group({
      tender_type : ['',Validators.required],
      tender_medium : ['',Validators.required],
      tender_publisher: ['',Validators.required],
      tender_subject: ['', Validators.required],
      tender_description: [''],
      tender_url: [''],
      tender_image: [''],
      tender_date: ['',  Validators.required],
      tender_expire: ['',Validators.required],
    });
    this.getTenders();
    this.getClientTags();
    this.getClients();
    this.getTags();
    this.getTenderTags();
  }

  removeTagFromTender(tagID: number) {
    this.tenderTagService.deleteTenderTag(tagID).subscribe(result => this.getTenderTags());
}

  selectTender(tenderID: number, tenderCheckBox: boolean) {    
    if (!tenderCheckBox) { 
       this.selectedTenders.push(tenderID);
    } 
    else {  
       for (let i = 0; i < this.selectedTenders.length; i++) {
          if (this.selectedTenders[i] == tenderID) {
              this.selectedTenders.splice(i, 1);
      }
    }
  }
  console.log(this.selectedTenders);
  } 

  addTagToTenderByCheck(tagID: number) {
    var checkExistingTag = false;
      for (let tenderTags of this.tenderTagList) {
        if (tenderTags.tag_id == tagID && this.selectedTenders.includes(tenderTags.tender_id)) {
          checkExistingTag = true;
        }
      }
    if (!checkExistingTag) {
    for (let tenderID of this.selectedTenders) {
      this.tenderTags.tender_id = tenderID;
      this.tenderTags.tag_id = tagID;
      this.tenderTagService.addTenderTag(this.tenderTags).subscribe(result => this.getTenderTags());
    }
  }
  }

  changeTenderType() {
    if (this.tenderForm.controls['tender_type'].value == "Други огласи") {
      this.tenderForm.controls['tender_medium'].setValue("Други огласи");
      this.tenderForm.controls['tender_url'].setValue("https://e-nabavki.gov.mk/PublicAccess/home.aspx#/otherannouncements"); 
    }
    if (this.tenderForm.controls['tender_type'].value == "Технички дијалог") {
      this.tenderForm.controls['tender_medium'].setValue("Технички дијалог");
      this.tenderForm.controls['tender_url'].setValue("https://e-nabavki.gov.mk/PublicAccess/home.aspx#/technical-dialog-announcements"); 
    }
    if (this.tenderForm.controls['tender_type'].value == "Останато") {
      this.tenderForm.controls['tender_medium'].setValue("");
      this.tenderForm.controls['tender_url'].setValue(""); 
    }
  } 

  disableFormInput(){
    if (this.tenderForm.controls['tender_url'].value != "") {
      this.tenderForm.controls['tender_description'].disable();
      this.tenderForm.controls['tender_image'].disable();
    }
    if (this.tenderForm.controls['tender_image'].value != "") {
      this.tenderForm.controls['tender_description'].disable();
      this.tenderForm.controls['tender_url'].disable();
    } 
    if (this.tenderForm.controls['tender_description'].value != "") {
      this.tenderForm.controls['tender_url'].disable();
      this.tenderForm.controls['tender_image'].disable();
    }
    if (this.tenderForm.controls['tender_url'].value == "" && this.tenderForm.controls['tender_description'].value == "" && this.tenderForm.controls['tender_image'].value == "" ) {
      this.tenderForm.controls['tender_url'].enable();
      this.tenderForm.controls['tender_description'].enable();
      this.tenderForm.controls['tender_image'].enable();
    }
  }

  transformDate(date) {
    var dateToDB = this.datePipe.transform(date, 'dd-MM-yyyy'); 
    return dateToDB;
  }

  generatePDF(action = 'open', tenderMedium: string, tenderPublisher: string, tenderSubject: string) { 
    console.log(tenderPublisher, tenderSubject)
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
          ],
          [
          {},
          {text: tenderMedium},
          {text: tenderPublisher},
          {text: tenderSubject}
          ],
        ]
        },
       {
        // Footer content
      },
      ],
        styles: {} // Styles 
    }

    if(action==='download'){    
      pdfMake.createPdf(docDefinition).download();    
    }else if(action === 'print'){    
      pdfMake.createPdf(docDefinition).print();          
    }else{    
      pdfMake.createPdf(docDefinition).open();          
    }
  }   

  addTender() {
    if(this.tenderForm.valid) {
      this.tenderService.addTender(this.tenderForm.value).subscribe(result => this.getTenders());
      this.resetForm();
    }
  }

  public getTenders(): void {
    this.tenderService.getTenders().subscribe(
      (response: Tenders[]) => {
        this.tendersList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getClientTags(): void {
    this.clientTagService.getClientTags().subscribe(
      (response: clientTags[]) => {
        this.clientTagsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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

  openSnackBar(message: string, action: string, ) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  editTender(tenderID: number) {
    this.tenders.tender_type = this.tenderForm.controls['tender_type'].value;
    this.tenders.tender_medium = this.tenderForm.controls['tender_medium'].value;
    this.tenders.tender_publisher = this.tenderForm.controls['tender_publisher'].value;
    this.tenders.tender_subject = this.tenderForm.controls['tender_subject'].value;
    this.tenders.tender_description = this.tenderForm.controls['tender_description'].value;
    this.tenders.tender_url = this.tenderForm.controls['tender_url'].value;
    this.tenders.tender_date = this.tenderForm.controls['tender_date'].value;
    this.tenders.tender_expire = this.tenderForm.controls['tender_expire'].value;
    this.tenderService.updateTender(tenderID, this.tenders).subscribe(result => this.getTenders());
    this.resetForm();
    this.openSnackBar('Тендерот е успешно изменет!','Затвори');
    this.editMode = false;
  }

  loadTender(tenderType: string, tenderMedium: string, tenderPublisher: string,
     tenderSubject: string, tenderDescription: string, tenderURL: string, 
     tenderDate: string, tenderExpire: string) {
    this.showTenderForm = true;
    this.tenderForm.controls['tender_type'].setValue(tenderType);
    this.tenderForm.controls['tender_medium'].setValue(tenderMedium);
    this.tenderForm.controls['tender_publisher'].setValue(tenderPublisher);
    this.tenderForm.controls['tender_subject'].setValue(tenderSubject);
    this.tenderForm.controls['tender_description'].setValue(tenderDescription);
    this.tenderForm.controls['tender_url'].setValue(tenderURL);
    this.tenderForm.controls['tender_date'].setValue(tenderDate);
    this.tenderForm.controls['tender_expire'].setValue(tenderExpire);
  }

  tenderClients(tenderID: number, tenderName: string) {
    this.tenderClientsList = [];
    var clientNames: string[] = [];
    this.tenderTagsList = [];

    for (let tenderTag of this.tenderTagList) {
      if (tenderTag.tender_id == tenderID) {
        this.tenderTagsList.push(tenderTag.tag_id)
      }
    }

    for (let clientTag of this.clientTagsList) {
      if (this.tenderTagsList.includes(clientTag.tag_id)) {
        this.tenderClientsList.push(clientTag.client_id)
      }
    }

    for (let client of this.clientList) {
      if (this.tenderClientsList.includes(client.client_id)) {
        clientNames.push(client.client_name)
      }
    }

    const confirmDialog = this.dialog.open(DialogTenderClientsComponent, {
      data: {
        title: 'Клиенти',
        explain: 'Клиенти поврзани со тендерот: ' + tenderName,
        message: clientNames,
        false: 'Затвори'
      }
    });
  }

  deleteTender(tenderID: number, tenderSubject: string) {
    /*this.mediumService.deleteMediums(mediumID).subscribe(result => this.getMediums());
    this.resetForm();*/
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши тендер',
        message: 'Дали сте сигурни дека сакате да го избришите тендерот: ' + tenderSubject + '?',
        true: 'Избриши',
        false: 'Откажи'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.tenderService.deleteTender(tenderID).subscribe(result => this.getTenders());
        this.resetForm();
        this.editMode = false;
        this.openSnackBar("Тендерот е успешно избришан!", "Затвори");
      }
    });
   }
  
   resetForm() {
     this.tenderForm.reset();
   }


logOut() {
    this.authService.logOut();
  }

checkTenderForm() {
  if (this.showTenderForm == false) { this.showTenderForm = true }else{ this.showTenderForm = false}
}

checkMailForm() {
  if (this.showMailForm == false) { this.showMailForm = true }else{ this.showMailForm = false}
}

checkTenderClients() {
  if (this.showTenderClients == false) { this.showTenderClients = true }else{ this.showTenderClients = false}
}

draggable = {
  data: "myDragData",
  effectAllowed: "all",
  disable: false,
  handle: false
};

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

public getTenderTags(): void {
  this.tenderTagService.getTenderTags().subscribe(
    (response: TenderTags[]) => {
      this.tenderTagList = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

onDragEnd(event:DragEvent) { }

onDraggableCopied(event:DragEvent, tagID: number) {
  var checkExistingTag = false;
  for (let tenderTag of this.tenderTagList) {
    if ( tenderTag.tag_id == tagID && tenderTag.tender_id == this.tenderTagID) {
      checkExistingTag = true;
    }
  }
  if (!checkExistingTag) {
    this.tenderTags.tag_id = tagID;
    if (this.selectedTenders.length == 0) {
      this.tenderTags.tender_id = this.tenderTagID;
      this.tenderTagService.addTenderTag(this.tenderTags).subscribe(result => this.getTenderTags());
    } 
     if (this.selectedTenders.length != 0) {
        for (let tenderID of this.selectedTenders) {
        this.tenderTags.tender_id = tenderID;
        this.tenderTagService.addTenderTag(this.tenderTags).subscribe(result => this.getTenderTags())
      }
      this.selectedTenders = [];      
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

onDraggableMoved(event:DragEvent) {}
    
onDragCanceled(event:DragEvent) {}

onDrop(event:DndDropEvent,  tenderID: number) {
  this.tenderTagID = tenderID;
}

}