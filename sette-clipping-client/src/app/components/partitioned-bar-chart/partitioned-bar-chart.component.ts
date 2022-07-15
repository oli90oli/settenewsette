import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
import { ChartsModelMedium } from 'src/app/services/charts/charts-model-medium';
import { ChartsModelMediumService } from 'src/app/services/charts/charts-model-medium.service';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
//import am4themes_https//cdn.amcharts.com/lib/5/Animated from "@amcharts/amcharts4/themes/https://cdn.amcharts.com/lib/5/Animated";

@Component({
  selector: 'app-partitioned-bar-chart',
  templateUrl: './partitioned-bar-chart.component.html',
  styleUrls: ['./partitioned-bar-chart.component.css']
})
export class PartitionedBarChartComponent {
  public chartModelMediumsList: ChartsModelMedium[];
  chartm: ChartsModelMedium;

  medium_name_cyrilic: string;
  num_of_mediums: number;

  data = [];

  private root: am5.Root;
  private value: number;

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
      let root = am5.Root.new("chartdiv3");

      root.setThemes([am5themes_Animated.new(root)]);

      // Set themes
      // https://www.amcharts.com/docs/v5/concepts/themes/
      root.setThemes([
        am5themes_Animated.new(root)
      ]);


      // Create chart
      // https://www.amcharts.com/docs/v5/charts/xy-chart/
      let chart = root.container.children.push(am5xy.XYChart.new(root, {
        panX: false,
        panY: false,
        wheelX: "none",
        wheelY: "none",
        layout: root.horizontalLayout
      }));


      // Add legend
      // https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
      let legendData = [];
      let legend = chart.children.push(
        am5.Legend.new(root, {
          nameField: "name",
          fillField: "color",
          strokeField: "color",
          //centerY: am5.p50,
          marginLeft: 20,
          y: 20,
          layout: root.verticalLayout,
          clickTarget: "none"
        })
      );

      // let data = [{
      //   region: "Central",
      //   state: "North Dakota",
      //   sales: 920
      // }, {
      //   region: "Central",
      //   state: "South Dakota",
      //   sales: 1317
      // }, {
      //   region: "Central",
      //   state: "Kansas",
      //   sales: 2916
      // }, {
      //   region: "Central",
      //   state: "Iowa",
      //   sales: 4577
      // }, {
      //   region: "Central",
      //   state: "Nebraska",
      //   sales: 7464
      // }, {
      //   region: "Central",
      //   state: "Oklahoma",
      //   sales: 19686
      // }, {
      //   region: "Central",
      //   state: "Missouri",
      //   sales: 22207
      // }, {
      //   region: "Central",
      //   state: "Minnesota",
      //   sales: 29865
      // }, {
      //   region: "Central",
      //   state: "Wisconsin",
      //   sales: 32125
      // }, {
      //   region: "Central",
      //   state: "Indiana",
      //   sales: 53549
      // }, {
      //   region: "Central",
      //   state: "Michigan",
      //   sales: 76281
      // }, {
      //   region: "Central",
      //   state: "Illinois",
      //   sales: 80162
      // }, {
      //   region: "Central",
      //   state: "Texas",
      //   sales: 170187
      // }, {
      //   region: "East",
      //   state: "West Virginia",
      //   sales: 1209
      // }, {
      //   region: "East",
      //   state: "Maine",
      //   sales: 1270
      // }, {
      //   region: "East",
      //   state: "District of Columbia",
      //   sales: 2866
      // }, {
      //   region: "East",
      //   state: "New Hampshire",
      //   sales: 7294
      // }, {
      //   region: "East",
      //   state: "Vermont",
      //   sales: 8929
      // }, {
      //   region: "East",
      //   state: "Connecticut",
      //   sales: 13386
      // }, {
      //   region: "East",
      //   state: "Rhode Island",
      //   sales: 22629
      // }, {
      //   region: "East",
      //   state: "Maryland",
      //   sales: 23707
      // }, {
      //   region: "East",
      //   state: "Delaware",
      //   sales: 27453
      // }, {
      //   region: "East",
      //   state: "Massachusetts",
      //   sales: 28639
      // }, {
      //   region: "East",
      //   state: "New Jersey",
      //   sales: 35763
      // }, {
      //   region: "East",
      //   state: "Ohio",
      //   sales: 78253
      // }, {
      //   region: "East",
      //   state: "Pennsylvania",
      //   sales: 116522
      // }, {
      //   region: "East",
      //   state: "New York",
      //   sales: 310914
      // }, {
      //   region: "South",
      //   state: "South Carolina",
      //   sales: 8483
      // }, {
      //   region: "South",
      //   state: "Louisiana",
      //   sales: 9219
      // }, {
      //   region: "South",
      //   state: "Mississippi",
      //   sales: 10772
      // }, {
      //   region: "South",
      //   state: "Arkansas",
      //   sales: 11678
      // }, {
      //   region: "South",
      //   state: "Alabama",
      //   sales: 19511
      // }, {
      //   region: "South",
      //   state: "Tennessee",
      //   sales: 30662
      // }, {
      //   region: "South",
      //   state: "Kentucky",
      //   sales: 36598
      // }, {
      //   region: "South",
      //   state: "Georgia",
      //   sales: 49103
      // }, {
      //   region: "South",
      //   state: "North Carolina",
      //   sales: 55604
      // }, {
      //   region: "South",
      //   state: "Virginia",
      //   sales: 70641
      // }, {
      //   region: "South",
      //   state: "Florida",
      //   sales: 89479
      // }, {
      //   region: "West",
      //   state: "Wyoming",
      //   sales: 1603
      // }, {
      //   region: "West",
      //   state: "Idaho",
      //   sales: 4380
      // }, {
      //   region: "West",
      //   state: "New Mexico",
      //   sales: 4779
      // }, {
      //   region: "West",
      //   state: "Montana",
      //   sales: 5589
      // }, {
      //   region: "West",
      //   state: "Utah",
      //   sales: 11223
      // }, {
      //   region: "West",
      //   state: "Nevada",
      //   sales: 16729
      // }, {
      //   region: "West",
      //   state: "Oregon",
      //   sales: 17431
      // }, {
      //   region: "West",
      //   state: "Colorado",
      //   sales: 32110
      // }, {
      //   region: "West",
      //   state: "Arizona",
      //   sales: 35283
      // }, {
      //   region: "West",
      //   state: "Washington",
      //   sales: 138656
      // }, {
      //   region: "West",
      //   state: "California",
      //   sales: 457731
      // }];


      this.chartModelMediumsList.forEach(element => {
        // console.log(element);
        // this.data.push({ medium: element.medium_name_cyrilic, value: element.medium_id });
        this.data.push({ region: "medium", state: element.medium_name_cyrilic, sales: element.num_of_mediums });

      });


      // Create axes
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let yAxis = chart.yAxes.push(am5xy.CategoryAxis.new(root, {
        categoryField: "state",
        renderer: am5xy.AxisRendererY.new(root, {
          minGridDistance: 10
        }),
        tooltip: am5.Tooltip.new(root, {})
      }));

      yAxis.get("renderer").labels.template.setAll({
        fontSize: 12,
        location: 0.5
      })

      yAxis.data.setAll(this.data);

      let xAxis = chart.xAxes.push(am5xy.ValueAxis.new(root, {
        renderer: am5xy.AxisRendererX.new(root, {}),
        tooltip: am5.Tooltip.new(root, {})
      }));


      // Add series
      // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
      let series = chart.series.push(am5xy.ColumnSeries.new(root, {
        xAxis: xAxis,
        yAxis: yAxis,
        valueXField: "sales",
        categoryYField: "state",
        tooltip: am5.Tooltip.new(root, {
          pointerOrientation: "horizontal"
        })
      }));

      series.columns.template.setAll({
        tooltipText: "{categoryY}: [bold]{valueX}[/]",
        width: am5.percent(90),
        strokeOpacity: 0
      });

      series.columns.template.adapters.add("fill", function (fill, target) {
        if (target.dataItem) {
          switch (target.dataItem.dataContext) {
            case "Central":
              return chart.get("colors").getIndex(0);
              break;
            case "East":
              return chart.get("colors").getIndex(1);
              break;
            case "South":
              return chart.get("colors").getIndex(2);
              break;
            case "West":
              return chart.get("colors").getIndex(3);
              break;
          }
        }
        return fill;
      })

      series.data.setAll(this.data);

      function createRange(label, category, color) {
        let rangeDataItem = yAxis.makeDataItem({
          category: category
        });

        let range = yAxis.createAxisRange(rangeDataItem);

        rangeDataItem.get("label").setAll({
          fill: color,
          text: label,
          location: 1,
          fontWeight: "bold",
          dx: -130
        });

        rangeDataItem.get("grid").setAll({
          stroke: color,
          strokeOpacity: 1,
          location: 1
        });

        rangeDataItem.get("tick").setAll({
          stroke: color,
          strokeOpacity: 1,
          location: 1,
          visible: true,
          length: 130
        });

        legendData.push({ name: label, color: color });

      }

      createRange("Central", "Texas", chart.get("colors").getIndex(0));
      createRange("East", "New York", chart.get("colors").getIndex(1));
      createRange("South", "Florida", chart.get("colors").getIndex(2));
      createRange("West", "California", chart.get("colors").getIndex(3));

      legend.data.setAll(legendData);

      // Add cursor
      // https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
      let cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
        xAxis: xAxis,
        yAxis: yAxis
      }));


      // Make stuff animate on load
      // https://www.amcharts.com/docs/v5/concepts/animations/
      series.appear();
      chart.appear(1000, 100);
    });
  }
}