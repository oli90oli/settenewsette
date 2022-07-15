package com.sette.clipping.main.charts;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChartsRowMapperMedium implements RowMapper<ChartsModelMedium> {
    @Override
    public ChartsModelMedium mapRow(ResultSet rs, int arg1) throws SQLException {
        ChartsModelMedium chart1 = new ChartsModelMedium();
        chart1.setNum_of_mediums(rs.getInt("num_of_mediums"));
        chart1.setMedium_name_cyrilic(rs.getString("medium_name_cyrilic"));
        return chart1;
    }


}
