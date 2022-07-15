import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ChartsModelMedium } from 'src/app/services/charts/charts-model-medium';
import { ChartsModelMediumService } from 'src/app/services/charts/charts-model-medium.service';

@Component({
  selector: 'app-info-po-medium',
  templateUrl: './info-po-medium.component.html',
  styleUrls: ['./info-po-medium.component.css']
})
export class InfoPoMediumComponent implements OnInit {
  public chartModelMediumsList: ChartsModelMedium[];
  chartm: ChartsModelMedium;

  medium_name_cyrilic: string;
  num_of_mediums: number;

  private root: am5.Root;
  private value: number;

  data = [];

  constructor(@Inject(PLATFORM_ID) private platformId, private zone: NgZone,
    private chartsModelMediumService: ChartsModelMediumService, public http: HttpClient) {
    this.chartm = new ChartsModelMedium();
  }

  ngOnInit(): void {
    this.returnClipsByMedium();
  }

  public returnClipsByMedium(): void {
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
          panX: false,
          panY: false,
          wheelX: "none",
          wheelY: "none"
        })
      );


      // Create axes
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let yRenderer = am5xy.AxisRendererY.new(root, { minGridDistance: 30 });

      let yAxis = chart.yAxes.push(
        am5xy.CategoryAxis.new(root, {
          maxDeviation: 0,
          categoryField: "medium",
          renderer: yRenderer
        })
      );

      let xAxis = chart.xAxes.push(
        am5xy.ValueAxis.new(root, {
          maxDeviation: 0,
          min: 0,
          renderer: am5xy.AxisRendererX.new(root, {})
        })
      );


      // Create series
      // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
      let series = chart.series.push(
        am5xy.ColumnSeries.new(root, {
          name: "Series 1",
          xAxis: xAxis,
          yAxis: yAxis,
          valueXField: "value",
          sequencedInterpolation: true,
          categoryYField: "medium"
        })
      );

      let columnTemplate = series.columns.template;

      columnTemplate.setAll({
        draggable: true,
        cursorOverStyle: "pointer",
        tooltipText: "drag to rearrange",
        cornerRadiusBR: 10,
        cornerRadiusTR: 10
      });
      columnTemplate.adapters.add("fill", (fill, target) => {
        return chart.get("colors").getIndex(series.columns.indexOf(target));
      });

      columnTemplate.adapters.add("stroke", (stroke, target) => {
        return chart.get("colors").getIndex(series.columns.indexOf(target));
      });

      columnTemplate.events.on("dragstop", () => {
        sortCategoryAxis();
      });

      // Get series item by category
      function getSeriesItem(category) {
        for (var i = 0; i < series.dataItems.length; i++) {
          let dataItem = series.dataItems[i];
          if (dataItem.get("categoryY") == category) {
            return dataItem;
          }
        }
      }


      // Axis sorting
      function sortCategoryAxis() {
        // Sort by value
        series.dataItems.sort(function (x, y) {
          return y.get("graphics").y() - x.get("graphics").y();
        });

        let easing = am5.ease.out(am5.ease.cubic);

        // Go through each axis item
        am5.array.each(yAxis.dataItems, function (dataItem) {
          // get corresponding series item
          let seriesDataItem = getSeriesItem(dataItem.get("category"));

          if (seriesDataItem) {
            // get index of series data item
            let index = series.dataItems.indexOf(seriesDataItem);

            let column = seriesDataItem.get("graphics");

            // position after sorting
            let fy =
              yRenderer.positionToCoordinate(yAxis.indexToPosition(index)) -
              column.height() / 2;

            // set index to be the same as series data item index
            if (index != dataItem.get("index")) {
              dataItem.set("index", index);

              // current position
              let x = column.x();
              let y = column.y();

              column.set("dy", -(fy - y));
              column.set("dx", x);

              column.animate({ key: "dy", to: 0, duration: 600, easing: easing });
              column.animate({ key: "dx", to: 0, duration: 600, easing: easing });
            } else {
              column.animate({ key: "y", to: fy, duration: 600, easing: easing });
              column.animate({ key: "x", to: 0, duration: 600, easing: easing });
            }
          }
        });

        // Sort axis items by index.
        // This changes the order instantly, but as dx and dy is set and animated,
        // they keep in the same places and then animate to true positions.
        yAxis.dataItems.sort(function (x, y) {
          return x.get("index") - y.get("index");
        });
      }

      // Set data
      /* this.data = [{
         country: "USA",
         value: 2025
       }, {
         country: "China",
         value: 1882
       }, {
         country: "Japan",
         value: 1809
       }, {
         country: "Germany",
         value: 1322
       }, {
         country: "UK",
         value: 1122
       }];*/
      //let data1=[];

      this.chartModelMediumsList.forEach(element => {
        // console.log(element);
        // this.data.push({ medium: element.medium_name_cyrilic, value: element.medium_id });
        this.data.push({ medium: element.medium_name_cyrilic, value: element.num_of_mediums });

      });
      //console.log(data1);
      yAxis.data.setAll(this.data);
      series.data.setAll(this.data);


      // Make stuff animate on load
      // https://www.amcharts.com/docs/v5/concepts/animations/
      series.appear(1000);
      chart.appear(1000, 100);
    });
  }
}
