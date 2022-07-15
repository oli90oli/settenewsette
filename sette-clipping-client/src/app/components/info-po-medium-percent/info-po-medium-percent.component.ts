import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5percent from "@amcharts/amcharts5/percent";
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ChartsModelMedium } from 'src/app/services/charts/charts-model-medium';
import { ChartsModelMediumService } from 'src/app/services/charts/charts-model-medium.service';


@Component({
  selector: 'app-info-po-medium-percent',
  templateUrl: './info-po-medium-percent.component.html',
  styleUrls: ['./info-po-medium-percent.component.css']
})
export class InfoPoMediumPercentComponent implements OnInit {
  public chartModelMediumsList: ChartsModelMedium[];
  chartm: ChartsModelMedium;
  
  medium_name_cyrilic: string;
  num_of_mediums: number;

  private root: am5.Root;
  private value: number;

  data = [];

  constructor(@Inject(PLATFORM_ID) private platformId, private zone: NgZone,
  private chartsModelMediumService: ChartsModelMediumService, public http: HttpClient) {
  this.chartm=new ChartsModelMedium();
  }


  ngOnInit(): any {
    this.returnClipsByMedium()
    .subscribe( data=>this.determineAvailableMediumsByDate(data) );
  }

  public returnClipsByMedium(): any {
    console.log('in returnClipsByMedium');
    this.chartsModelMediumService.return_clips_by_medium().subscribe(
      (response: ChartsModelMedium[]) => {
        this.chartModelMediumsList = response;
        console.log(this.chartModelMediumsList);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
    
  determineAvailableMediumsByDate( chartModelMediumsList: ChartsModelMedium[]) {
    this.chartModelMediumsList = chartModelMediumsList;

    if (!this.chartModelMediumsList ) {
      console.log("Failed to get ClipsByMediums");
    } else {
      console.log( this.chartModelMediumsList.length + " ClipsByMediumsfound ");
    }

  }

  // Run the function only in the browser
  browserOnly(f: () => void) {
    if (isPlatformBrowser(this.platformId)) {
      this.zone.runOutsideAngular(() => {
        f();
      });
    }
  }

  ngAfterViewInit() {
    // Chart code goes in here
    this.browserOnly(() => {
      let root = am5.Root.new("chartdiv2");

      root.setThemes([am5themes_Animated.new(root)]);

      // Create chart
      // https://www.amcharts.com/docs/v5/charts/percent-charts/sliced-chart/
      let chart = root.container.children.push(
        am5percent.SlicedChart.new(root, {
          layout: root.verticalLayout
        })
      );

      // Create series
      // https://www.amcharts.com/docs/v5/charts/percent-charts/sliced-chart/#Series
      let series = chart.series.push(
        am5percent.FunnelSeries.new(root, {
          alignLabels: false,
          orientation: "horizontal",
          valueField: "value",
          categoryField: "category",
          bottomRatio: 1
        })
      );

      // Set data
      // https://www.amcharts.com/docs/v5/charts/percent-charts/sliced-chart/#Setting_data
      //   series.data.setAll([
      //   { value: 10, category: "One" },
      //   { value: 9, category: "Two" },
      //   { value: 6, category: "Three" },
      //   { value: 5, category: "Four" },
      //   { value: 4, category: "Five" },
      //   { value: 3, category: "Six" },
      //   { value: 1, category: "Seven" }
      // ]);

      // https://www.amcharts.com/docs/v5/charts/percent-charts/sliced-chart/#Setting_data
      
      this.chartModelMediumsList.forEach(element => {
       this.data.push({  value: element.num_of_mediums, category: element.medium_name_cyrilic });
      });
  
      series.data.setAll(this.data);

     /* this.mediumsList.forEach(element => {
        // console.log(element);
        this.data.push({ value: 10, category: element.medium_name_cyrilic });

      });*/

      // Play initial series animation
      // https://www.amcharts.com/docs/v5/concepts/animations/#Animation_of_series
      series.appear();

      // Create legend
      // https://www.amcharts.com/docs/v5/charts/percent-charts/legend-percent-series/
      let legend = chart.children.push(
        am5.Legend.new(root, {
          centerX: am5.p50,
          x: am5.p50,
          marginTop: 15,
          marginBottom: 15
        })
      );

      legend.data.setAll(series.dataItems);

      // Make stuff animate on load
      // https://www.amcharts.com/docs/v5/concepts/animations/
      chart.appear(1000, 100);

    });
  }
}
