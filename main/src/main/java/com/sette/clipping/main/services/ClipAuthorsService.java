package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClipAuthors;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClipAuthorsRepository;

@Service
public class ClipAuthorsService {
    private final ClipAuthorsRepository clipAuthorsRepository;
       
        @Autowired
        public ClipAuthorsService(ClipAuthorsRepository clipAuthorsRepository) {
            this.clipAuthorsRepository = clipAuthorsRepository;
        }
        
        public ClipAuthors addClipAuthors(ClipAuthors clipAuthors) {
            return clipAuthorsRepository.save(clipAuthors);
        }
        
        public List<ClipAuthors> findAllClipAuthors() {
            return clipAuthorsRepository.findAll();
        }
        
        public void updateClipAuthors(int id, ClipAuthors clipAuthors) {
            ClipAuthors clipAuthor = this.findClipAuthors(id);
            if(clipAuthors.getAuthor_id() != -1) {
                clipAuthor.setAuthor_id(clipAuthors.getAuthor_id());
            }
            if(clipAuthors.getClip_id() != -1) {
                clipAuthor.setClip_id(clipAuthors.getClip_id());
            }
            clipAuthorsRepository.save(clipAuthor);
        }
        
        public ClipAuthors findClipAuthors(int id) {
            return this.findAllClipAuthors().stream().filter(t -> t.getClip_author_id() == id).findFirst().get();
     } 
        
        public void deleteClipAuthors(int id) {
            clipAuthorsRepository.deleteById(id);
        } 
}
