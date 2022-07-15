package com.sette.clipping.main.charts;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChartsRowMapperTag implements RowMapper<ChartsModelTag> {

    @Override
    public ChartsModelTag mapRow(ResultSet rs, int arg1) throws SQLException {
        ChartsModelTag chart2 = new ChartsModelTag();
        chart2.setNum_of_tags(rs.getInt("num_of_tags"));
        chart2.setTag_name_c(rs.getString("tag_name_c"));
        return chart2;
    }

}
