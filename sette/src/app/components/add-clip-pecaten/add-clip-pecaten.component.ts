import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
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


@Component({
  selector: 'app-add-clip-pecaten',
  templateUrl: './add-clip-pecaten.component.html',
  styleUrls: ['./add-clip-pecaten.component.css']
})

export class AddClipPecatenComponent implements OnInit {

  public clipList!: Clip[];
  public tagsList!: Tags[];
  public mediumsList!: Mediums[];
  public authorsList: Authors[];
  public gridkeywordList!: Gridkeywords[];
  brojac: number = 0;
  selectedKeyword: any = '';
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
  clips: Clip;
  mediums: Mediums;
  authors: Authors;
  constructor(private gridkeywordService: GridkeywordsService, private mediumService: MediumsService,private authorService: AuthorsService, private tagService: TagsService, private clipService: ClipService, public authService: AuthenticationService, public http: HttpClient,
    private route: ActivatedRoute, private router: Router) {
    this.clips = new Clip();
    this.mediums = new Mediums();
    this.authors = new Authors();
  }

  ngOnInit(): void {
    this.getClip();
    this.getTags();
    this.getMediums();
    this.getAuthors();
    this.getGridkeywords();
    this.clipMedium();
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





