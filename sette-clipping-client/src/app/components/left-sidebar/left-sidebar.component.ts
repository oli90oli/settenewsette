import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-left-sidebar',
  templateUrl: './left-sidebar.component.html',
  styleUrls: ['./left-sidebar.component.css']
})
export class LeftSidebarComponent implements OnInit {

  isLatin = sessionStorage.getItem('isLatin');
  viewClips = sessionStorage.getItem('viewClips');
  viewBankruptcies = sessionStorage.getItem('viewBankruptcies');
  viewTenders = sessionStorage.getItem('viewTenders');
  viewNotifications = sessionStorage.getItem('viewNotifications');
  viewAnalytics = sessionStorage.getItem('viewAnalytics');

  constructor() { }

  ngOnInit(): void {
  }

  

}
