package com.sette.clipping.main.basic;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.sette.clipping.main.basic.JsonApi;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ENabavkiModel extends JsonApi{

    /**public String getData(){
        try {

            Unirest.setTimeouts(0, 0);
            //System.out.println(doc);
            HttpResponse<JsonNode> response = Unirest.post("https://e-nabavki.gov.mk/Services/News.asmx/GetAllNews")
                    //.header("Cache-Control", "private")
                    .header("Content-Type", "application/json; charset=utf-8")
                    .header("Accept", "application/json, text/plain, **")
                    .queryString("Connection", "keep-alive")
                    .queryString("Cookie", "_ga=GA1.3.1303927022.1650724296; _gid=GA1.3.1776627477.1650724296; ASP.NET_SessionId=knhottmrzgqnccw31l1lnqjw; _gat=1")

                    .asJson();

            // System.out.println(response.getBody().getObject().toString(2));
            //System.out.println(response.getBody().getObject().get("d"));
            // JSONObject jsonObject = new JSONObject(response.getBody().getObject().toString(2));
            //getting values form the JSONObject
            //System.out.println("Employee ID: "+jsonObject.get("d").toString().length());
            // String response_d= jsonObject.get("d").toString();
            //for(int i=0;i<response_d.length();i++){
            //  System.out.println(i+": ");
            // }
            return response.getBody().getObject().toString(2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }


     //ArrayList<ModelENabavki> list = new ArrayList<ModelENabavki>();
     }
     }
     /*
    public void convertToJSON(){
        String response = this.getData();
        System.out.println(response);
        JSONObject jsonObject = new JSONObject(response);
        Iterator<String> keys = jsonObject.keys();

        while(keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONObject) {
                // do something with jsonObject here
                System.out.print("Ljubisa");
            }
        }
    }
    public void test(){
        JSONObject jsonObject = new JSONObject(this.getData());
        String response_d= jsonObject.get("d").toString();
        if(jsonObject.has("d")){
            //get Value of video
            String d = jsonObject.optString("d");
            JSONObject inputJson = new JSONObject(this.getData());
            List<String> lst = new ArrayList<String>();
            lst = super.findKeysOfJsonObject(inputJson, lst);
            System.out.println("List size= "+lst.size());
            for(int i=0;i<lst.size();i++){
                System.out.println(lst.get(i));
            }
        }
    }
    public void testOLD(){
        //System.out.println(this.getData());
        JSONObject jsonObject = new JSONObject(this.getData());
        String response_d= jsonObject.get("d").toString();
        if(jsonObject.has("d")){
            //get Value of video
            String d = jsonObject.optString("d");
            //JSONObject innerObject = jsonObject.getJSONObject("d");
            /*  if(innerObject.has("TitleMK")){

            System.out.print(innerObject.optString("TitleMK"));
            }
            //System.out.print(d);
            // for(int i=0;i<response_d.length();i++){
            //System.out.println(i+": "+jsonObject.get(""));
            // }
            JSONObject inputJson = new JSONObject(this.getData());
            List<String> lst = new ArrayList<String>();
            lst = super.findKeysOfJsonObject(inputJson, lst);
        }
    }*/

            //ArrayList<ModelENabavki> list = new ArrayList<ModelENabavki>();
        }

