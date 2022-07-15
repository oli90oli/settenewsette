import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/services/format-datepicker';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import pdfMake from "pdfmake/build/pdfmake";  
import pdfFonts from "pdfmake/build/vfs_fonts";  
import { Bankruptcies } from 'src/app/services/bankruptcies-service/bankruptcies';
import { BankruptciesService } from 'src/app/services/bankruptcies-service/bankruptcies.service';
import { DatePipe } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
pdfMake.vfs = pdfFonts.pdfMake.vfs;  

@Component({
  selector: 'app-bankruptcies',
  templateUrl: './bankruptcies.component.html',
  styleUrls: ['./bankruptcies.component.css'],
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
})
export class BankruptciesComponent implements OnInit {
  
  bankruptciesList: Bankruptcies[];
  filteredList: Bankruptcies[];
  bankruptciesForm: FormGroup;
  bankruptcyID: number;
  editMode = false;
  bankruptcies: Bankruptcies;
  searchString: string;
  selectedBankruptcies: number[] = [];
  filterMode = false;
  srcResult: any;

  @ViewChild('to') dateTo: ElementRef;
  @ViewChild('from') dateFrom: ElementRef;

  title: string;
  showBankruptciesForm: boolean = false;
  deptCtrl;
  required;
  datepickerRef1;

  constructor(public authService: AuthenticationService, private bankruptciesService: BankruptciesService, private formBuilder: FormBuilder,
              private datePipe: DatePipe, private _snackBar: MatSnackBar, private http: HttpClient) { 
                this.bankruptcies = new Bankruptcies();
              }

  ngOnInit(): void {
    this.bankruptciesForm = this.formBuilder.group({
      bankruptcy_name : ['',Validators.required],
      bankruptcy_embs : ['',Validators.required],
      bankruptcy_date : ['',Validators.required],
      bankruptcy_url: [''],
      bankruptcy_image: [''],
      bankruptcy_description: [''],
      bankruptcy_phase: ['',Validators.required]
    });
    this.getBankruptcies();
  }

  transformDate(date) {
    var dateToDB = this.datePipe.transform(date, 'dd-MM-yyyy'); 
    return dateToDB;
  }

  addBankruptcy() {
    if(this.bankruptciesForm.valid) {
      this.bankruptciesService.addBankruptcies(this.bankruptciesForm.value).subscribe(result => this.getBankruptcies());
      this.resetForm();
      this.openSnackBar("Успешно додаден стечај!", "Затвори");
    }
  }

  deleteBankruptcy(bankruptcyID: number) {
        this.bankruptciesService.deleteBankruptcies(bankruptcyID).subscribe(result => this.getBankruptcies());
        this.resetForm();
        this.openSnackBar("Стечајот е успешно избришан!", "Затвори");
  }

  loadBankruptcy(name: string, embs: string, date: string, url: string, image: string, description: string, phase: string) {
    this.bankruptciesForm.controls['bankruptcy_name'].setValue(name);
    this.bankruptciesForm.controls['bankruptcy_embs'].setValue(embs);
    this.bankruptciesForm.controls['bankruptcy_date'].setValue(date); 
    this.bankruptciesForm.controls['bankruptcy_url'].setValue(url);
    this.bankruptciesForm.controls['bankruptcy_image'].setValue(image);
    this.bankruptciesForm.controls['bankruptcy_description'].setValue(description); 
    this.bankruptciesForm.controls['bankruptcy_phase'].setValue(phase);
  }

  editBankruptcy(bankruptcyID: number) {
    this.bankruptcies.bankruptcy_name = this.bankruptciesForm.controls['bankruptcy_name'].value;
    this.bankruptcies.bankruptcy_embs = this.bankruptciesForm.controls['bankruptcy_embs'].value;
    this.bankruptcies.bankruptcy_date = this.bankruptciesForm.controls['bankruptcy_date'].value;
    this.bankruptcies.bankruptcy_url = this.bankruptciesForm.controls['bankruptcy_url'].value;
    this.bankruptcies.bankruptcy_image = this.bankruptciesForm.controls['bankruptcy_image'].value;
    this.bankruptcies.bankruptcy_description = this.bankruptciesForm.controls['bankruptcy_description'].value;
    this.bankruptcies.bankruptcy_phase = this.bankruptciesForm.controls['bankruptcy_phase'].value;
    this.bankruptciesService.updateBankruptcies(this.bankruptcies, bankruptcyID).subscribe(result => this.getBankruptcies());
    this.resetForm();
    this.openSnackBar("Стечајот е успешно изменет!", "Затвори");
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
        this.filteredList = this.bankruptciesList.filter(res => {
        return this.reverseDate(this.transformDate(res.bankruptcy_date)) <= this.reverseDate(dateTo);
        })
      }
      if(dateTo == "") {
          this.filteredList = this.bankruptciesList.filter(res => {
          return this.reverseDate(this.transformDate(res.bankruptcy_date)) >= this.reverseDate(dateFrom);
          })
      }
      if(dateTo != "" && dateFrom != "") {
        this.filteredList = this.bankruptciesList.filter(res => {
        return this.reverseDate(this.transformDate(res.bankruptcy_date)) >= this.reverseDate(dateFrom) && this.reverseDate(this.transformDate(res.bankruptcy_date)) <= this.reverseDate(dateTo);
        })
  }
  } 

  onFileSelected() {
    const inputNode: any = document.querySelector('#file');
  
    if (typeof (FileReader) !== 'undefined') {
      const reader = new FileReader();
  
      reader.onload = (e: any) => {
        this.srcResult = e.target.result;
      };
  
      reader.readAsArrayBuffer(inputNode.files[0]);
    }
    this.bankruptciesForm.controls['bankruptcy_image'].setValue('http://clipping.sette.com.mk/uploads/images/' + inputNode.files[0].name)
  }

  resetFilter() {
    this.filterMode = false;
  }

  selectBankruptcies(bankruptcyID: number) {
    if(this.selectedBankruptcies.includes(bankruptcyID)) {
      for (let i = 0; i < this.selectedBankruptcies.length; i++) {
      if (this.selectedBankruptcies[i] == bankruptcyID) {
      this.selectedBankruptcies.splice(i, 1);
       }
     }
    } else {
      this.selectedBankruptcies.push(bankruptcyID);
    }
    console.log(this.selectedBankruptcies)
}

  deleteMultipleBankruptcies() {
  for (let bankruptcyID of this.selectedBankruptcies) {
    this.bankruptciesService.deleteBankruptcies(bankruptcyID).subscribe(result => this.getBankruptcies());
  }
  this.selectedBankruptcies = [];
  this.openSnackBar("Селектираните стечаи се успешно избришани!", "Затвори");
}


  resetForm() {
    this.bankruptciesForm.reset();
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

  checkBankruptciesForm(){
      if (this.showBankruptciesForm == false) { this.showBankruptciesForm = true }else{ this.showBankruptciesForm = false}
  }
  
  public getBankruptcies(): void {
    this.bankruptciesService.getBankruptcies().subscribe(
      (response: Bankruptcies[]) => {
        this.bankruptciesList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

/* PDF */
generatePDF(action = 'open', name: string, embs: string, phase: string, desc: string) { 
  let docDefinition = {  
    content: [ 
      {
        // Header content
      },
      {
      columns: [
        [
        {},
        {text: "Име", bold: true},
        {text: "ЕМБС", bold: true},
        {text: "Фаза", bold: true},
        ],
        [
        {},
        {text: name},
        {text: embs},
        {text: phase},
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
