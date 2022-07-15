package com.sette.clipping.main.charts;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChartsRepository {

    public ChartsRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    public List<ChartsModelMedium> return_clips_by_medium() {
        return template.query("SELECT * FROM  return_clips_by_medium()", new ChartsRowMapperMedium());
    }

    public List<ChartsModelTag> return_clips_by_tag() {
        return template.query("SELECT * FROM  return_clips_by_tag()", new ChartsRowMapperTag());
    }

    public List<ChartsModelAuthor> return_clips_by_author() {
        return template.query("SELECT * FROM  return_clips_by_author()", new ChartsRowMapperAuthor());
    }
//    public List<ChartsModelClipsByDate> return_clips_by_date() {
//        return template.query("SELECT * FROM  return_clips_by_date()", new ChartsRowMapperClipsByDate());
//    }
}
