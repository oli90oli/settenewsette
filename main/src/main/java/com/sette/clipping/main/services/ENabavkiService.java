package com.sette.clipping.main.services;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.sette.clipping.main.basic.JsonApi;
import com.sette.clipping.main.model.Tenders;
import com.sette.clipping.main.repositories.ENabavkiRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

@Service
public class ENabavkiService extends JsonApi {

    @Autowired
    ENabavkiRepository nabavkiRepo;

    public Tenders addTenders(Tenders tenders) {
        return nabavkiRepo.save(tenders);
    }

    private JSONObject          json        = new JSONObject();
    private String              jsonStr;
    private String[]            keysArr     ={"ProcessNumber","ContractingInstitutionName", "Subject",
            "GoodsWorksServices", "EntityProcedureType", "AnnouncementDate",
            "FinalDay", "IsDevided"};
    private StringBuilder       strOut      = new StringBuilder();
    public ArrayList<Tenders>  getResult   = new ArrayList<>();
    private int numberOfPages               = 1;

    public String getData(){
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response = Unirest.post("https://e-nabavki.gov.mk/Services/Notices.asmx/GetGridData")
                    //.queryString("Cache-Control", "private")
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .header("Accept", "application/json, text/javascript, */*; q=0.01")
                    .queryString("Connection", "keep-alive")
                    .queryString("Cookie", "ASP.NET_SessionId=jmy34hkskati0cxw4fyzl3yq; _ga=GA1.3.308383860.1651088963; _gid=GA1.3.1972928070.1651088963; _gat=1")
                    .field("draw", "1")
                    .field("start", "103")
                    .field("length", "100")
                    .field("search[value]", " ")
                    .field("search[regex]", "false")
                    .field("Discriminator", "{\"ContractingInstitution\":\"\",\"EauctionOnly\":false,\"TypeOfPublicContract\":\"\",\"Status\":1,\"OngoingComplitedStatus\":\"\",\"TypeOfProcedure\":0,\"ProcessNumber\":\"\",\"IsSmallPublicProcurement\":false,\"EprocurementOnly\":false,\"PrivatePartnershipOnly\":false,\"ContractingInstitutionName\":null,\"Subject\":\"\",\"PeriodFrom\":\"\",\"PeriodTo\":\"\",\"SmallOnly\":false,\"BigOnly\":false,\"LotSubject\":\"\",\"OfferType\":\"\",\"IsFrameworkAgreement\":\"\",\"HasTechnicalDialog\":\"\"}")
                    .asJson();
            return response.getBody().getObject().toString(2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    public String getGetGridData(){
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response = Unirest.post("https://e-nabavki.gov.mk/Services/Notices.asmx/GetGridData")
                    .header("Cache-Control", "private")
                    .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                    .header("Accept", "application/json, text/javascript, */*; q=0.01")
                    .header("Connection", "keep-alive")
                    .header("Cookie", "ASP.NET_SessionId=jmy34hkskati0cxw4fyzl3yq; _ga=GA1.3.308383860.1651088963; _gid=GA1.3.1972928070.1651088963; _gat=1")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36")
                    .field("draw", "1")
                    .field("start", "1")
                    .field("length", this.numberOfPages)
                    .field("search[value]", " ")
                    .field("search[regex]", "false")
                    .field("Discriminator", "{\"ContractingInstitution\":\"\",\"EauctionOnly\":false,\"TypeOfPublicContract\":\"\",\"Status\":1,\"OngoingComplitedStatus\":\"\",\"TypeOfProcedure\":0,\"ProcessNumber\":\"\",\"IsSmallPublicProcurement\":false,\"EprocurementOnly\":false,\"PrivatePartnershipOnly\":false,\"ContractingInstitutionName\":null,\"Subject\":\"\",\"PeriodFrom\":\"\",\"PeriodTo\":\"\",\"SmallOnly\":false,\"BigOnly\":false,\"LotSubject\":\"\",\"OfferType\":\"\",\"IsFrameworkAgreement\":\"\",\"HasTechnicalDialog\":\"\"}")
                    .asJson();
            return response.getBody().getObject().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String getSingleData(String entityId){
        Unirest.setTimeouts(0, 0);
        try {
        HttpResponse<JsonNode> response = Unirest.post("https://e-nabavki.gov.mk/Dossie/GetDossieForEntity")
                .header("Content-Type", "application/json")
                .body("{\r\n    \"entityId\":\""+entityId+"\"\r\n}")
                .asJson();
            return response.getBody().getObject().toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
    public JSONObject getJSONDataGrid(){
        JSONObject jsonObject = new JSONObject(this.getGetGridData());
        return jsonObject;
    }
    public JSONObject getJSONSingleDataGrid(String entityId){
        JSONObject jsonObject = new JSONObject(this.getSingleData(entityId));
        return jsonObject;
    }
    @Bean
    public ArrayList<Tenders> getKeysValues(){
        ArrayList<Tenders> tenderList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(this.getData());
        String response_d= jsonObject.get("data").toString();
        if(jsonObject.has("data")){
            //get Value of video
            //String d = jsonObject.optString("d");
            /*
            JSONObject inputJson = new JSONObject(this.getData());
            List<String> lstKeys = new ArrayList<String>();
            lstKeys = super.findKeysOfJsonObject(inputJson, lstKeys);
            */

            //System.out.print(this.getData());
            JSONObject inputJson = new JSONObject(this.getData());
            List<String> lstKeys = new ArrayList<String>();
            List<String>  getResult = new ArrayList<>();
            super.findKeysValuesOfJsonObject(inputJson, lstKeys);

            ArrayList<JsonApi> lst=super.getResult;

            for(int i=0;i<lst.size();i++){
                if(lst.get(i).getProperty().equals("ProcessNumber")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                    this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("ContractingInstitutionName")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                    //this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("Subject")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                    this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("GoodsWorksServices")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                   // this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("EntityProcedureType")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                    //this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("AnnouncementDate")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                    //this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("FinalDay")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                   // this.json.put("TitleMK",lst.get(i).getValue());
                }
                else if(lst.get(i).getProperty().equals("IsDevided")){
                    System.out.println(i+" "+lst.get(i).getProperty()+" : "+lst.get(i).getValue());
                    //this.json.put("TitleMK",lst.get(i).getValue());
                }
            }
        }
        return tenderList;
    }
    public JSONObject getJSON(){
        //return this.json.toString();
        return this.json;
    }
    public JSONObject getJSONData(){
        JSONObject jsonObject = new JSONObject(this.getData());
        return jsonObject;
    }
    public String getJSONStr(){
        return this.json.toString();
    }
    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages = numberOfPages;
    }
    public int getNumberOfPages(){
        return this.numberOfPages;
    }
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
}
