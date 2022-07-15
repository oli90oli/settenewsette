import { Component, Inject, NgZone, OnInit, PLATFORM_ID } from '@angular/core';
// amCharts imports
import * as am5 from '@amcharts/amcharts5';
import * as am5xy from '@amcharts/amcharts5/xy';
import am5themes_Animated from '@amcharts/amcharts5/themes/Animated';
import { isPlatformBrowser } from '@angular/common';
import { Tags } from 'src/app/services/tag-service/tags';
import { TagsService } from 'src/app/services/tag-service/tags.service';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { tagsCategories } from 'src/app/services/tagsCategoriesService/tagsCategories';
import { TagsCategoriesService } from 'src/app/services/tagsCategoriesService/tags-categories.service';
import { ChartsModelTag } from 'src/app/services/charts/charts-model-tag';
import { ChartsModelTagService } from 'src/app/services/charts/charts-model-tag.service';

@Component({
  selector: 'app-info-po-tag',
  templateUrl: './info-po-tag.component.html',
  styleUrls: ['./info-po-tag.component.css']
})
export class InfoPoTagComponent implements OnInit {
  //https://www.amcharts.com/demos/column-with-rotated-series/
  
  public chartModelTagList: ChartsModelTag[];
  chartt: ChartsModelTag;

  tag_name_c: string;
  num_of_tags: number;

 data = [];

  constructor(@Inject(PLATFORM_ID) private platformId, private zone: NgZone, 
  private chartsModelTagService: ChartsModelTagService, public http: HttpClient) {
    this.chartt=new ChartsModelTag();
    }

  ngOnInit(): any {
    this.returnClipsByTag()
    .subscribe( data=>this.determineAvailableClipsByTags(data) );
  }


  public returnClipsByTag(): any {
    console.log('in returnClipsByTag');
    this.chartsModelTagService.return_clips_by_tag().subscribe(
      (response: ChartsModelTag[]) => {
        this.chartModelTagList = response;
        console.log(this.chartModelTagList);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  } 

  determineAvailableClipsByTags( chartModelTagList: ChartsModelTag[]) {
    this.chartModelTagList = chartModelTagList;

    if (!this.chartModelTagList ) {
      console.log("Failed to get ClipsByTags");
    } else {
      console.log( this.chartModelTagList.length + " ClipsByTagsfound ");
    }

  }

//   public getTags(): void {
//     this.tagService.getTags().subscribe(
//       (response: Tags[]) => {
//         this.tagsList = response;
//       },
//       (error: HttpErrorResponse) => {
//         alert(error.message);
//       }
//     );
//   }

//   getTagsCategories() {
//     this.tagsCategoriesService.getTagsCategories().subscribe(
//       (response: tagsCategories[]) => {
//         this.tagsCategoriesList = response;
//       },
//       (error: HttpErrorResponse) => {
//         alert(error.message);
//       }
//     );
//   }

//   tagCategoryTags() {
//     for(var tag of this.tagsList) {
//       this.tagCategoryTagId = tag.tags_category_id;
//       for (var tagCategory of this.tagsCategoriesList) {
//         if (tagCategory.tags_category_id == this.tagCategoryTagId) {
//           this.tagCategoryTagName = tagCategory.tags_category_name;
//         }
//       }
//     }
// }

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
        pinchZoomX: true
      }));

      // Add cursor
      // https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
      let cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));
      cursor.lineY.set("visible", false);


      // Create axes
      // https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
      let xRenderer = am5xy.AxisRendererX.new(root, { minGridDistance: 30 });
      xRenderer.labels.template.setAll({
        rotation: -90,
        centerY: am5.p50,
        centerX: am5.p100,
        paddingRight: 15
      });

      let xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
        maxDeviation: 0.3,
        categoryField: "tag",
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
        name: "Series 1",
        xAxis: xAxis,
        yAxis: yAxis,
        valueYField: "value",
        sequencedInterpolation: true,
        categoryXField: "tag",
        tooltip: am5.Tooltip.new(root, {
          labelText: "{valueY}"
        })
      }));

      series.columns.template.setAll({ cornerRadiusTL: 5, cornerRadiusTR: 5 });
      series.columns.template.adapters.add("fill", function (fill, target) {
        return chart.get("colors").getIndex(series.columns.indexOf(target));
      });

      series.columns.template.adapters.add("stroke", function (stroke, target) {
        return chart.get("colors").getIndex(series.columns.indexOf(target));
      });


      // Set data
      /*let data = [
        { tag: "Телевизија", value: 2025}, 
        { tag: "Осигурување",value: 1882}, 
        { tag: "Лекови", value: 1809}, 
        { tag: "Камчев", value: 1322}, 
        { tag: "Лотарија",value: 1122}, 
        { tag: "Нафтена",value: 1114 }, 
        { tag: "Градежни материјали", value: 984}, 
        { tag: "Живинарство", value: 711 }, 
        { tag: "Вемилк",value: 665}, 
        { tag: "Tinex", value: 580}, 
        {tag: "Металургија",value: 443}, 
        { tag: "Промес", value: 441 }];*/
      //let data = [];
      // this.tagsList-zemi od baza dolu prikazano
      this.chartModelTagList.forEach(element => {
        console.log(element);
        this.data.push({ tag: element.tag_name_c, value: element.num_of_tags });
        console.log(this.data);
        console.log(this.chartModelTagList);
      });
      
      
      xAxis.data.setAll(this.data);
      series.data.setAll(this.data);


      // Make stuff animate on load
      // https://www.amcharts.com/docs/v5/concepts/animations/
      series.appear(1000);
      chart.appear(1000, 100);

    });


  }

}
