package com.sette.clipping.main.functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FunctionsRowMapperTag implements RowMapper<FunctionsTagModel> {

@Override
public FunctionsTagModel mapRow (ResultSet rs, int arg1) throws SQLException {
        FunctionsTagModel funcTag = new FunctionsTagModel();
        funcTag.setTag_id(rs.getInt("tag_id"));
        funcTag.setTag_name_c(rs.getString("tag_name_c"));
        funcTag.setTag_name_l(rs.getString("tag_name_l"));
        funcTag.setTag_color(rs.getString("tag_color"));
        funcTag.setParent_tag(rs.getBoolean("parent_tag"));
        funcTag.setParent_tag_id(rs.getInt("parent_tag_id"));
        funcTag.setTags_category_id(rs.getInt("tags_category_id"));
        funcTag.setTags_category_name(rs.getString("tags_category_name"));

    return funcTag;
        }
}