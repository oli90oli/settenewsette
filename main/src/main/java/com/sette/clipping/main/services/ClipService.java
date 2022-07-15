package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Clip;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipRepository;

@Service
public class ClipService {
    private final ClipRepository clipRepository;
       
        @Autowired
        public ClipService(ClipRepository clipRepository) {
            this.clipRepository = clipRepository;
        }
        
        public Clip addClip(Clip clip) {
            return clipRepository.save(clip);
        }

        public List<Clip> findAllClip() {
            return clipRepository.findAll();
        }
                
        public void updateClipGroup(long id, Clip clip) {
            Clip c = this.findClip(id);
            c.setMain_clip(clip.isMain_clip());
            clipRepository.save(c);     
        }
        
        public void removeClipFromGroup(long id, Clip clip) {
            Clip c = this.findClip(id);
            c.setClip_group(-1);
            c.setMain_clip(true);
            clipRepository.save(c);
        }

        public void updateClip(long id, Clip clip) {
            Clip c = this.findClip(id);           
            if(!clip.getBrief().equals("")) {
                c.setBrief(clip.getBrief());
            }
            if(clip.getBrief_english() != null) {
                c.setBrief_english(clip.getBrief_english());
            }
            if(!clip.getClip_text().equals("")) {
                c.setClip_text(clip.getClip_text());
            }
            if(!clip.getClip_title().equals("")) {
                c.setClip_title(clip.getClip_title());
            }
            if(clip.getClip_title_english() != null) {
                c.setClip_title_english(clip.getClip_title_english());
            }
            if(!clip.getClip_url().equals("")) {
                c.setClip_url(clip.getClip_url());
            }
            if(!clip.getCreated_at().equals("")) {
                c.setCreated_at(clip.getCreated_at());
            }
            if(!clip.getCreated_at_time().equals("")) {
                c.setCreated_at_time(clip.getCreated_at_time());
            }
            if(!clip.getDate_of_clip().equals("")) {
                c.setDate_of_clip(clip.getDate_of_clip());
            }
           
            if(!clip.getClip_image_url().equals("")) {
                c.setClip_image_url(clip.getClip_image_url());
            }
            if(clip.getMedium_id()!= -1) {
                c.setMedium_id(clip.getMedium_id());
            }
            if(clip.getClip_group()!= -1) {
                c.setClip_group(clip.getClip_group());
            }
            if(!clip.isMain_clip()) {
            c.setMain_clip(clip.isMain_clip());
            }
            clipRepository.save(c);
        }
        
       public Clip findClip(long id) {
            return this.findAllClip().stream().filter(t -> t.getClip_id()== id).findFirst().get();
     } 
       
       public Clip returnLastClip() {
           List<Clip> m = this.findAllClip();
           return this.findAllClip().stream().filter(t -> t.getClip_id() == m.get(m.size() - 1).getClip_id()).findFirst().get();
       }
        
        public void deleteClip(long id) {
            clipRepository.deleteById(id);
        } 
}
