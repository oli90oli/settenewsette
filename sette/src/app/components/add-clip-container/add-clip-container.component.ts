import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../../services/administrator-login-services/authentication.service';
import { Authors } from '../../services/authors-service/authors';
import { AuthorsService } from '../../services/authors-service/authors.service';
import { Clip } from '../../services/clip-service/clip';
import { ClipService } from '../../services/clip-service/clip.service';
import { Gridkeywords } from '../../services/gridkeywords-services/gridkeywords';
import { GridkeywordsService } from '../../services/gridkeywords-services/gridkeywords.service';
import { Mediums } from '../../services/mediums-services/mediums';
import { MediumsService } from '../../services/mediums-services/mediums.service';
import { Tags } from '../../services/tags-service/tags';
import { TagsService } from '../../services/tags-service/tags.service';
import { DialogComponent } from '../dialog/dialog.component';


@Component({
  selector: 'app-add-clip-container',
  templateUrl: './add-clip-container.component.html',
  styleUrls: ['./add-clip-container.component.css']
})
export class AddClipContainerComponent implements OnInit {
  
  brojac: number = 0;
  keywords: string = '';
  title: string;
  mediumTitle: string;
  authorTitle: string;
  selectedMedium!: string;
  mediumID: number;
  clipDateName: string;
  val = false;
  clipMediumID!: number;
  clipMediumName!: string;
  
  public clipList: Clip[];
  public tagsList: Tags[];
  public mediumsList: Mediums[];
  public authorsList: Authors[];
  public gridkeywordList: Gridkeywords[];

  clips: Clip;
  mediums: Mediums;
  authors: Authors;

  editMode = false;
  translateMode = false;
  clipForm: FormGroup;
  keywordForm: FormGroup;
  clipIDForm: number; 
  selectedKeyword: string;
  dialog: any;

  constructor(private gridkeywordService: GridkeywordsService, private mediumService: MediumsService, 
              private authorService: AuthorsService, private tagService: TagsService, private clipService: ClipService, 
              private authService: AuthenticationService, private formBuilder: FormBuilder, private _snackBar: MatSnackBar) 
  {
    this.clips = new Clip();
    this.mediums = new Mediums();
    this.authors = new Authors();
  }

  ngOnInit(): void {
    this.clipForm = this.formBuilder.group({
      medium_id : ['',Validators.required],
      created_at : ['',Validators.required],
      date_of_clip: ['',Validators.required],
      clip_title: ['', Validators.required],
      clip_title_english: [''],
      clip_text: ['', Validators.required],
      brief: ['',Validators.required],
      brief_english: [''],
      clip_url: ['', Validators.required],
      clip_image_url: [''],
      important_information: ['']
    });
    this.keywordForm = this.formBuilder.group({
      keyword: ['']
    });
    this.getClip();
    this.getTags();
    this.getMediums();
    this.getAuthors();
    this.getGridkeywords();
    this.clipMedium();
  }
 
  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  addClip(importantInformation: boolean) {
    if(this.clipForm.valid) {
      this.clipForm.controls['important_information'].setValue(importantInformation);
      this.clipService.addClip(this.clipForm.value).subscribe(result => this.getClip());
      this.resetForm();
      this.openSnackBar("Успешно додаден клип!", "Затвори");
    }
  }

  editClip(clipID: number) {
    this.clips.medium_id = this.clipForm.controls['medium_id'].value;
    this.clips.created_at = this.clipForm.controls['created_at'].value;
    this.clips.date_of_clip = this.clipForm.controls['date_of_clip'].value;
    this.clips.clip_title = this.clipForm.controls['clip_title'].value;
    this.clips.clip_text = this.clipForm.controls['clip_text'].value;
    this.clips.brief = this.clipForm.controls['brief'].value;
    this.clips.clip_url = this.clipForm.controls['clip_url'].value;
    this.clips.clip_image_url = this.clipForm.controls['clip_image_url'].value;
    this.clips.important_information = this.clipForm.controls['important_information'].value;
    this.clipService.updateClip(clipID,this.clips).subscribe(result => this.getClip());
    this.resetForm();
    this.openSnackBar("Клипот е успешно изменет!", "Затвори");
  }

 translateClip(clipID: number) {
  this.clips.clip_title_english = this.clipForm.controls['clip_title_english'].value;
  this.clips.clip_text_english = this.clipForm.controls['clip_text_english'].value;
  this.clips.brief_english = this.clipForm.controls['brief_english'].value;
  this.editClip(clipID);
  this.openSnackBar("Клипот е успешно преведен!", "Затвори");
 }

  loadClip(mediumName: number, createdAt: Date, dateOfClip: string, clipTitle: string, clipTitleEnglish: string,
           clipText: string, clipTextEnglish: string, clipBrief: string, clipBriefEnglish: string,
           clipUrl: string, clipImageUrl: string, importantInformation: boolean) {
    this.clipForm.controls['medium_id'].setValue(mediumName);
    this.clipForm.controls['created_at'].setValue(createdAt);
    this.clipForm.controls['date_of_clip'].setValue(dateOfClip);
    this.clipForm.controls['clip_title'].setValue(clipTitle);
    this.clipForm.controls['clip_title_english'].setValue(clipTitleEnglish);
    this.clipForm.controls['clip_text'].setValue(clipText);
    this.clipForm.controls['clip_text_english'].setValue(clipTextEnglish);
    this.clipForm.controls['brief'].setValue(clipBrief);
    this.clipForm.controls['brief_english'].setValue(clipBriefEnglish);
    this.clipForm.controls['clip_url'].setValue(clipUrl);
    this.clipForm.controls['clip_image_url'].setValue(clipImageUrl);
    this.clipForm.controls['important_information'].setValue(importantInformation);
  }

  deleteClip(clipID: number) {
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши клип',
        message: 'Дали сте сигурни дека сакате да го избришите клипот?'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.clipService.deleteClip(clipID).subscribe(result => this.getClip());
        this.resetForm();
        this.openSnackBar("Клипот е успешно избришан!", "Затвори");
      }
    });
   }

  resetForm() {
    this.clipForm.reset();
  }

  searchMedium() {
    if (this.mediumTitle = "") {
      this.ngOnInit();
    }
    this.mediumsList = this.mediumsList.filter(res => {
      return res.medium_name_cyrilic.toLocaleLowerCase().match(this.mediumTitle.toLocaleLowerCase());
    })
  }

  searchAuthor() {
    if (this.authorTitle = "") {
      this.ngOnInit();
    }
    this.authorsList = this.authorsList.filter(res => {
      return res.full_name_c.toLocaleLowerCase().match(this.authorTitle.toLocaleLowerCase());
    })
  }
 
 generateBrief() {
    if (this.clipForm.controls['clip_text'].value.length <= 250)
    this.clipForm.controls['brief'].setValue(this.clipForm.controls['clip_text'].value)
    if (this.clipForm.controls['clip_text'].value.length > 250)
    this.clipForm.controls['brief'].setValue(this.clipForm.controls['clip_text'].value.slice(0,250) + ' ...')
  }

  showKeywords() {
    this.selectedKeyword = window.getSelection()?.toString();
    if (this.keywordForm.controls['keyword'].value == "")
    this.keywordForm.controls['keyword'].setValue(this.selectedKeyword)
    else if (!this.keywordForm.controls['keyword'].value.toLocaleLowerCase().includes(this.selectedKeyword.toLocaleLowerCase())) 
    this.keywordForm.controls['keyword'].setValue(this.keywordForm.controls['keyword'].value + ', ' + this.selectedKeyword)
  }

  addKeywords() {
    var keywords: Gridkeywords[];
    keywords = this.keywordForm.controls['keyword'].value.split(', ');
      console.log(keywords)
  }






  clipMedium() {
    for (let clip of this.clipList) {
      this.clipMediumID = clip.medium_id;
      for (var medium of this.mediumsList) {
        if (medium.medium_id == this.clipMediumID) {
          this.clipMediumName = medium.medium_name_cyrilic;
        }
      }
    }
  }

  filterDates(dateFrom: string, dateTo: string) {
    if (dateFrom == "" && dateTo == "") {
      this.getClip();
    } else if (dateFrom == "") {
      this.clipList = this.clipList.filter(
        res => new Date(res.date_of_clip) <= new Date(dateTo)
      );
    } else if (dateTo == "") {
      this.clipList = this.clipList.filter(
        res => new Date(res.date_of_clip) >= new Date(dateFrom)
      );
    } else {
      this.clipList = this.clipList.filter(
        res => new Date(res.date_of_clip) >= new Date(dateFrom) && new Date(res.date_of_clip) <= new Date(dateTo)
      );
    }
  }

  getSelectedKeyword(event: any, words: string) {
    this.selectedKeyword = window.getSelection()?.toString();
    if (!words.toLocaleLowerCase().includes(this.selectedKeyword))
      this.keywords += " *" + this.selectedKeyword + "* ";
  }

  searchKeyword(text: string, words: string) {
    if (text == '') {
      this.keywords = '';
    } else {
      for (var keyword of this.gridkeywordList) {
        if (!words.toLocaleLowerCase().includes(keyword.keyword.toLocaleLowerCase())) {
          if (text.toLocaleLowerCase().includes(keyword.keyword.toLocaleLowerCase())) {
            this.keywords += " *" + keyword.keyword + "* ";
          }
        }
      }
    }
  }

  

  Search() {
    if (this.title == "") {
      this.ngOnInit();
    }
    this.clipList = this.clipList.filter(res => {
      return res.clip_title.toLocaleLowerCase().match(this.title.toLocaleLowerCase());
    })
  }

  selectChangeHandler(event: any) {
    this.selectedMedium = event.target.value;
    console.log(this.selectedMedium)
  }


  onSubmit() {
    for (var medium of this.mediumsList) {
      if (this.selectedMedium == medium.medium_name_cyrilic) {
        this.mediumID = medium.medium_id;
        this.clips.medium_id = this.mediumID;
        this.clipService.addClip(this.clips).subscribe(result => this.getClip());
      }
    }
  }

  onClick(id: number) {
    this.clipService.deleteClip(id).subscribe(result => this.getClip());
  }

  logOut() {
    this.authService.logOut();
  }

  public getClip(): void {
    this.clipService.getClip().subscribe(
      (response: Clip[]) => {
        this.clipList = response;
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

  public getGridkeywords(): void {
    this.gridkeywordService.getGridkeywords().subscribe(
      (response: Gridkeywords[]) => {
        this.gridkeywordList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getMediums(): void {
    this.mediumService.getMediums().subscribe(
      (response: Mediums[]) => {
        this.mediumsList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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




