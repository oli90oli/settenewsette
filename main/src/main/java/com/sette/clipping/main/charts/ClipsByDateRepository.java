package com.sette.clipping.main.charts;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClipsByDateRepository {
    public ClipsByDateRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    public List<ChartsModelClipsByDate> return_clips_by_date() {
        return template.query("SELECT * FROM  return_clips_by_date()", new ChartsRowMapperClipsByDate());
    }
}
