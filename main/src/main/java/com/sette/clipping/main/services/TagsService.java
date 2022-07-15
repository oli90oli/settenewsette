package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Tags;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.TagsRepository;

@Service
public class TagsService {
    private final TagsRepository tagRepository;

    @Autowired
    public TagsService(TagsRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tags addTags(Tags tags) {
        return tagRepository.save(tags);
    }

    public List<Tags> findAllTags() {
        return tagRepository.findAll();
    }

    public void updateTags(int id, Tags tags) {
        Tags tag = this.findTags(id);
        if(!tags.getTag_name_c().equals("")) {
            tag.setTag_name_c(tags.getTag_name_c());
        }
        if(!tags.getTag_name_l().equals("")) {
            tag.setTag_name_l(tags.getTag_name_l());
        }
        if(!tags.getTag_color().equals("")) {
            tag.setTag_color(tags.getTag_color());
        }
        if (tags.getTags_category_id() != -1) {
            tag.setTags_category_id(tags.getTags_category_id());
        }
        if (tags.isParent_tag()) {
            tag.setParent_tag(tags.isParent_tag());
        }
        if (tags.getParent_tag_id() != -1) {
            tag.setParent_tag_id(tags.getParent_tag_id());
        }
        tagRepository.save(tag);
    }

    public Tags findTags(int id) {
        return this.findAllTags().stream().filter(t -> t.getTag_id()== id).findFirst().get();
    }

    public void deleteTag(int id) {
        tagRepository.deleteById(id);
    }
}