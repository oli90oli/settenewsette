package com.sette.clipping.main.functions;

import com.sette.clipping.main.charts.ChartsModelAuthor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class FunctionsRowMapperMedium implements RowMapper<FunctionsMediumModel> {

@Override
public FunctionsMediumModel mapRow (ResultSet rs, int arg1) throws SQLException {
        FunctionsMediumModel funcMed = new FunctionsMediumModel();
        funcMed.setMedium_id(rs.getInt("medium_id"));
        funcMed.setMedium_name(rs.getString("medium_name"));
        funcMed.setMedium_name_cyrilic(rs.getString("medium_name_cyrilic"));
        funcMed.setMedium_type_id(rs.getInt("medium_type_id"));
        funcMed.setMedium_type_name(rs.getString("medium_type_name"));

    return funcMed;
        }
}
