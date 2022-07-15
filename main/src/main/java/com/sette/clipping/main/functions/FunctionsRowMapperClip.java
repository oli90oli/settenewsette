package com.sette.clipping.main.functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FunctionsRowMapperClip implements RowMapper<FunctionsClipModel> {

@Override
public FunctionsClipModel mapRow (ResultSet rs, int arg1) throws SQLException {
        FunctionsClipModel funcClip = new FunctionsClipModel();
        funcClip.setClip_id(rs.getLong("clip_id"));
        funcClip.setBrief(rs.getString("brief"));
        funcClip.setBrief_english(rs.getString("brief_english"));
        funcClip.setClip_group(rs.getInt("clip_group"));
        funcClip.setClip_image_url(rs.getString("clip_image_url"));
        funcClip.setClip_text(rs.getString("clip_text"));
        funcClip.setClip_title(rs.getString("clip_title"));
        funcClip.setClip_title_english(rs.getString("clip_title_english"));
        funcClip.setClip_url(rs.getString("clip_url"));
        funcClip.setCreated_at(rs.getString("created_at"));
        funcClip.setDate_of_clip(rs.getString("date_of_clip"));
        funcClip.setImportant_information(rs.getBoolean("important_information"));
        funcClip.setMain_clip(rs.getBoolean("main_clip"));
        funcClip.setMedium_id(rs.getInt("medium_id"));
        funcClip.setMedium_name(rs.getString("medium_name"));
        funcClip.setMedium_name_cyrilic(rs.getString("medium_name_cyrilic"));
        funcClip.setMedium_type_id(rs.getInt("medium_type_id"));
        funcClip.setMedium_type_name(rs.getString("medium_type_name"));
    return funcClip;
        }
}
