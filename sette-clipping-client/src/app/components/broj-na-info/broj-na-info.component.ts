import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ChartsModelClipsByDate } from 'src/app/services/charts/charts-model-clips-by-date';
import { ChartsModelClipsByDateService } from 'src/app/services/charts/charts-model-clips-by-date.service';
import { List } from '@amcharts/amcharts5/.internal/core/util/List';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-broj-na-info',
  templateUrl: './broj-na-info.component.html',
  styleUrls: ['./broj-na-info.component.css']
})
export class BrojNaInfoComponent implements OnInit {
  //public static chartModelClipsByDateList: Array<ChartsModelClipsByDate> = new Array();

  public chartModelClipsByDateList: ChartsModelClipsByDate[];
  chartd: ChartsModelClipsByDate;

  date_of_clip: string;
  clips_per_date: number;

  private root: am5.Root;
  private value: number;

  data = [];
  myData = [];
  constructor(@Inject(PLATFORM_ID) private platformId, private zone: NgZone,
    private chartsModelClipsByDateService: ChartsModelClipsByDateService, public http: HttpClient) {
    this.chartd = new ChartsModelClipsByDate();
  }

  ngOnInit(): any {
   // this.returnClipsByDate();
    this.returnClipsByDate( )
      .subscribe( data=>this.determineAvailableClipsByDate(data) );
    //   this.chartsModelClipsByDateService.getClipsByDate().subscribe(items => {
    //     this.chartModelClipsByDateList = items['content'];
    //   }); 
    //this.setClipsByDateElements(this.chartModelClipsByDateList);
  }

  

  public returnClipsByDate(): any {
    this.chartsModelClipsByDateService.getClipsByDate().subscribe(
      (response: ChartsModelClipsByDate[]) => {
        this.chartModelClipsByDateList = response;
        //this.myData = response;
        console.log('in returnClipsByDate');
        console.log(this.chartModelClipsByDateList);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  determineAvailableClipsByDate( chartModelClipsByDateList: ChartsModelClipsByDate[]) {
    this.chartModelClipsByDateList = chartModelClipsByDateList;

    if (!this.chartModelClipsByDateList ) {
      console.log("Failed to get ClipsByDate");
    } else {
      console.log( this.chartModelClipsByDateList.length + " ClipsByDate found ");
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
      let root = am5.Root.new("chartdiv");

      root.setThemes([am5themes_Animated.new(root)]);


      // Create chart
      // https://www.amcharts.com/docs/v5/charts/xy-chart/
      let chart = root.container.children.push(am5xy.XYChart.new(root, {
        panX: true,
        panY: true,
        wheelX: "panX",
        wheelY: "zoomX",
        scrollbarX: am5.Scrollbar.new(root, { orientation: "horizontal" }),
        scrollbarY: am5.Scrollbar.new(root, { orientation: "vertical" }),
        pinchZoomX: true
      })
      );

      chart.get("colors").set("step", 3);


      // Add cursor
      // https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
      let cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));
      cursor.lineY.set("visible", false);


      // Create axes
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let xRenderer = am5xy.AxisRendererX.new(root, {
        minGridDistance: 15
      });

      xRenderer.labels.template.setAll({
        rotation: -90,
        centerY: am5.p50,
        centerX: 0
      });

      xRenderer.grid.template.setAll({
        location: 0.5,
        strokeDasharray: [1, 3]
      });

      let xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
        maxDeviation: 0.3,
        categoryField: "category",
        renderer: xRenderer,
        tooltip: am5.Tooltip.new(root, {})
      }));

      let yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
        maxDeviation: 0.3,
        renderer: am5xy.AxisRendererY.new(root, {})
      }));


      // Create series
      // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
      let series = chart.series.push(am5xy.ColumnSeries.new(root, {
        xAxis: xAxis,
        yAxis: yAxis,
        valueYField: "value",
        categoryXField: "category",
        adjustBulletPosition: false,
        tooltip: am5.Tooltip.new(root, {
          labelText: "{valueY}"
        })
      }));
      series.columns.template.setAll({
        width: 0.5
      });

      series.bullets.push(function () {
        return am5.Bullet.new(root, {
          locationY: 1,
          sprite: am5.Circle.new(root, {
            radius: 5,
            fill: series.get("fill")
          })
        })
      })

      // Set data

      //let value = 120;

      // let names = ["Raina",
      //    "Demarcus",
      //    "Carlo",
      //   "Jacinda",
      //   "Richie",
      //    "Antony",
      //    "Amada",
      //    "Idalia",
      //    "Janella",
      //    "Marla",
      //    "Curtis",
      //    "Shellie",
      //    "Meggan",
      //    "Nathanael",
      //    "Jannette",
      //    "Tyrell",
      //    "Sheena",
      //    "Maranda",
      //    "Briana",
      //    "Rosa",
      //    "Rosanne",
      //    "Herman",
      // "Wayne",
      // "Shamika",
      // "Suk",
      // "Clair",
      // "Olivia",
      // "Hans",
      // "Glennie",
      // ];

      // function setClipsByDateElements(chartModelClipsByDateList) {
      //   chartModelClipsByDateList.forEach(element => {
      //     this.data.push({ category: element.date_of_clip, value: element.clips_per_date });
      //     console.log(element);
      //   });
      // }


      this.chartModelClipsByDateList.forEach(element => {
        this.data.push({ category: element.date_of_clip, value: element.clips_per_date });
        console.log(element);
      });


      //this.chartModelClipsByDateList.forEach(element => {
      //console.log(element);
      // this.data.push({ medium: element.medium_name_cyrilic, value: element.medium_id });
      // this.data.push({ medium: element.medium_name_cyrilic, value: element.num_of_mediums });

      //});
      // console.log("Lengt is: "+this.myData.length);
      //     for (var i = 0; i < names.length; i++) {
      //          value += Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 5);
      //          this.data.push({ category: names[i], value: value });
      //        }

      xAxis.data.setAll(this.data);
      series.data.setAll(this.data);


      // Make stuff animate on load
      // https://www.amcharts.com/docs/v5/concepts/animations/
      series.appear(1000);
      chart.appear(1000, 100);

    });
  }
}

