package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClipTag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipTagRepository;

@Service
public class ClipTagService {
    private final ClipTagRepository clipTagRepository;
       
        @Autowired
        public ClipTagService(ClipTagRepository clipTagRepository) {
            this.clipTagRepository = clipTagRepository;
        }
        
        public ClipTag addClipTag(ClipTag clipTag) {
            return clipTagRepository.save(clipTag);
        }
        
        public List<ClipTag> findAllClipTag() {
            return clipTagRepository.findAll();
        }
        
        public void updateClipTag(int id, ClipTag clipTag) {
            ClipTag cTag = this.findClipTag(id);
            if(clipTag.getClip_id() != -1) {
                cTag.setClip_id(clipTag.getClip_id());
            }
            if(clipTag.getTag_id()!= -1) {
                cTag.setTag_id(clipTag.getTag_id());
            }
            clipTagRepository.save(cTag);
        }
        
       public ClipTag findClipTag(int id) {
            return this.findAllClipTag().stream().filter(t -> t.getClip_tag_id()== id).findFirst().get();
     } 
        
        public void deleteClipTag(int id) {
            clipTagRepository.deleteById(id);
        } 
}
