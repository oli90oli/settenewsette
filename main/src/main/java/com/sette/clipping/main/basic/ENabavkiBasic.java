package com.sette.clipping.main.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class ENabavkiBasic {

public void getTenders() {
    /*ENabavki jsonENabavki = new ENabavki();
    JSONObject jsonObjGridData = jsonENabavki.getJSONDataGrid();
    JSONObject jsonD = jsonObjGridData;
    Iterator x = jsonD.keys();
    int number_of_page = (int) jsonD.get("recordsTotal");
    while (x.hasNext()) {
        String key = (String) x.next();
        System.out.println("Grid key: " + key + " " + jsonD.get(key));
    }

    System.out.println("Pages: " + number_of_page);
    //getting whole json string
    JSONArray ja_data = jsonD.getJSONArray("data");

    int length = ja_data.length();
    //loop to get all json objects from data json array
    for (int i = 0; i < length; i++) {
        JSONObject jObj = ja_data.getJSONObject(i);
        System.out.print("ProcessNumber " + jObj.getString("ProcessNumber").toString() + " FinalDay : " + jObj.getString("FinalDay").toString());
    }*/
}
}
