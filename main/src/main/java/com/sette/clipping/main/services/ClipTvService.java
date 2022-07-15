package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Clip;
import com.sette.clipping.main.model.ClipTv;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipTvRepository;

@Service
public class ClipTvService {
    private final ClipTvRepository clipTvRepository;
       
        @Autowired
        public ClipTvService(ClipTvRepository clipTvRepository) {
            this.clipTvRepository = clipTvRepository;
        }
        
        public ClipTv addClipTv(ClipTv clipTv) {
            return clipTvRepository.save(clipTv);
        }
        
        public List<ClipTv> findAllClipTv() {
            return clipTvRepository.findAll();
        }
        
        public void updateClipTvGroup(long id, ClipTv clip) {
            ClipTv cTv = this.findClipTv(id);
            cTv.setMain_clip(clip.isMain_clip());
            clipTvRepository.save(cTv);     
        }
        
        public void removeClipTvFromGroup(long id, ClipTv clip) {
            ClipTv cTv = this.findClipTv(id);
            cTv.setClip_group(-1);
            cTv.setMain_clip(true);
            clipTvRepository.save(cTv);
        }
        
        public void updateClipTv(long id, ClipTv clipTv) {
            ClipTv cTv = this.findClipTv(id);
            if(clipTv.getClip_id() != -1 ) {
                cTv.setClip_id(clipTv.getClip_id());
            }
            if(clipTv.getMedium_id() != -1) {
                cTv.setMedium_id(clipTv.getMedium_id());
            }
            if(!clipTv.getCreated_at().equals("")) {
                cTv.setCreated_at(clipTv.getCreated_at());
            }
            if(!clipTv.getDate_of_clip().equals("")) {
                cTv.setDate_of_clip(clipTv.getDate_of_clip());
            }
            if(!clipTv.getClip_title().equals("")) {
                cTv.setClip_title(clipTv.getClip_title());
            }
            if(!clipTv.getClip_text().equals("")) {
                cTv.setClip_text(clipTv.getClip_text());
            }
            if(!clipTv.getBrief().equals("")) {
                cTv.setBrief(clipTv.getBrief());
            }
            if(!clipTv.getVideo_url().equals("")) {
                cTv.setVideo_url(clipTv.getVideo_url());
            }
            if(clipTv.getClip_group()!= -1) {
                cTv.setClip_group(clipTv.getClip_group());
            }
            if(!clipTv.isMain_clip()) {
            cTv.setMain_clip(clipTv.isMain_clip());
            }
            clipTvRepository.save(cTv);
        }
        
       public ClipTv findClipTv(long id) {
            return this.findAllClipTv().stream().filter(t -> t.getClip_id()== id).findFirst().get();
     } 
        
        public void deleteClipTv(long id) {
            clipTvRepository.deleteById(id);
        } 
}
