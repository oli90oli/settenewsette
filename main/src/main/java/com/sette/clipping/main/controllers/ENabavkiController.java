package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Tenders;
import com.sette.clipping.main.repositories.TendersRepository;
import com.sette.clipping.main.services.ENabavkiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping("/enabavki")
public class ENabavkiController {
    //
//@Autowired
//   //ENabavkiRepository repo;
    @Autowired
    private  ENabavkiService eNabavkiService;

    @Autowired
    private TendersRepository tendersRepo;
    //private  final AuthorsService authorService1;
//
//    public ENabavkiController(AuthorsService authorService1, ENabavkiService eNabavkiService) {
//        this.authorService1 = authorService1;
//        this.eNabavkiService = eNabavkiService;
//    }
//    @PostMapping("/add")
//    public void addNabavki() {
//        ArrayList<ENabavki> listNabavki=this.eNabavkiService.getKeysValues();
//        JSONObject jsonObj=this.eNabavkiService.getJSON();
//        int length = jsonObj.length();
//       // Authors author = new Authors();
//       // Authors newAuthor = new Authors();
//        for(int i=0; i<length; i++) {
//            System.out.println("Loop id:"+i+" "+jsonObj.getString("TitleMK"));
//
//            Authors author = new Authors(34,"Ljubisa",jsonObj.getString("TitleMK"));
//            Authors newAuthor = authorService1.addAuthors(author);
//        }
//        System.out.print("Enabavki Size "+listNabavki.size()+" length: "+length);
//            //loop
//
//       // return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
//       //Authors author = new Authors(34,"Ljubisa","Popovski");
//       //Authors newAuthor = authorService1.addAuthors(author);
//      // return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
//    }



    //    public ENabavkiController(AuthorsService authorService1, ENabavkiService eNabavkiService) {
//        //this.authorService1 = authorService1;
//        this.eNabavkiService = eNabavkiService;
//   }
    @PostMapping("/addNabavki")
    public void addNabavki1(){
        JSONObject jsonObj=this.eNabavkiService.getJSONData();
        jsonObj.has("data");
        int length = jsonObj.length();
        System.out.println("Length data: "+length);
        System.out.println(jsonObj.get("data").toString());
        System.out.println(jsonObj.get("data").toString());
    }
    @PostMapping("/addENabavki")
    public void addENabavki2(){
        JSONObject jsonObjGridDataPages =  this.eNabavkiService.getJSONDataGrid();
        int number_of_page              =  (int)jsonObjGridDataPages.get("recordsTotal");
        this.eNabavkiService.setNumberOfPages(number_of_page);
        jsonObjGridDataPages            =  this.eNabavkiService.getJSONDataGrid();
        JSONArray ja_data               =  jsonObjGridDataPages.getJSONArray("data");
        int length                      =  ja_data.length();

        //loop to get all json objects from data json array
        for(int i=0; i<length; i++) {
            JSONObject jObj = ja_data.getJSONObject(i);
            System.out.println(i+
                    " Id "+jObj.getString("Id").toString()+
                    " ProcessNumber "+jObj.getString("ProcessNumber").toString()+
                    " FinalDay : "+ jObj.getString("FinalDay").toString()+
                    " ContractingInstitutionName : "+ " "+jObj.getString("ContractingInstitutionName").toString()+
                    " Subject: "+jObj.getString("Subject").toString());


            JSONObject jsonObjGridSingleData =  this.eNabavkiService.getJSONSingleDataGrid(jObj.getString("Id").toString());
            // JSONArray jObj_singe_data        =  jsonObjGridSingleData.getJSONArray("Categories");
            // JSONObject jObj_singe_data_       = jObj_singe_data.getJSONObject(0);
            System.out.println("OfferTypeStr: "+jsonObjGridSingleData.get("OfferTypeStr")+" / ");
            // Authors author = new Authors((120+34),"Ljubisa",jObj.getString("ProcessNumber").toString());
            //Authors newAuthor = authorService1.addAuthors(author);
            Tenders tenders = new Tenders( (i+1),
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    false,
                    false,
                    jObj.getString("ProcessNumber").toString(),
                    jObj.getString("ContractingInstitutionName").toString(),
                    jObj.getString("Subject").toString(),
                    jObj.getString("GoodsWorksServices").toString(),
                    jObj.getString("EntityProcedureType").toString(),
                    jObj.getString("AnnouncementDate").toString(),
                    jObj.getString("FinalDay").toString(),
                    jObj.getBoolean("IsDevided") );



            tendersRepo.saveAndFlush(tenders);
//           eNabavkiService.addTenders(tenders);
            //   String tender_subject, String tender_description, String tender_url, String tender_date, String tender_expire, Boolean isPonistuvanje, Boolean isPrilog, String processNumber, String contractingInstitutionName, String subject, String goodsWorksServices, String entityProcedureType, String announcementDate, String finalDay, boolean isDevided) {
            /* 	tender_id, tender_date, tender_description, tender_expire, tender_medium, tender_publisher, tender_subject, tender_type, tender_url, datumnaobjava, dogovorenorgan, vidnapostapka, datumkraenrok, vidnadogovor, nabavkataedeliva, keys_arr, broglas, str_out, predmetnadogovor, is_ponistuvanje, is_prilog)
             */

        }
    }
}