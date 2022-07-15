package com.sette.clipping.main.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class EPazarServices {
    private String  web_site_url    =   "https://e-pazar.gov.mk//api";
    private int     pageNumber      =   0;
    public String getCompletedTenders(){
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response = Unirest.get(this.web_site_url+"/tender/searchCompletedsTenders?PageNumber="+this.pageNumber+"&PageSize=10")
                    .header("Cache-Control", "private")
                    .header("Content-Type", "application/json; charset=utf-8")
                    .header("Accept", "application/json, text/plain, */*")
                    .header("Connection", "keep-alive")
                    .header("Cookie", "_gid=GA1.3.955165254.1657745381; _ga_JMC9X6F8Z2=GS1.1.1657745380.1.1.1657745507.0; _ga=GA1.3.157939924.1657745381; _gat_gtag_UA_211427414_1=1")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36")
                    .asJson();
            return response.getBody().getObject().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    public JSONObject getJSONCompletedTenders(){
        JSONObject jsonObject = new JSONObject(this.getCompletedTenders());
        return jsonObject;
    }
    public void setPageNumber(int pageNumber){
        this.pageNumber =   pageNumber;
    }
    public int getPageNumber(){
        return this.pageNumber;
    }
}
