import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5percent from "@amcharts/amcharts5/percent";
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
//import am4themes_https://cdn.amcharts.com/lib/5/Animated from "@amcharts/amcharts4/themes/https://cdn.amcharts.com/lib/5/Animated";

@Component({
  selector: 'app-info-po-tag-pie',
  templateUrl: './info-po-tag-pie.component.html',
  styleUrls: ['./info-po-tag-pie.component.css']
})
export class InfoPoTagPieComponent {

 /*private root: am5.Root;


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
      let root = am5.Root.new("chartdiv2");

      root.setThemes([am5themes_Animated.new(root)]);


      // Create chart
      // https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
      let chart = root.container.children.push(am5percent.PieChart.new(root, {
        layout: root.verticalLayout
      }));


      // Create series
      // https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
      let series = chart.series.push(am5percent.PieSeries.new(root, {
        alignLabels: true,
        calculateAggregates: true,
        valueField: "value",
        categoryField: "category"
      }));

      series.slices.template.setAll({
        strokeWidth: 3,
        stroke: am5.color(0xffffff)
      });

      series.labelsContainer.set("paddingTop", 30)


      // Set up adapters for variable slice radius
      // https://www.amcharts.com/docs/v5/concepts/settings/adapters/
      series.slices.template.adapters.add("radius", function (radius, target) {
        let dataItem = target.dataItem;
        let high = series.getPrivate("valueHigh");

        if (dataItem) {
          let value = target.dataItem.get("valueWorking", 0);
          return radius * Number(value) / high
        }
        return radius;
      });


      // Set data
      // https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
      series.data.setAll([{
        value: 10,
        category: "One"
      }, {
        value: 9,
        category: "Two"
      }, {
        value: 6,
        category: "Three"
      }, {
        value: 5,
        category: "Four"
      }, {
        value: 4,
        category: "Five"
      }, {
        value: 3,
        category: "Six"
      }]);


      // Create legend
      // https://www.amcharts.com/docs/v5/charts/percent-charts/legend-percent-series/
      let legend = chart.children.push(am5.Legend.new(root, {
        centerX: am5.p50,
        x: am5.p50,
        marginTop: 15,
        marginBottom: 15
      }));

      legend.data.setAll(series.dataItems);


      // Play initial series animation
      // https://www.amcharts.com/docs/v5/concepts/animations/#Animation_of_series
      series.appear(1000, 100);



    });
  }*/
}