import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import * as am5percent from "@amcharts/amcharts5/percent";
import * as am5stock from "@amcharts/amcharts5/stock";
//import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
//import * as am4core from "@amcharts/amcharts4/core";
//import * as am4charts from "@amcharts/amcharts4/charts";
//import am4themes_animated from "@amcharts/amcharts4/themes/animated";
//import * as am4plugins_timeline from "@amcharts/amcharts4/plugins/timeline";





@Component({
  selector: 'app-info-po-den-tag',
  templateUrl: './info-po-den-tag.component.html',
  styleUrls: ['./info-po-den-tag.component.css']
})
export class InfoPoDenTagComponent {
 /*private root: am5.Root;
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
      let root = am5.Root.new("chartdiv4");

      root.setThemes([am4themes_animated.new(root)]);
    /* Imports 

    private chart: am4charts.XYChart;

    constructor(@Inject(PLATFORM_ID) private platformId, private zone: NgZone) {}
  
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
        am4core.useTheme(am4themes_animated);
  
        let chart = am4core.create("chartdiv", am4charts.XYChart);
  
        chart.paddingRight = 20;
  
        let data = [];
        let visits = 10;
        for (let i = 1; i < 366; i++) {
          visits += Math.round((Math.random() < 0.5 ? 1 : -1) * Math.random() * 10);
          data.push({ date: new Date(2018, 0, i), name: "name" + i, value: visits });
        }
  
        chart.data = data;
  
        let dateAxis = chart.xAxes.push(new am4charts.DateAxis());
        dateAxis.renderer.grid.template.location = 0;
  
        let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
        valueAxis.tooltip.disabled = true;
        valueAxis.renderer.minWidth = 35;
  
        let series = chart.series.push(new am4charts.LineSeries());
        series.dataFields.dateX = "date";
        series.dataFields.valueY = "value";
        series.tooltipText = "{valueY.value}";
  
        chart.cursor = new am4charts.XYCursor();
  
        let scrollbarX = new am4charts.XYChartScrollbar();
        scrollbarX.series.push(series);
        chart.scrollbarX = scrollbarX;
  
        this.chart = chart;
      });
    }
  
    ngOnDestroy() {
      // Clean up chart when the component is removed
      this.browserOnly(() => {
        if (this.chart) {
          this.chart.dispose();
        }
      });
    }
  }
/* Chart code 
// Create root element
// https://www.amcharts.com/docs/v5/getting-started/#Root_element 
let root = am4themes_animated.Root.new("chartdiv4");


// Set themes
// https://www.amcharts.com/docs/v5/concepts/themes/ 
root.setThemes([
  am4themes_animated.new(root)
]);


// Create chart
// https://www.amcharts.com/docs/v5/charts/xy-chart/
let chart = root.container.children.push(am5xy.XYChart.new(root, {
  panX: true,
  panY: true,
  wheelX: "panX",
  wheelY: "zoomX",
  maxTooltipDistance: 0,
  pinchZoomX: true
}));


let date = new Date();
date.setHours(0, 0, 0, 0);
let value = 100;

function generateData() {
  value = Math.round((Math.random() * 10 - 4.2) + value);
  am5.time.add(date, "day", 1);
  return {
    date: date.getTime(),
    value: value
  };
}

function generateDatas(count) {
  let data = [];
  for (var i = 0; i < count; ++i) {
    data.push(generateData());
  }
  return data;
}


// Create axes
// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
let xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
  maxDeviation: 0.2,
  baseInterval: {
    timeUnit: "day",
    count: 1
  },
  renderer: am5xy.AxisRendererX.new(root, {}),
  tooltip: am5.Tooltip.new(root, {})
}));

let yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
  renderer: am5xy.AxisRendererY.new(root, {})
}));


// Add series
// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
for (var i = 0; i < 10; i++) {
  let series = chart.series.push(am5xy.LineSeries.new(root, {
    name: "Series " + i,
    xAxis: xAxis,
    yAxis: yAxis,
    valueYField: "value",
    valueXField: "date",
    legendValueText: "{valueY}",
    tooltip: am5.Tooltip.new(root, {
      pointerOrientation: "horizontal",
      labelText: "{valueY}"
    })
  }));

  date = new Date();
  date.setHours(0, 0, 0, 0);
  value = 0;

  let data = generateDatas(100);
  series.data.setAll(data);

  // Make stuff animate on load
  // https://www.amcharts.com/docs/v5/concepts/animations/
  series.appear();
}


// Add cursor
// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
let cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
  behavior: "none"
}));
cursor.lineY.set("visible", false);


// Add scrollbar
// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
chart.set("scrollbarX", am5.Scrollbar.new(root, {
  orientation: "horizontal"
}));

chart.set("scrollbarY", am5.Scrollbar.new(root, {
  orientation: "vertical"
}));


// Add legend
// https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
let legend = chart.rightAxesContainer.children.push(am5.Legend.new(root, {
  width: 200,
  paddingLeft: 15,
  height: am5.percent(100)
}));

// When legend item container is hovered, dim all the series except the hovered one
legend.itemContainers.template.events.on("pointerover", function (e) {
  let itemContainer = e.target;

  // As series list is data of a legend, dataContext is series
  let series = itemContainer.dataItem.dataContext;

  chart.series.each(function (chartSeries) {
    if (chartSeries != series) {
      chartSeries.strokes.template.setAll({
        strokeOpacity: 0.15,
        stroke: am5.color(0x000000)
      });
    } else {
      chartSeries.strokes.template.setAll({
        strokeWidth: 3
      });
    }
  })
})

// When legend item container is unhovered, make all series as they are
legend.itemContainers.template.events.on("pointerout", function (e) {
  let itemContainer = e.target;
  let series = itemContainer.dataItem.dataContext;

  chart.series.each(function (chartSeries) {
    chartSeries.strokes.template.setAll({
      strokeOpacity: 1,
      strokeWidth: 1,
      stroke: chartSeries.get("fill")
    });
  });
})

legend.itemContainers.template.set("width", am5.p100);
legend.valueLabels.template.setAll({
  width: am5.p100,
  textAlign: "right"
});

// It's is important to set legend data after all the events are set on template, otherwise events won't be copied
legend.data.setAll(chart.series.values);


// Make stuff animate on load
// https://www.amcharts.com/docs/v5/concepts/animations/
chart.appear(1000, 100);

*/
}
