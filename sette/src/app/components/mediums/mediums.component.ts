import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { Mediums } from 'src/app/services/mediums-services/mediums';
import { MediumTypeService } from 'src/app/services/medium-type-services/medium-type.service';
import { MediumType } from 'src/app/services/medium-type-services/mediumType';
import { MediumsService } from 'src/app/services/mediums-services/mediums.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from '../dialog/dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';
import { InfiniteScrollingService } from 'src/app/services/infinite-scrolling-service/infinite-scrolling.service';
import { FunMedium } from 'src/app/services/functions/fun-medium';
import { FunMediumService } from 'src/app/services/functions/fun-medium.service';
import { Clip } from 'src/app/services/clip-service/clip';
import { ClipService } from 'src/app/services/clip-service/clip.service';

@Component({
  selector: 'app-mediums',
  templateUrl: './mediums.component.html',
  styleUrls: ['./mediums.component.css']
})
export class MediumsComponent implements OnInit {

  public mediumsList: Mediums[];
  public funMediumList: FunMedium[];
  public mediumTypeList: MediumType[];
  public clipList: Clip[];
  selectedMediumType: string;
  public searchString: string;
  mediumTypeID: number;
  mediumType: string;
  mediumTypeMediumName: string;
  mediumTypeMediumID: number;
  mediums: Mediums;
  mediumName: string;
  x = 31;
  editMode = false;
  mediumForm: FormGroup;
  mediumID: number;
  selected = '';
  clips: Clip;

  public endLimit: number = 10;
  public mediumData: any = [];

  // public loading = true;
  // public page = 1;


  constructor(private mediumTypeService: MediumTypeService, private mediumService: MediumsService, private scrollService:InfiniteScrollingService, public authService: AuthenticationService, public http: HttpClient,
              private funMediumService: FunMediumService, private formBuilder: FormBuilder, public dialog: MatDialog,
              private _snackBar: MatSnackBar, private clipService: ClipService) { 
                this.mediums = new Mediums();
                this.clips = new Clip();
              }


  ngOnInit(): void {
    this.mediumForm = this.formBuilder.group({
      medium_name_cyrilic: ['', Validators.required],
      medium_name: ['', Validators.required],
      medium_type_id: ['', Validators.required]
    });
    this.getClip();
    this.getMediums();
    this.getMediumType();
    this.getFunMedium();
    //this.mediumTypeNameInMedium();

    this.getMediumData(this.endLimit); //for the first time

    this.scrollService.getObservable().subscribe(status => {
      if (status) {
        this.endLimit = this.endLimit + 10;
        this.getMediumData(this.endLimit);
      }
    })
  }
  getMediumData(endLimit: number) {
    this.mediumService.getMediumData(endLimit).subscribe(response => {
      this.mediumData = this.mediumData.concat(response);

      let clear = setInterval(() => {
        let target = document.querySelector(`#target${endLimit}`);
        if (target) {
          clearInterval(clear);
          this.scrollService.setObserver().observe(target);
        }
      }, 2000)
    },
      err => {
        console.log(err);
      })
  }

  @HostListener("window:scroll", ["$event"])
  onWindowScroll() {
    //In chrome and some browser scroll is given to body tag
    let pos = (document.documentElement.scrollTop || document.body.scrollTop) + document.documentElement.offsetHeight;
    let max = document.documentElement.scrollHeight;
    // pos/max will give you the distance between scroll bottom and and bottom of screen in percentage. 
    if (pos == max) {
      this.x += 2;
      console.log("end")
    }
  }

  openSnackBar(message: string, action: string,) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  selectChangeHandler(event: any) {
    this.selectedMediumType = event.target.value;
    console.log(this.selectedMediumType);
  }

  addMedium() {
    if (this.mediumForm.valid) {
      this.mediumService.addMediums(this.mediumForm.value).subscribe(result => this.getFunMedium());
      this.resetForm();
    }
  }

  editMedium(mediumID: number) {
    this.mediums.medium_name_cyrilic = this.mediumForm.controls['medium_name_cyrilic'].value;
    this.mediums.medium_name = this.mediumForm.controls['medium_name'].value;
    this.mediums.medium_type_id = this.mediumForm.controls['medium_type_id'].value;
    console.log(this.mediums);
    this.mediumService.updateMediums(this.mediums, mediumID).subscribe(result => this.getFunMedium());
    this.resetForm();
    this.editMode = false;
  }

  loadMedium(fullNameLatin: string, fullNameCyrilic: string, mediumTypeID: string) {
    this.mediumForm.controls['medium_name_cyrilic'].setValue(fullNameCyrilic)
    this.mediumForm.controls['medium_name'].setValue(fullNameLatin)
    this.mediumForm.controls['medium_type_id'].setValue(mediumTypeID)
  }

  deleteMedium(mediumID: number) {
        for (let clip of this.clipList) {
          if (clip.medium_id == mediumID) {
            this.clips.medium_id = -1;
            this.clipService.updateClip(clip.clip_id, this.clips).subscribe(result => this.getClip()); 
          }
        }
        this.mediumService.deleteMediums(mediumID).subscribe(result => this.getFunMedium());
        this.resetForm();

        this.editMode = false;
   }


  resetForm() {
    this.mediumForm.reset();
  }

  /*mediumTypeNameInMedium() {
    console.log('in mediumTypeNameInMedium ');
    if(this.mediumsList){
    for(var medium of this.mediumsList) {
      this.mediumTypeMediumID = medium.medium_type_id;
      for (var mediumType of this.mediumTypeList) {
        if (mediumType.medium_type_id == this.mediumTypeMediumID) {
          this.mediumTypeMediumName = mediumType.medium_type_name;
        }
      }
    }
  }
}*/

  public getMediums(): void {
    //console.log('in get Mediums');
    this.mediumService.getMediums().subscribe(
      (response: Mediums[]) => {
        this.mediumsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getMediumType(): void {
    // console.log('in get Medium Type');
    this.mediumTypeService.getMediumType().subscribe(
      (response: MediumType[]) => {
        this.mediumTypeList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getFunMedium(): void {
    //console.log('in get FunMediums');
    this.funMediumService.fun_mediums().subscribe(
      (response: FunMedium[]) => {
        this.funMediumList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


  // public pageChange(page) {
  //   this.page = page;
  //   //this.searchMediums(10);
  // }

public getClip(): void {
  this.clipService.getClip().subscribe(
    (response: Clip[]) => {
      this.clipList = response.sort((a,b) => (a.clip_id < b.clip_id ? -1: 1));
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

}
