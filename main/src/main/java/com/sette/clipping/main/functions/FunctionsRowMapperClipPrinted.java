package com.sette.clipping.main.functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FunctionsRowMapperClipPrinted implements RowMapper<FunctionsClipPrintedModel> {    

    @Override
public FunctionsClipPrintedModel mapRow (ResultSet rs, int arg1) throws SQLException {
        FunctionsClipPrintedModel funcClip = new FunctionsClipPrintedModel();
        funcClip.setClip_printed_id(rs.getLong("clip_printed_id"));
        funcClip.setClip_text(rs.getString("clip_text"));
        funcClip.setBrief(rs.getString("brief"));
        funcClip.setBrief_english(rs.getString("brief_english"));
        funcClip.setClip_area(rs.getString("clip_area"));
        funcClip.setClip_group(rs.getInt("clip_group"));
        funcClip.setClip_image(rs.getBoolean("clip_image"));
        funcClip.setClip_image_url(rs.getString("clip_image_url"));
        funcClip.setClip_main_page(rs.getBoolean("clip_main_page"));
        funcClip.setClip_pages(rs.getString("clip_pages"));
        funcClip.setClip_relevance(rs.getString("clip_relevance"));
        funcClip.setClip_research(rs.getString("clip_research"));
        funcClip.setClip_title(rs.getString("clip_title"));
        funcClip.setClip_title_english(rs.getString("clip_title_english"));
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
