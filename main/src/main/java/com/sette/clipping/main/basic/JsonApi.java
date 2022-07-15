package com.sette.clipping.main.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONObject;


public class JsonApi extends ObjectMapper{
    private String property;
    private String value;
    public  ArrayList<JsonApi> getResult = new ArrayList<JsonApi>();
    private StringBuilder   strOut  = new StringBuilder();
    private JSONObject      json    = new JSONObject();
    private String          jsonStr;
    public JsonApi(){}
    public JsonApi(String property, String value){
        this.property   =   property;
        this.value      =   value;
    }
    public void setProperty(String property){
        this.property   =   property;
    }
    public void setValue(String value){
        this.value      =   value;
    }
    public String getProperty(){
        return this.property;
    }
    public String getValue(){
        return this.value;
    }
    //methods
    public  List<String> findKeysOfJsonArray(JSONArray jsonIn, List<String> keys) {
        List<String> keysFromArr = new ArrayList<>();

        if (jsonIn != null && jsonIn.length() != 0) {
            for (int i = 0; i < jsonIn.length(); i++) {
                JSONObject jsonObjIn = jsonIn.getJSONObject(i);
                keysFromArr = this.findKeysOfJsonObject(jsonObjIn, keys);
            }
        }
        return keysFromArr;
    }
    public  List<String> findKeysValueOfJsonArray(JSONArray jsonIn, List<String> keys) {
        List<String> keysFromArr = new ArrayList<>();

        if (jsonIn != null && jsonIn.length() != 0) {
            for (int i = 0; i < jsonIn.length(); i++) {
                JSONObject jsonObjIn = jsonIn.getJSONObject(i);
                keysFromArr = this.findKeysValuesOfJsonObject(jsonObjIn, keys);
            }
        }
        return keysFromArr;
    }
    public  List<String> findKeysOfJsonObject(JSONObject jsonIn, List<String> keys) {
        Iterator<String> itr = jsonIn.keys();
        List<String> keysFromObj = this.makeList(itr);
        keys.addAll(keysFromObj);

        itr = jsonIn.keys();
        while (itr.hasNext()) {
            String itrStr = itr.next();
            // System.out.println("out " + itrStr);
            JSONObject jsout = null;
            JSONArray jsArr = null;
            if (jsonIn.get(itrStr).getClass() == JSONObject.class) {
                jsout = jsonIn.getJSONObject(itrStr);
                this.findKeysOfJsonObject(jsout, keys);
            } else if (jsonIn.get(itrStr).getClass() == JSONArray.class) {
                jsArr = jsonIn.getJSONArray(itrStr);
                keys.addAll(this.findKeysOfJsonArray(jsArr, keys));
            } else if (jsonIn.get(itrStr).getClass() == String.class) {
                System.out.println(itrStr + "-" + jsonIn.get(itrStr));
                strOut.append(itrStr + "," + jsonIn.get(itrStr));
                strOut.append(System.lineSeparator());
            }
        }
        return keys;
    }
    public  List<String> findKeysValuesOfJsonObject(JSONObject jsonIn, List<String> keys) {
        // ArrayList<jsonAPI> getResult = new ArrayList<jsonAPI>();
        Iterator<String> itr = jsonIn.keys();
        List<String> keysFromObj = this.makeList(itr);
        keys.addAll(keysFromObj);

        itr = jsonIn.keys();
        while (itr.hasNext()) {
            String itrStr = itr.next();
            // System.out.println("out " + itrStr);
            JSONObject jsout = null;
            JSONArray jsArr = null;
            if (jsonIn.get(itrStr).getClass() == JSONObject.class) {
                jsout = jsonIn.getJSONObject(itrStr);
                this.findKeysValuesOfJsonObject(jsout, keys);
            } else if (jsonIn.get(itrStr).getClass() == JSONArray.class) {
                jsArr = jsonIn.getJSONArray(itrStr);
                keys.addAll(this.findKeysValueOfJsonArray(jsArr, keys));
            } else if (jsonIn.get(itrStr).getClass() == String.class) {
               // System.out.println("Ljube: "+itrStr + "-" + jsonIn.get(itrStr));
                this.getResult.add(new JsonApi(itrStr,(String)jsonIn.get(itrStr)));
                strOut.append(itrStr + "," + jsonIn.get(itrStr));
                strOut.append(System.lineSeparator());
            }
        }
        return keys;
    }
    public  List<String> findKeysOfJsonObjectNew(JSONObject jsonIn, List<String> keys) {

        Iterator<String> itr = jsonIn.keys();
        List<String> keysFromObj = makeList(itr);
        keys.addAll(keysFromObj);
        return keys;
    }
    public List<String> makeList(Iterator<String> iter) {
        List<String> list = new ArrayList<String>();
        while (iter.hasNext()) {
            list.add(iter.next());
        }
        return list;
    }
    public JSONObject getJSON(){
        //return this.json.toString();
        return this.json;
    }
    public String getJSONStr(){
        return this.json.toString();
    }
}
