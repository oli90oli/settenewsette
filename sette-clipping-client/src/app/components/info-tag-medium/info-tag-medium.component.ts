import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import * as am5percent from "@amcharts/amcharts5/percent";
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-info-tag-medium',
  templateUrl: './info-tag-medium.component.html',
  styleUrls: ['./info-tag-medium.component.css']
})
export class InfoTagMediumComponent {

  private root: am5.Root;
  private value: number;

  constructor(@Inject(PLATFORM_ID) private platformId, private zone: NgZone) { }

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


      // Create chart
      // https://www.amcharts.com/docs/v5/charts/xy-chart/
      let chart = root.container.children.push(am5xy.XYChart.new(root, {
        panX: false,
        panY: false,
        wheelX: "panX",
        wheelY: "zoomX",
        layout: root.verticalLayout
      }));


      // Add legend
      // https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
      let legend = chart.children.push(am5.Legend.new(root, {
        centerX: am5.p50,
        x: am5.p50
      }));

      let data = [{
        "year": "2021",
        "europe": 2.5,
        "namerica": 2.5,
        "asia": 2.1,
        "lamerica": 1,
        "meast": 0.8,
        "africa": 0.4
      }, {
        "year": "2022",
        "europe": 2.6,
        "namerica": 2.7,
        "asia": 2.2,
        "lamerica": 0.5,
        "meast": 0.4,
        "africa": 0.3
      }, {
        "year": "2023",
        "europe": 2.8,
        "namerica": 2.9,
        "asia": 2.4,
        "lamerica": 0.3,
        "meast": 0.9,
        "africa": 0.5
      }];


      // Create axes
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
        categoryField: "year",
        renderer: am5xy.AxisRendererX.new(root, {
          cellStartLocation: 0.1,
          cellEndLocation: 0.9
        }),
        tooltip: am5.Tooltip.new(root, {})
      }));

      xAxis.data.setAll(data);

      let yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
        min: 0,
        renderer: am5xy.AxisRendererY.new(root, {})
      }));


      // Add series
      // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
      function makeSeries(name, fieldName, stacked) {
        let series = chart.series.push(am5xy.ColumnSeries.new(root, {
          stacked: stacked,
          name: name,
          xAxis: xAxis,
          yAxis: yAxis,
          valueYField: fieldName,
          categoryXField: "year"
        }));

        series.columns.template.setAll({
          tooltipText: "{name}, {categoryX}:{valueY}",
          width: am5.percent(90),
          tooltipY: am5.percent(10)
        });
        series.data.setAll(data);

        // Make stuff animate on load
        // https://www.amcharts.com/docs/v5/concepts/animations/
        series.appear();

        series.bullets.push(function () {
          return am5.Bullet.new(root, {
            locationY: 0.5,
            sprite: am5.Label.new(root, {
              text: "{valueY}",
              fill: root.interfaceColors.get("alternativeText"),
              centerY: am5.percent(50),
              centerX: am5.percent(50),
              populateText: true
            })
          });
        });

        legend.data.push(series);
      }

      makeSeries("Europe", "europe", false);
      makeSeries("North America", "namerica", true);
      makeSeries("Asia", "asia", false);
      makeSeries("Latin America", "lamerica", true);
      makeSeries("Middle East", "meast", true);
      makeSeries("Africa", "africa", true);


      // Make stuff animate on load
      // https://www.amcharts.com/docs/v5/concepts/animations/
      chart.appear(1000, 100);


    });
  }
}
