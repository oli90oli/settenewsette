import { CdkDragDrop, copyArrayItem, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import { DatePipe } from '@angular/common';
import { HttpClient, HttpErrorResponse} from '@angular/common/http';
import { i18nMetaToJSDoc } from '@angular/compiler/src/render3/view/i18n/meta';
import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DndDropEvent } from 'ngx-drag-drop';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { Authors } from 'src/app/services/authors-service/authors';
import { AuthorsService } from 'src/app/services/authors-service/authors.service';
import { Clip } from 'src/app/services/clip-service/clip';
import { ClipService } from 'src/app/services/clip-service/clip.service';
import { clipTags } from 'src/app/services/clip-tags-service/clip-tags';
import { ClipTagsService } from 'src/app/services/clip-tags-service/clip-tags.service';
import { Gridkeywords } from 'src/app/services/gridkeywords-services/gridkeywords';
import { GridkeywordsService } from 'src/app/services/gridkeywords-services/gridkeywords.service';
import { Mediums } from 'src/app/services/mediums-services/mediums';
import { MediumsService } from 'src/app/services/mediums-services/mediums.service';
import { Tags } from 'src/app/services/tags-service/tags';
import { TagsService } from 'src/app/services/tags-service/tags.service';
import { DialogClipGroupComponent } from '../dialog-clip-group/dialog-clip-group.component';
import { DialogComponent } from '../dialog/dialog.component';
@Component({
  selector: 'app-clip',
  templateUrl: './clip.component.html',
  styleUrls: ['./clip.component.css']
})
export class ClipComponent implements OnInit{
  
  public clipList: Clip[];
  public tagsList: Tags[];
  public mediumsList: Mediums[];
  public gridkeywordList: Gridkeywords[];

  brojac: number = 0;
  public searchString: string;
  public searchStringTags: string;
  
  keywords: string = '';
  brief: string = '';
  updatedBrief: string = '';
  mediumTitle!:string;
  selectedMedium!: string;
  mediumID!: number;
  clipID: number;
  clipDateName!: string;
  val = false;
  nextGroupID = 0;
  clipMediumID!: number;
  clipMediumName!: string;
  clips!: Clip;
  mediums!: Mediums;
  tagClip!: string;

  authorList: Authors[];
  editMode = false;
  translateMode = false;
  clipForm: FormGroup;
  keywordForm: FormGroup;
  clipIDForm: number; 
  selectedKeyword: string;
  importantInformations: boolean;
  public modeselect = 245;

  selectedClips = [];
  clipTags: clipTags;
  clipTagsList: clipTags[];
  done = [];
  check: boolean;
  clipTagID: number;
  selectedMainClip: number;
  showGroup = false;
  groupID: number;
  nextGroup = 0; 
  gridkeywords: Gridkeywords;
  keywordList: string[] = [];

  constructor(private gridkeywordService: GridkeywordsService,private mediumService: MediumsService,private tagService: TagsService, private clipService: ClipService, public authService: AuthenticationService, public http: HttpClient,
              private formBuilder: FormBuilder, private datePipe: DatePipe, public dialog: MatDialog, private _snackBar: MatSnackBar,
              private authorService: AuthorsService, private clipTagService: ClipTagsService) { 
                  this.clips = new Clip();
                  this.mediums = new Mediums();
                  this.clipTags = new clipTags();
                  this.gridkeywords = new Gridkeywords();
              }

  ngOnInit(): void {
    this.clipForm = this.formBuilder.group({
      medium_id : ['',Validators.required],
      created_at : ['',Validators.required],
      date_of_clip: ['',Validators.required],
      clip_title: ['', Validators.required],
      clip_title_english: [''],
      clip_text: ['', Validators.required],
      clip_text_english: [''],
      brief: ['',Validators.required],
      brief_english: [''],
      clip_url: ['', Validators.required],
      clip_image_url: [''],
      important_information: ['']
    });
    this.keywordForm = this.formBuilder.group({
      keyword: ['']
    });
    this.getClipTags();
    this.getClip();
    this.getTags();
    this.getMediums();
    this.getGridkeywords();
    this.clipMedium();
    this.getAuthors();
    this.loadKeywords();
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

 selectClip(clipID: number, clipCheckBox: boolean) {
      if (clipCheckBox) {
      this.selectedClips.push(clipID)
      }
      else {
      for (let i = 0; i < this.selectedClips.length; i++) {
        if (this.selectedClips[i] == clipID) {
          this.selectedClips.splice(i, 1);
        }
      }
    }
    console.log(this.selectedClips)
 }
 
 selectMainClip(selectedMainClip: number) {
  this.selectedMainClip = selectedMainClip
  console.log(this.selectedMainClip)
 }

 getNextClipGroup() {
   for (let clip of this.clipList) {
     if (clip.clip_group > this.nextGroup) {
       this.nextGroup = clip.clip_group;
     }
   }
 }

 makeClipGroup() {
  this.getNextClipGroup();
  if(this.selectedClips.length == 0) {
    this.openSnackBar('Немате селектирано клипови за група!','Затвори');
  } 
  else {
  const confirmDialog = this.dialog.open(DialogClipGroupComponent, {
    data: {
      title: 'Направи Група',
      message: 'Изберете носечки клип на групата: ',
    }
  });
  confirmDialog.afterClosed().subscribe(result => {
    if (result === true) {
      for (let clip of this.clipList) {
        if (clip.clip_id == this.selectedMainClip) {
          this.clips.main_clip = true;
          this.clips.clip_group = this.nextGroup + 1;
          this.clipService.updateClip(clip.clip_id, this.clips).subscribe(result => this.getClip())
        }
        if (this.selectedClips.includes(clip.clip_id) && clip.clip_id != this.selectedMainClip) {
          this.clips.main_clip = false;
          this.clips.clip_group = this.nextGroup + 1;
          this.clipService.updateClip(clip.clip_id, this.clips).subscribe(result => this.getClip())
        }
      }
      this.openSnackBar("Успешно направена група!", "Затвори");
      this.selectedClips = [];
    }
  }); 
}
 }

 makeMainClip(clipFromGroupID: number, mainClipID: number) {
  const confirmDialog = this.dialog.open(DialogComponent, {
    data: {
      title: 'Направи носечки клип на група',
      message: 'Дали сте сигурни дека сакате да го направите клипот носечки клип на групата?',
      true: 'Направи носечки клип',
      false: 'Откажи'
    }
  });
  confirmDialog.afterClosed().subscribe(result => {
    if (result === true) {
      this.selectedClips = [];
      this.clips.main_clip = true;
      this.clipService.updateClipGroup(clipFromGroupID, this.clips).subscribe(result => this.getClip());
      this.clips.main_clip = false;
      this.clipService.updateClipGroup(mainClipID, this.clips).subscribe(result => this.getClip()); 
      this.openSnackBar("Клипот е успешно направен носечки клип на групата!", "Затвори");
    }
  });
 }

 removeClipFromGroup(clipID: number) {
  const confirmDialog = this.dialog.open(DialogComponent, {
    data: {
      title: 'Одврзи клип од група',
      message: 'Дали сте сигурни дека сакате да го одврзите клипот од групата?',
      true: 'Одврзи',
      false: 'Откажи'
    }
  });
  confirmDialog.afterClosed().subscribe(result => {
    if (result === true) {
      this.clipService.removeClipFromGroup(clipID, this.clips).subscribe(result => this.getClip());
      this.selectedClips = [];
      this.openSnackBar("Клипот е успешно одврзан!", "Затвори");
    }
  });
 }

 removeTagFromClip(tagID: number) {
    this.clipTagService.deleteClipTag(tagID).subscribe(result => this.getClipTags());
 }

 public getClipTags(): void {
  this.clipTagService.getClipTags().subscribe(
    (response: clipTags[]) => {
      this.clipTagsList = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}

  transformDate(date) {
    var dateToDB = this.datePipe.transform(date, 'dd-MM-yyyy'); 
    return dateToDB;
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
    this.selectedClips = [];
    this.resetForm();
    this.openSnackBar("Клипот е успешно изменет!", "Затвори");
  }

 translateClip(clipID: number) {
  this.clips.clip_title_english = this.clipForm.controls['clip_title_english'].value;
  this.clips.clip_text_english = this.clipForm.controls['clip_text_english'].value;
  this.clips.brief_english = this.clipForm.controls['brief_english'].value;
  this.editClip(clipID);
  this.selectedClips = [];
  this.openSnackBar("Клипот е успешно преведен!", "Затвори");
 }

  loadClip(mediumName: string, createdAt: string, dateOfClip: string, clipTitle: string, clipTitleEnglish: string,
           clipText: string, clipTextEnglish: string, clipBrief: string, clipBriefEnglish: string,
           clipUrl: string, clipImageUrl: string) {
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
  }

  deleteClip(clipID: number) {
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши клип',
        message: 'Дали сте сигурни дека сакате да го избришите клипот?',
        true: 'Избриши',
        false: 'Откажи'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.clipService.deleteClip(clipID).subscribe(result => this.getClip());
        this.resetForm();
        this.selectedClips = [];
        this.openSnackBar("Клипот е успешно избришан!", "Затвори");
      }
    });
   }

   deleteMultipleClips() {
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши селектирани клипови',
        message: 'Дали сте сигурни дека сакате да ги избришите селектираните клипови?',
        true: 'Избриши',
        false: 'Откажи'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        for (let clipID of this.selectedClips) {
          this.clipService.deleteClip(clipID).subscribe(result => this.getClip());
        }
        this.selectedClips = [];
        this.openSnackBar("Селектираните клипови се успешно избришани!", "Затвори");
      }
    });
   }

  resetForm() {
    this.clipForm.reset();
  }

  generateBrief() {
    if (this.clipForm.controls['clip_text'].value.length <= 250)
    this.clipForm.controls['brief'].setValue(this.clipForm.controls['clip_text'].value)
    if (this.clipForm.controls['clip_text'].value.length > 250)
    this.clipForm.controls['brief'].setValue(this.clipForm.controls['clip_text'].value.slice(0,250) + ' ...')
  }

  loadKeywords() {
    this.keywordList = []
    for (let keyword of this.gridkeywordList) {
      this.keywordList.push(keyword.keyword)
    }
  }

  showKeywords() {
    this.loadKeywords();
    this.selectedKeyword = window.getSelection()?.toString();
    if (this.keywordList.includes(this.selectedKeyword)) {}
    else {
    this.gridkeywords.keyword = this.selectedKeyword;
    this.gridkeywordService.addGridkeywords(this.gridkeywords).subscribe(result => this.getGridkeywords(), result => this.loadKeywords());
    }
  }

  removeKeyword(keywordID: number){
    this.gridkeywordService.deleteGridkeyword(keywordID).subscribe(result => this.getGridkeywords());
  }

  removeTag(event: CdkDragDrop<string[]>) {
    this.done.splice(event.previousIndex, 1)
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
 

  clipMedium() {
    for (var clip of this.clipList) {
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

  searchKeyword(text: string, words: string) {
    if (text == '') {
      this.keywords = '';
    } else {
      for (var keyword of this.gridkeywordList) {
        if (!words.toLocaleLowerCase().includes(keyword.keyword.toLocaleLowerCase())) {
          if (text.toLocaleLowerCase().includes(keyword.keyword.toLocaleLowerCase())) {
            this.keywords += " " + keyword.keyword + " ";
          }
        }
      }
    }
  }

  

  searchMedium() {
    if (this.mediumTitle = "") {
      this.ngOnInit();
    }
    this.mediumsList = this.mediumsList.filter(res => {
      return res.medium_name_cyrilic.toLocaleLowerCase().match(this.mediumTitle.toLocaleLowerCase());
    })
  }

  selectChangeHandler (event: any) {
    this.selectedMedium = event.target.value;
    console.log(this.selectedMedium)
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

  public getAuthors(): void {
    this.authorService.getAuthors().subscribe(
      (response: Authors[]) => {
        this.authorList = response;
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


draggable = {
  data: "myDragData",
  effectAllowed: "all",
  disable: false,
  handle: false
};

onDragEnd(event:DragEvent) { }

onDraggableCopied(event:DragEvent, tagID: number) {
    var checkExistingTag = false;
    for (let clipTags of this.clipTagsList) {
      if (clipTags.tag_id == tagID && clipTags.clip_id == this.clipTagID) {
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
    }
}
  
onDraggableMoved(event:DragEvent) {}
    
onDragCanceled(event:DragEvent) {}

onDrop(event:DndDropEvent,  clipID: number) {
  this.clipTagID = clipID;
}



}
