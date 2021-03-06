import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import * as am5percent from "@amcharts/amcharts5/percent";
import * as am5stock from "@amcharts/amcharts5/stock";
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';

@Component({
  selector: 'app-info-po-den-medium',
  templateUrl: './info-po-den-medium.component.html',
  styleUrls: ['./info-po-den-medium.component.css']
})
export class InfoPoDenMediumComponent {
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
      let root = am5.Root.new("chartdiv1");

      root.setThemes([am5themes_Animated.new(root)]);

      // Create a stock chart
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock-chart/#Instantiating_the_chart
      let stockChart = root.container.children.push(am5stock.StockChart.new(root, {
      }));


      // Set global number format
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/concepts/formatters/formatting-numbers/
      root.numberFormatter.set("numberFormat", "#,###.00");


      // Create a main stock panel (chart)
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock-chart/#Adding_panels
      let mainPanel = stockChart.panels.push(am5stock.StockPanel.new(root, {
        wheelY: "zoomX",
        panX: true,
        panY: true
      }));


      // Create value axis
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let valueAxis = mainPanel.yAxes.push(am5xy.ValueAxis.new(root, {
        renderer: am5xy.AxisRendererY.new(root, {
          pan: "zoom"
        }),
        extraMin: 0.1, // adds some space for for main series
        tooltip: am5.Tooltip.new(root, {}),
        numberFormat: "#,###.00",
        extraTooltipPrecision: 2
      }));

      let dateAxis = mainPanel.xAxes.push(am5xy.GaplessDateAxis.new(root, {
        baseInterval: {
          timeUnit: "day",
          count: 1
        },
        renderer: am5xy.AxisRendererX.new(root, {}),
        tooltip: am5.Tooltip.new(root, {})
      }));


      // Add series
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
      let valueSeries = mainPanel.series.push(am5xy.CandlestickSeries.new(root, {
        name: "MSFT",
        clustered: false,
        valueXField: "Date",
        valueYField: "Close",
        highValueYField: "High",
        lowValueYField: "Low",
        openValueYField: "Open",
        calculateAggregates: true,
        xAxis: dateAxis,
        yAxis: valueAxis,
        legendValueText: "open: [bold]{openValueY}[/] high: [bold]{highValueY}[/] low: [bold]{lowValueY}[/] close: [bold]{valueY}[/]",
        legendRangeValueText: ""
      }));


      // Set main value series
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock-chart/#Setting_main_series
      stockChart.set("stockSeries", valueSeries);


      // Add a stock legend
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock-chart/stock-legend/
      let valueLegend = mainPanel.plotContainer.children.push(am5stock.StockLegend.new(root, {
        stockChart: stockChart
      }));


      // Create volume axis
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let volumeAxisRenderer = am5xy.AxisRendererY.new(root, {
        inside: true
      });

      volumeAxisRenderer.labels.template.set("forceHidden", true);
      volumeAxisRenderer.grid.template.set("forceHidden", true);

      let volumeValueAxis = mainPanel.yAxes.push(am5xy.ValueAxis.new(root, {
        numberFormat: "#.#a",
        height: am5.percent(20),
        y: am5.percent(100),
        centerY: am5.percent(100),
        renderer: volumeAxisRenderer
      }));

      // Add series
      // https://www.amcharts.com/docs/v5/charts/xy-chart/series/
      let volumeSeries = mainPanel.series.push(am5xy.ColumnSeries.new(root, {
        name: "Volume",
        clustered: false,
        valueXField: "Date",
        valueYField: "Volume",
        xAxis: dateAxis,
        yAxis: volumeValueAxis,
        legendValueText: "[bold]{valueY.formatNumber('#,###.0a')}[/]"
      }));

      volumeSeries.columns.template.setAll({
        strokeOpacity: 0,
        fillOpacity: 0.5
      });

      // color columns by stock rules
      volumeSeries.columns.template.adapters.add("fill", function (fill, target) {
        let dataItem = target.dataItem;
        if (dataItem) {
          return stockChart.getVolumeColor(dataItem);
        }
        return fill;
      })


      // Set main series
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock-chart/#Setting_main_series
      stockChart.set("volumeSeries", volumeSeries);
      valueLegend.data.setAll([valueSeries, volumeSeries]);


      // Add cursor(s)
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
      mainPanel.set("cursor", am5xy.XYCursor.new(root, {
        yAxis: valueAxis,
        xAxis: dateAxis,
        snapToSeries: [valueSeries],
        snapToSeriesBy: "y!"
      }));


      // Add scrollbar
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
      let scrollbar = mainPanel.set("scrollbarX", am5xy.XYChartScrollbar.new(root, {
        orientation: "horizontal",
        height: 50
      }));
      stockChart.toolsContainer.children.push(scrollbar);

      let sbDateAxis = scrollbar.chart.xAxes.push(am5xy.GaplessDateAxis.new(root, {
        baseInterval: {
          timeUnit: "day",
          count: 1
        },
        renderer: am5xy.AxisRendererX.new(root, {})
      }));

      let sbValueAxis = scrollbar.chart.yAxes.push(am5xy.ValueAxis.new(root, {
        renderer: am5xy.AxisRendererY.new(root, {})
      }));

      let sbSeries = scrollbar.chart.series.push(am5xy.LineSeries.new(root, {
        valueYField: "Close",
        valueXField: "Date",
        xAxis: sbDateAxis,
        yAxis: sbValueAxis
      }));

      sbSeries.fills.template.setAll({
        visible: true,
        fillOpacity: 0.3
      });


      // Function that dynamically loads data
      function loadData(ticker, series, granularity) {

        // Load external data
        // https://www.amcharts.com/docs/v5/charts/xy-chart/series/#Setting_data
        am5.net.load("https://www.amcharts.com/wp-content/uploads/assets/docs/stock/" + ticker + "_" + granularity + ".csv").then(function (result) {

          // Parse loaded data
          let data = am5.CSVParser.parse(result.response, {
            delimiter: ",",
            skipEmpty: true,
            useColumnNames: true
          });

          // Process data (convert dates and values)
          let processor = am5.DataProcessor.new(root, {
            dateFields: ["Date"],
            dateFormat: "yyyy-MM-dd",
            numericFields: ["Open", "High", "Low", "Close", "Adj Close", "Volume"]
          });
          processor.processMany(data);

          // Set data
          am5.array.each(series, function (item) {
            //item.data.setAll(data);
            series.data.setAll(data);
          });
        });
      }

      // Load initial data for the first series
      let currentGranularity = "day";
      loadData("MSFT", [valueSeries, volumeSeries, sbSeries], currentGranularity);

      // Add comparing series
      addComparingSeries("AAPL");


      // Set up comparison control
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock/toolbar/comparison-control/
      let comparisonControl = am5stock.ComparisonControl.new(root, {
        stockChart: stockChart,
        searchable: true,
        searchCallback: function (query) {
          return getTicker(query);
        }
      });

      comparisonControl.events.on("selected", function (ev) {
        //addComparingSeries(ev.item.subLabel);
      });

      function addComparingSeries(label) {
        let series = am5xy.LineSeries.new(root, {
          name: label,
          valueYField: "Close",
          calculateAggregates: true,
          valueXField: "Date",
          xAxis: dateAxis,
          yAxis: valueAxis,
          legendValueText: "{valueY.formatNumber('#.00')}"
        });
        let comparingSeries = stockChart.addComparingSeries(series);
        loadData(label, [comparingSeries], currentGranularity);
      }

      function getTicker(search) {
        search = search.toLowerCase();
        let tickers = [
          { label: "Apple", subLabel: "AAPL", id: "AAPL" },
          { label: "Advanced Micro Devices", subLabel: "AMD", id: "AMD" },
          { label: "Microsoft", subLabel: "MSFT", id: "MSFT" },
          { label: "Alphabet (Google)", subLabel: "GOOG", id: "GOOG" },
          { label: "Amazon", subLabel: "AMZN", id: "AMZN" },
          { label: "Tesla", subLabel: "TSLA", id: "TSLA" },
          { label: "NVIDIA", subLabel: "NVDA", id: "NVDA" },
          { label: "Netflix", subLabel: "NFLX", id: "NFLX" }
        ];

        return tickers.filter(function (item) {
          return item.label.toLowerCase().match(search) || item.subLabel.toLowerCase().match(search);
        });
      }


      // Set up series type switcher
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock/toolbar/series-type-control/
      let seriesSwitcher = am5stock.SeriesTypeControl.new(root, {
        stockChart: stockChart
      });

      seriesSwitcher.events.on("selected", function (ev) {
        setSeriesType(ev.item);
      });

      function getNewSettings(series) {
        let newSettings = [];
        am5.array.each(["name", "valueYField", "highValueYField", "lowValueYField", "openValueYField", "calculateAggregates", "valueXField", "xAxis", "yAxis", "legendValueText", "stroke", "fill"], function (setting) {
          newSettings[setting] = series.get(setting);
        });
        return newSettings;
      }

      function setSeriesType(seriesType) {
        // Get current series and its settings
        let currentSeries = stockChart.get("stockSeries");
        let newSettings = getNewSettings(currentSeries);

        // Remove previous series
        let data = currentSeries.data.values;
        mainPanel.series.removeValue(currentSeries);

        // Create new series
        let series;
        switch (seriesType) {
          case "line":
            series = mainPanel.series.push(am5xy.LineSeries.new(root, newSettings));
            break;
          case "candlestick":
          case "procandlestick":
            //newSettings.clustered = false;
            series = mainPanel.series.push(am5xy.CandlestickSeries.new(root, newSettings));
            if (seriesType == "procandlestick") {
              series.columns.template.get("themeTags").push("pro");
            }
            break;
          case "ohlc":
            //newSettings.clustered = false;
            series = mainPanel.series.push(am5xy.OHLCSeries.new(root, newSettings));
            break;
        }

        // Set new series as stockSeries
        if (series) {
          valueLegend.data.removeValue(currentSeries);
          series.data.setAll(data);
          stockChart.set("stockSeries", series);
          let cursor = mainPanel.get("cursor");
          if (cursor) {
            cursor.set("snapToSeries", [series]);
          }
          valueLegend.data.insertIndex(0, series);
        }
      }


      // Stock toolbar
      // -------------------------------------------------------------------------------
      // https://www.amcharts.com/docs/v5/charts/stock/toolbar/
      let toolbar = am5stock.StockToolbar.new(root, {
        container: document.getElementById("chartcontrols"),
        stockChart: stockChart,
        controls: [
          comparisonControl,
          am5stock.IndicatorControl.new(root, {
            stockChart: stockChart,
            legend: valueLegend
          }),
          am5stock.DateRangeSelector.new(root, {
            stockChart: stockChart
          }),
          am5stock.PeriodSelector.new(root, {
            stockChart: stockChart
          }),
          seriesSwitcher,
          am5stock.DrawingControl.new(root, {
            stockChart: stockChart
          }),
          am5stock.ResetControl.new(root, {
            stockChart: stockChart
          }),
          am5stock.SettingsControl.new(root, {
            stockChart: stockChart
          })
        ]
      })
    });
  }
}
