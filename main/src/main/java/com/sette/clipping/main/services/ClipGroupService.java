package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClipGroup;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipGroupRepository;

@Service
public class ClipGroupService {
    private final ClipGroupRepository clipGroupRepository;
       
        @Autowired
        public ClipGroupService(ClipGroupRepository clipGroupRepository) {
            this.clipGroupRepository = clipGroupRepository;
        }
        
        public ClipGroup addClipGroup(ClipGroup clipGroup) {
            return clipGroupRepository.save(clipGroup);
        }
        
        public List<ClipGroup> findAllClipGroup() {
            return clipGroupRepository.findAll();
        }
        
        public void updateClipGroup(int id, ClipGroup clipGroup) {
            ClipGroup cGroup = this.findClipGroup(id);
            if (clipGroup.getGroup_id() != -1) {
                cGroup.setGroup_id(clipGroup.getGroup_id());
            }
            if (clipGroup.getClip_id()!= -1) {
                cGroup.setClip_id(clipGroup.getClip_id());
            }
            clipGroupRepository.save(cGroup);
        }
        
       public ClipGroup findClipGroup(int id) {
            return this.findAllClipGroup().stream().filter(t -> t.getGroup_id()== id).findFirst().get();
     }
        
        public void deleteClipGroup(int id) {
            clipGroupRepository.deleteById(id);
        } 
}
