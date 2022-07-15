package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClipPrinted;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipPrintedRepository;


@Service
public class ClipPrintedService {
    private final ClipPrintedRepository clipPrintedRepository;
       
        @Autowired
        public ClipPrintedService(ClipPrintedRepository clipPrintedRepository) {
            this.clipPrintedRepository = clipPrintedRepository;
        }
        
        public ClipPrinted addClipPrinted(ClipPrinted clipPrinted) {
            return clipPrintedRepository.save(clipPrinted);
        }
        
        public List<ClipPrinted> findAllClipPrinted() {
            return clipPrintedRepository.findAll();
        }

        public void updateClipPrintedGroup(long id, ClipPrinted clipPrinted) {
            ClipPrinted c = this.findClipPrinted(id);
            c.setMain_clip(clipPrinted.isMain_clip());
            clipPrintedRepository.save(c);     
        }
        
        public void removeClipPrintedFromGroup(long id, ClipPrinted clipPrinted) {
            ClipPrinted c = this.findClipPrinted(id);
            c.setClip_group(-1);
            c.setMain_clip(true);
            clipPrintedRepository.save(c);
        }

        public void updateClipPrinted(long id, ClipPrinted clip) {
            ClipPrinted c = this.findClipPrinted(id);           
            if(!clip.getBrief().equals("")) {
                c.setBrief(clip.getBrief());
            }
            if(!clip.getBrief_english().equals("")) {
                c.setBrief_english(clip.getBrief_english());
            }
            if(!clip.getClip_text().equals("")) {
                c.setClip_text(clip.getClip_text());
            }
            if(!clip.getClip_title().equals("")) {
                c.setClip_title(clip.getClip_title());
            }
            if(!clip.getClip_title_english().equals("")) {
                c.setClip_title_english(clip.getClip_title_english());
            }
            if(!clip.getClip_image_url().equals("")) {
                c.setClip_image_url(clip.getClip_image_url());
            }
            if(!clip.getCreated_at().equals("")) {
                c.setCreated_at(clip.getCreated_at());
            }
            if(!clip.getDate_of_clip().equals("")) {
                c.setDate_of_clip(clip.getDate_of_clip());
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
            if(!clip.getClip_pages().equals("")) {
            c.setClip_pages(clip.getClip_pages());
            }
            c.setImportant_information(clip.isImportant_information());
            c.setClip_main_page(clip.isClip_main_page());
            c.setClip_image(clip.isClip_image());
            if(!clip.getClip_area().equals("")) {
            c.setClip_area(clip.getClip_area());
            }
            c.setClip_research(clip.getClip_research());
            c.setClip_relevance(clip.getClip_relevance());
            clipPrintedRepository.save(c);
        }
        
       public ClipPrinted findClipPrinted(long id) {
            return this.findAllClipPrinted().stream().filter(t -> t.getClip_printed_id()== id).findFirst().get();
     } 
        
        public void deleteClipPrinted(long id) {
            clipPrintedRepository.deleteById(id);
        } 
}
