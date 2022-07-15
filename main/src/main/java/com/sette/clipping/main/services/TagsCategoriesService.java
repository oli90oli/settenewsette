package com.sette.clipping.main.services;

import com.sette.clipping.main.model.TagsCategories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.TagsCategoriesRepository;

@Service
public class TagsCategoriesService {
    private final TagsCategoriesRepository tagsCategoriesRepository;

    @Autowired
    public TagsCategoriesService(TagsCategoriesRepository tagsCategoriesRepository) {
        this.tagsCategoriesRepository = tagsCategoriesRepository;
    }

    public TagsCategories addTagsCategory(TagsCategories tagCategories) {
        return tagsCategoriesRepository.save(tagCategories);
    }

    public List<TagsCategories> findAllTagsCategories() {
        return tagsCategoriesRepository.findAll();
    }

    public void updateTagsCategory(int id, TagsCategories tagCategories) {
        TagsCategories tagCategory = this.findTagsCategory(id);
        if(!tagCategories.getTags_category_name().equals("")) {
            tagCategory.setTags_category_name(tagCategories.getTags_category_name());
        }
        tagsCategoriesRepository.save(tagCategory);
    }

    public TagsCategories findTagsCategory(int id) {
        return this.findAllTagsCategories().stream().filter(t -> t.getTags_category_id()== id).findFirst().get();
    }

    public void deleteTagsCategory(int id) {
        tagsCategoriesRepository.deleteById(id);
    }
}