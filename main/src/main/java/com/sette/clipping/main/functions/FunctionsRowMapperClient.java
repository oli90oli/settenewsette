package com.sette.clipping.main.functions;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FunctionsRowMapperClient implements RowMapper<FunctionsClientModel> {

@Override
public FunctionsClientModel mapRow (ResultSet rs, int arg1) throws SQLException {
        FunctionsClientModel funcClient = new FunctionsClientModel();
        funcClient.setClient_id(rs.getInt("client_id"));
        funcClient.setClient_bcc(rs.getString("client_bcc"));
        funcClient.setClient_email(rs.getString("client_email"));
        funcClient.setClient_name(rs.getString("client_name"));
        funcClient.setClient_password(rs.getString("client_password"));
        funcClient.setClient_username(rs.getString("client_username"));
        funcClient.setFollows_analytics(rs.getBoolean("follows_analytics"));
        funcClient.setFollows_bankruptcies(rs.getBoolean("follows_bankruptcies"));
        funcClient.setFollows_clips(rs.getBoolean("follows_clips"));
        funcClient.setFollows_notifications(rs.getBoolean("follows_notifications"));
        funcClient.setFollows_sales(rs.getBoolean("follows_sales"));
        funcClient.setIs_latin(rs.getBoolean("is_latin"));
        funcClient.setIs_tags(rs.getBoolean("is_tags"));
        funcClient.setIs_trial(rs.getBoolean("is_trial"));
        funcClient.setMail_title(rs.getString("mail_title"));
        funcClient.setPdf_title(rs.getString("pdf_title"));
        funcClient.setClient_tag_id(rs.getInt("client_tag_id"));
        funcClient.setTag_id(rs.getInt("tag_id"));
        funcClient.setTag_name_c(rs.getString("tag_name_c"));
        funcClient.setTag_name_l(rs.getString("tag_name_l"));
        funcClient.setTag_color(rs.getString("tag_color"));
        funcClient.setParent_tag(rs.getBoolean("parent_tag"));
        funcClient.setParent_tag_id(rs.getInt("parent_tag_id"));
        funcClient.setTags_category_id(rs.getInt("tags_category_id"));
        funcClient.setTags_category_name(rs.getString("tags_category_name"));

    return funcClient;
        }
}
