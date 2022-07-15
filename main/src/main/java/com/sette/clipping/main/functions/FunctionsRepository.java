package com.sette.clipping.main.functions;

import com.sette.clipping.main.charts.ChartsRowMapperMedium;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionsRepository {
    public FunctionsRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    public List<FunctionsMediumModel> fun_mediums() {
        return template.query("SELECT * FROM  fun_mediums()", new FunctionsRowMapperMedium());
    }
    
    public List<FunctionsTagModel> fun_tags() {
        return template.query("SELECT * FROM  fun_tags()", new FunctionsRowMapperTag());
    }
    
    public List<FunctionsClientModel> fun_clients() {
        return template.query("SELECT * FROM  fun_clients()", new FunctionsRowMapperClient());
    }
    
    public List<FunctionsClipModel> fun_clips() {
        return template.query("SELECT * FROM  fun_clips()", new FunctionsRowMapperClip());
    }
    
    public List<FunctionsClipPrintedModel> fun_clips_printed() {
        return template.query("SELECT * FROM  fun_clips_printed()", new FunctionsRowMapperClipPrinted());
    }
}
