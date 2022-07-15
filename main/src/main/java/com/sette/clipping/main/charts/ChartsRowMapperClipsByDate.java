package com.sette.clipping.main.charts;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChartsRowMapperClipsByDate implements RowMapper<ChartsModelClipsByDate> {
    @Override
    public ChartsModelClipsByDate mapRow(ResultSet rs, int arg1) throws SQLException {
        ChartsModelClipsByDate chart1 = new ChartsModelClipsByDate();
        chart1.setClips_per_date(rs.getInt("clips_per_date"));
        chart1.setDate_of_clip(rs.getString("date_of_clip"));
        return chart1;
    }
}
