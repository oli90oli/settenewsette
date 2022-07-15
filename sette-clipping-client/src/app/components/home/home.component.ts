import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  clientID = Number(sessionStorage.getItem('clientID'));

  constructor() { }

  ngOnInit(): void {
    console.log(this.clientID)
  }

}
