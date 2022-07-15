import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Authors } from 'src/app/services/authors-service/authors';
import { AuthorsService } from 'src/app/services/authors-service/authors.service';
import { Clip } from 'src/app/services/clip-service/clip';
import { ClipService } from 'src/app/services/clip-service/clip.service';
import { Gridkeywords } from 'src/app/services/gridkeywords-services/gridkeywords';
import { GridkeywordsService } from 'src/app/services/gridkeywords-services/gridkeywords.service';
import { Mediums } from 'src/app/services/mediums-services/mediums';
import { MediumsService } from 'src/app/services/mediums-services/mediums.service';
import { Tags } from 'src/app/services/tags-service/tags';
import { TagsService } from 'src/app/services/tags-service/tags.service';

@Component({
  selector: 'app-add-clip-tv-radio',
  templateUrl: './add-clip-tv-radio.component.html',
  styleUrls: ['./add-clip-tv-radio.component.css']
})
export class AddClipTvRadioComponent implements OnInit {
  public clipList!: Clip[];
  public tagsList!: Tags[];
  public mediumsList!: Mediums[];
  public authorsList: Authors[];
  public gridkeywordList!: Gridkeywords[];
  selectedKeyword: any = '';
  keywords: string = '';
  title: string;
  mediumTitle: string;
  authorTitle: string;
  selectedMedium!: string;
  mediumID: number;
  clips: Clip;
  mediums: Mediums;
  authors: Authors;

  constructor(private gridkeywordService: GridkeywordsService,private mediumService: MediumsService,private authorService: AuthorsService, private tagService: TagsService, private clipService: ClipService) { }

  ngOnInit(): void {
    this.getClip();
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


  onSubmit() {
    for (var medium of this.mediumsList) {
      if (this.selectedMedium == medium.medium_name_cyrilic) {
        this.mediumID = medium.medium_id;
        this.clips.medium_id = this.mediumID;
        this.clipService.addClip(this.clips).subscribe(result => this.getClip());
      }
    }
  }


}
