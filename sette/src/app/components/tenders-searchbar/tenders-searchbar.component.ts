import { Component, OnInit } from '@angular/core';
import {DateAdapter, MAT_DATE_FORMATS} from '@angular/material/core';
import { AppDateAdapter, APP_DATE_FORMATS } from 'src/app/services/format-datepicker';


@Component({
  selector: 'app-tenders-searchbar',
  templateUrl: './tenders-searchbar.component.html',
  styleUrls: ['./tenders-searchbar.component.css'],
  providers: [
    {provide: DateAdapter, useClass: AppDateAdapter},
    {provide: MAT_DATE_FORMATS, useValue: APP_DATE_FORMATS}
  ]
})
export class TendersSearchbarComponent implements OnInit {
  title: string;
  deptCtrl;
  required;
  datepickerRef1;

  constructor() { }

  ngOnInit(): void {
  }
  filterDates(dateFrom: string, dateTo: string) {
    /*if (dateFrom == "" && dateTo == "") {
      this.getTender();
    } else if (dateFrom == "") {
      this.tenderList = this.clipList.filter(
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
    }*/
  }
  Search() {
   /* if (this.title == "") {
      this.ngOnInit();
    }
    this.clipList = this.clipList.filter(res => {
      return res.clip_title.toLocaleLowerCase().match(this.title.toLocaleLowerCase());
    })*/
  }

}
