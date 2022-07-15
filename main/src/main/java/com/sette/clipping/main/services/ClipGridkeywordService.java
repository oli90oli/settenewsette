package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClipGridkeyword;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipGridkeywordRepository;

@Service
public class ClipGridkeywordService {
    private final ClipGridkeywordRepository clipGridkeywordRepository;
       
        @Autowired
        public ClipGridkeywordService(ClipGridkeywordRepository clipGridkeywordRepository) {
            this.clipGridkeywordRepository = clipGridkeywordRepository;
        }
        
        public ClipGridkeyword addClipGridkeyword(ClipGridkeyword clipGridkeyword) {
            return clipGridkeywordRepository.save(clipGridkeyword);
        }
        
        public List<ClipGridkeyword> findAllClipGridkeyword() {
            return clipGridkeywordRepository.findAll();
        }
        
        public void updateClipGridkeyword(int id, ClipGridkeyword clipGridkeyword) {
            ClipGridkeyword cGridkeyword = this.findClipGridkeyword(id);
            if (!clipGridkeyword.getKeyword().equals("")) {
                cGridkeyword.setKeyword(clipGridkeyword.getKeyword());
            }
            if (clipGridkeyword.getClip_id() != -1) {
                cGridkeyword.setClip_id(clipGridkeyword.getClip_id());
            }
            clipGridkeywordRepository.save(cGridkeyword);
        }
        
       public ClipGridkeyword findClipGridkeyword(int id) {
            return this.findAllClipGridkeyword().stream().filter(t -> t.getClip_key_id() == id).findFirst().get();
     }
        
        public void deleteClipGridkeyword(int id) {
            clipGridkeywordRepository.deleteById(id);
        } 
}
