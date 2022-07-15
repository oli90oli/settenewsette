package com.sette.clipping.main.controllers;

import com.sette.clipping.main.services.EPazarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping("/epazar")
public class EPazarController {
    @Autowired
    private EPazarServices ePazarServices;

    @PostMapping("/addEPazar")
    public void addEPazar(){
        JSONObject jsonObjData      =  this.ePazarServices.getJSONCompletedTenders();
        JSONObject jsonD            =  jsonObjData;
        int totalCount              =  (int)jsonD.get("totalCount");
        int totalPages              =  (int)jsonD.get("totalPages");

        System.out.println("Total count: "+totalCount+" totalPages: "+totalPages);
        //get data
        JSONArray ja_data = jsonD.getJSONArray("data");
        for(int curentPage=0;curentPage<=totalPages-1;curentPage++){
            this.ePazarServices.setPageNumber(curentPage);
            JSONObject jObj = ja_data.getJSONObject(curentPage);
            System.out.println("tenderNumber "+jObj.getString("tenderNumber").toString()+" contractAuthorityName : "+jObj.getString("contractAuthorityName").toString());
        }
    }
}
