import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from 'src/app/services/administrator-login-services/authentication.service';
import { clipTags } from 'src/app/services/clip-tags-service/clip-tags';
import { ClipTagsService } from 'src/app/services/clip-tags-service/clip-tags.service';
import { FunTagService } from 'src/app/services/functions/fun-tag.service';
import { FunTags } from 'src/app/services/functions/fun-tags';
import { Tags } from 'src/app/services/tags-service/tags';
import { TagsService } from 'src/app/services/tags-service/tags.service';
import { TagsCategoriesService } from 'src/app/services/tagsCategoriesService/tags-categories.service';
import { tagsCategories } from 'src/app/services/tagsCategoriesService/tagsCategories';
import { DialogTagsComponent } from '../dialog-tags/dialog-tags.component';
import { DialogComponent } from '../dialog/dialog.component';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {
  public tagsList: Tags[];
  public tagsCategoriesList: tagsCategories[];
  public clipTagsList: clipTags[];
  tags: Tags;
  tagsCategory: tagsCategories;
  funTagsList: FunTags[];

  showCategoryName = false;
  tagCategoryTagId: number;
  tagCategoryTagName: string;
  searchCategoryById: number;
  dropdownListFilterType = 'Contains';
  selectedCategoryFilter: string;
  
  public searchString: string;
  tagForm: FormGroup;
  tagCategoryForm: FormGroup;
  deleteTagCategoryForm: FormGroup;
  tagID: number;
  editMode = false;
  parentTag = true;
  selectedCategory: string;
  selectedCategoryID: string;
  tagName: string;
  parentTagChecked: boolean;
  
  constructor(private tagService: TagsService, public authService: AuthenticationService, public http: HttpClient,
              public tagsCategoriesService: TagsCategoriesService, private clipTagService: ClipTagsService,
              private formBuilder: FormBuilder, private dialog: MatDialog, private _snackBar: MatSnackBar,
              private funTagService: FunTagService) { 
                this.tags = new Tags();
                this.tagsCategory = new tagsCategories();
              }

  ngOnInit(): void {
    this.tagForm = this.formBuilder.group({
      tag_name_c : ['',Validators.required],
      tag_name_l : ['',Validators.required],
      tag_color: ['', Validators.required],
      parent_tag_id: [''],
      tags_category_id: [''],
      parent_tag: ['']
    });
    this.tagCategoryForm = this.formBuilder.group ({
      tags_category_name: ['',Validators.required]
    })
    this.deleteTagCategoryForm = this.formBuilder.group ({
      tags_category_id: ['',Validators.required]
    })
    this.getFunTags(); 
    this.getClipTags();
    this.getTags();
    this.getTagsCategories();
    this.tagCategoryTags();
  }

  openSnackBar(message: string, action: string, ) {
    this._snackBar.open(message, action, {
      duration: 3000,
      panelClass: "sette-dialog"
    });
  }

  checkParentTag() {
    this.tagForm.controls['parent_tag_id'].setValue("")
  }

  addTag(checked: boolean) {
    if(this.tagForm.valid) {
      this.tagForm.controls['parent_tag'].setValue(checked)
      this.tagService.addTags(this.tagForm.value).subscribe(result => this.getFunTags());
      console.log(this.tagForm.value)
      this.resetTagForm();
      this.openSnackBar("Успешно додаден таг!", "Затвори");
    }
  }

  editTag(tagID: number) {
    this.tags.tag_name_c = this.tagForm.controls['tag_name_c'].value;
    this.tags.tag_name_l = this.tagForm.controls['tag_name_l'].value;
    this.tags.tags_category_id = this.tagForm.controls['tags_category_id'].value;
    this.tags.tag_color = this.tagForm.controls['tag_color'].value;
    this.tags.parent_tag = this.tagForm.controls['parent_tag'].value;
    this.tagService.updateTags(this.tags, tagID).subscribe(result => this.getFunTags());
    this.resetTagForm();
    this.openSnackBar('Тагот е успешно изменет!','Затвори');
  }
 
  loadTag(tagNameCyrilic: string, tagNameLatin: string, tagColor: string, parentTag: boolean, parentTagID: string, tagCategoryID: string) {
    this.tagForm.controls['tag_name_c'].setValue(tagNameCyrilic)
    this.tagForm.controls['tag_name_l'].setValue(tagNameLatin)
    this.tagForm.controls['tag_color'].setValue(tagColor)
    this.tagForm.controls['tags_category_id'].setValue(tagCategoryID)
    this.tagForm.controls['parent_tag'].setValue(parentTag)
    this.tagForm.controls['parent_tag_id'].setValue(parentTagID)
    }
 
  deleteTagsCategoryPassword() {
    this.selectedCategoryID = this.deleteTagCategoryForm.controls['tags_category_id'].value;
    for(let tagCategory of this.tagsCategoriesList) {
      if (this.selectedCategoryID == tagCategory.tags_category_id.toString()) {
        this.selectedCategory = tagCategory.tags_category_name;
      }
    }
    const confirmDialog = this.dialog.open(DialogTagsComponent, {
      data: {
        title: 'Избриши Категорија',
        message: 'Внесете лозинка за бришење на категоријата: ' + this.selectedCategory
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === '7110eda4d09e062aa5e4a390b0a572ac0d2c0220') {

        this.tagsCategoriesService.deleteTagsCategories(parseInt(this.selectedCategoryID)).subscribe(result => this.getTagsCategories());
        this.resetTagForm();
        this.openSnackBar("Категоријата е успешно избришана!", "Затвори");
        this.editMode = false;

      }else if (result !== '7110eda4d09e062aa5e4a390b0a572ac0d2c0220' && result){
        this.resetTagForm();
        this.openSnackBar("Погрешна лозинка!", "Затвори");
        this.editMode = false;
      }

    });
  }

  deleteTag(tagID: number, tagName: string) {
   const confirmDialog = this.dialog.open(DialogTagsComponent, {
    data: {
      title: 'Избриши таг',
      message: 'Внесете лозинка за бришење на тагот: ' + tagName
    }
  });
  confirmDialog.afterClosed().subscribe(result => {
    if (result === '7110eda4d09e062aa5e4a390b0a572ac0d2c0220') {
      for (let tagInClip of this.clipTagsList) {
        if (tagInClip.tag_id == tagID) {
          this.clipTagService.deleteClipTag(tagInClip.clip_tag_id).subscribe(result => this.getFunTags());
        }
      }
      this.tagService.deleteTags(tagID).subscribe(result => this.getFunTags());
      this.resetTagForm();
      this.openSnackBar("Тагот е успешно избришан!", "Затвори");
      this.editMode = false;
    } else if (result !== '7110eda4d09e062aa5e4a390b0a572ac0d2c0220' && result){
      this.resetTagForm();
      this.openSnackBar("Погрешна лозинка!", "Затвори");
      this.editMode = false;
    }
  });
  }

  resetTagForm() {
    this.tagForm.reset();
  }

  resetTagCategoryForm() {
    this.tagCategoryForm.reset();
  }

 checkList() {
   console.log(this.tagsCategoriesList)
 }

  addTagCategory() {
    if(this.tagCategoryForm.valid) {
      this.tagsCategoriesService.addTagsCategories(this.tagCategoryForm.value).subscribe(result => this.getTagsCategories());
      this.resetTagCategoryForm();
      this.openSnackBar("Успешно додадена категорија!", "Затвори");
    }
  }

  deleteTagCategory() {
    this.selectedCategoryID = this.deleteTagCategoryForm.controls['tags_category_id'].value;
    for(let tagCategory of this.tagsCategoriesList) {
      if (this.selectedCategoryID == tagCategory.tags_category_id.toString()) {
        this.selectedCategory = tagCategory.tags_category_name;
      }
    }
    const confirmDialog = this.dialog.open(DialogComponent, {
      data: {
        title: 'Избриши категориа',
        message: 'Дали сте сигурни дека сакате да ја избришите категоријата: ' + this.selectedCategory + '?',
        true: 'Избриши',
        false: 'Откажи'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        this.tagsCategoriesService.deleteTagsCategories(parseInt(this.selectedCategoryID)).subscribe(result => this.getTagsCategories());
        this.resetTagForm();
        this.openSnackBar("Категоријата е успешно избришана!", "Затвори");
        this.editMode = false;
      }
    });
  } 

  selectChangeHandler (event: any) {
    this.selectedCategory = event.target.value;
    console.log(this.selectedCategory)
  }

  logOut() {
    this.authService.logOut();
  }

  tagCategoryTags() {
    for(var tag of this.tagsList) {
      this.tagCategoryTagId = tag.tags_category_id;
      for (var tagCategory of this.tagsCategoriesList) {
        if (tagCategory.tags_category_id == this.tagCategoryTagId) {
          this.tagCategoryTagName = tagCategory.tags_category_name;
        }
      }
    }
}

  getTagsCategories() {
    this.tagsCategoriesService.getTagsCategories().subscribe(
      (response: tagsCategories[]) => {
        this.tagsCategoriesList = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  onClick(id: number) {
    this.tagService.deleteTags(id).subscribe(result => this.getFunTags());
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

public getFunTags(): void {
  this.funTagService.fun_tags().subscribe(
    (response: FunTags[]) => {
      this.funTagsList = response;
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
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
}