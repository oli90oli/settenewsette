import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import {APP_BASE_HREF} from '@angular/common';


import { AppComponent } from './app.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { ClientsService } from './services/clients-service/clients.service';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { LeftSidebarComponent } from './components/left-sidebar/left-sidebar.component';
import { HomeComponent } from './components/home/home.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FooterComponent } from './components/footer/footer.component';
import { InfoPoTagComponent } from './components/info-po-tag/info-po-tag.component';
import { InfoPoTagPieComponent } from './components/info-po-tag-pie/info-po-tag-pie.component';
import { InfoTagMediumComponent } from './components/info-tag-medium/info-tag-medium.component';
import { InfoPoMediumComponent } from './components/info-po-medium/info-po-medium.component';
import { InfoPoDenMediumComponent } from './components/info-po-den-medium/info-po-den-medium.component';
import { InfoPoMediumPercentComponent } from './components/info-po-medium-percent/info-po-medium-percent.component';
import { InfoPoDenTagComponent } from './components/info-po-den-tag/info-po-den-tag.component';
import { OcenetiVestiPodelbaComponent } from './components/oceneti-vesti-podelba/oceneti-vesti-podelba.component';
import { OcenetiVestiProcentiComponent } from './components/oceneti-vesti-procenti/oceneti-vesti-procenti.component';
import { InfoPoAvtorComponent } from './components/info-po-avtor/info-po-avtor.component';
import { WordCloudComponent } from './components/word-cloud/word-cloud.component';
import { BrojNaInfoComponent } from './components/broj-na-info/broj-na-info.component';
import { PartitionedBarChartComponent } from './components/partitioned-bar-chart/partitioned-bar-chart.component';
import { RadarTimelineComponent } from './components/radar-timeline/radar-timeline.component';
import { VestiPoOcenkaComponent } from './components/vesti-po-ocenka/vesti-po-ocenka.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    HeaderComponent,
    LeftSidebarComponent,
    HomeComponent,
    SidebarComponent,
    FooterComponent,
    InfoPoTagComponent,
    InfoPoTagPieComponent,
    InfoTagMediumComponent,
    InfoPoMediumComponent,
    InfoPoDenMediumComponent,
    InfoPoMediumPercentComponent,
    InfoPoDenTagComponent,
    OcenetiVestiPodelbaComponent,
    OcenetiVestiProcentiComponent,
    InfoPoAvtorComponent,
    WordCloudComponent,
    BrojNaInfoComponent,
    PartitionedBarChartComponent,
    RadarTimelineComponent,
    VestiPoOcenkaComponent,
  
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ],
  providers: [ClientsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
