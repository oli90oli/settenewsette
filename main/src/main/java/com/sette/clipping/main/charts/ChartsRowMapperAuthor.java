package com.sette.clipping.main.charts;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChartsRowMapperAuthor implements RowMapper<ChartsModelAuthor> {

    @Override
    public ChartsModelAuthor mapRow (ResultSet rs, int arg1) throws SQLException {
        ChartsModelAuthor chart3 = new ChartsModelAuthor();
        chart3.setNum_of_authors(rs.getInt("num_of_authors"));
        chart3.setFull_name_c(rs.getString("full_name_c"));
        return chart3;
    }
}
