package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClipTag;
import com.sette.clipping.main.model.TenderTags;
import com.sette.clipping.main.repositories.TenderTagsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TenderTagsService {

    private final TenderTagsRepository tenderTagsRepository;
       
        @Autowired
        public TenderTagsService(TenderTagsRepository tenderTagsRepository) {
            this.tenderTagsRepository = tenderTagsRepository;
        }
        
        public TenderTags addTenderTag(TenderTags tenderTag) {
            return tenderTagsRepository.save(tenderTag);
        }
        
        public List<TenderTags> findAllTenderTags() {
            return tenderTagsRepository.findAll();
        }
        
        public void updateTenderTag(int id, TenderTags tenderTag) {
            TenderTags tTag = this.findTenderTag(id);
            if(tenderTag.getTender_tag_id()!= -1) {
                tTag.setTender_tag_id(tenderTag.getTender_tag_id());
            }
            if(tenderTag.getTender_id()!= -1) {
                tTag.setTender_id(tenderTag.getTender_id());
            }
            if(tenderTag.getTag_id()!= -1) {
                tTag.setTag_id(tenderTag.getTag_id());
            }
            tenderTagsRepository.save(tTag);
        }
        
       public TenderTags findTenderTag(int id) {
            return this.findAllTenderTags().stream().filter(t -> t.getTender_tag_id()== id).findFirst().get();
     } 
        
        public void deleteTenderTag(int id) {
            tenderTagsRepository.deleteById(id);
        } 
    
}
