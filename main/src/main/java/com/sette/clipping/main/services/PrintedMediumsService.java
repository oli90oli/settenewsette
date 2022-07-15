package com.sette.clipping.main.services;

import com.sette.clipping.main.model.PrintedMediums;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.PrintedMediumsRepository;

@Service
public class PrintedMediumsService {
    private final PrintedMediumsRepository printedMediumRepository;
       
        @Autowired
        public PrintedMediumsService(PrintedMediumsRepository printedMediumRepository) {
            this.printedMediumRepository = printedMediumRepository;
        }
        
        public PrintedMediums addPrintedMediums(PrintedMediums printedMediums) {
            return printedMediumRepository.save(printedMediums);
        }
        
        public List<PrintedMediums> findAllPrintedMediums() {
            return printedMediumRepository.findAll();
        }
        
        public void updatePrintedMediums(int id, PrintedMediums printedMediums) {
            PrintedMediums printedMedium = this.findPrintedMediums(id);
            if(!printedMediums.getPrinted_mediums_authors().equals("")) {
                printedMedium.setPrinted_mediums_authors(printedMediums.getPrinted_mediums_authors());
            }
            if(!printedMediums.getPrinted_mediums_brief().equals("")) {
                printedMedium.setPrinted_mediums_brief(printedMediums.getPrinted_mediums_brief());
            }
            if(!printedMediums.getPrinted_mediums_cover().equals("")) {
                printedMedium.setPrinted_mediums_cover(printedMediums.getPrinted_mediums_cover());
            }
            if(!printedMediums.getPrinted_mediums_entry_date().equals("")) {
                printedMedium.setPrinted_mediums_entry_date(printedMediums.getPrinted_mediums_entry_date());
            }
            if(!printedMediums.getPrinted_mediums_image().equals("")) {
                printedMedium.setPrinted_mediums_image(printedMediums.getPrinted_mediums_image());
            }
            if(!printedMediums.getPrinted_mediums_image_path().equals("")) {
                printedMedium.setPrinted_mediums_image_path(printedMediums.getPrinted_mediums_image_path());
            }
            if(!printedMediums.getPrinted_mediums_importance().equals("")) {
                printedMedium.setPrinted_mediums_importance(printedMediums.getPrinted_mediums_importance());
            }
            if(!printedMediums.getPrinted_mediums_keywords().equals("")) {
                printedMedium.setPrinted_mediums_keywords(printedMediums.getPrinted_mediums_keywords());
            }
            if(!printedMediums.getPrinted_mediums_name().equals("")) {
                printedMedium.setPrinted_mediums_name(printedMediums.getPrinted_mediums_name());
            }
            if(!printedMediums.getPrinted_mediums_pages().equals("")) {
                printedMedium.setPrinted_mediums_pages(printedMediums.getPrinted_mediums_pages());
            }
            if(!printedMediums.getPrinted_mediums_picture().equals("")) {
                printedMedium.setPrinted_mediums_picture(printedMediums.getPrinted_mediums_picture());
            }
            if(!printedMediums.getPrinted_mediums_release_date().equals("")) {
                printedMedium.setPrinted_mediums_release_date(printedMediums.getPrinted_mediums_release_date());
            }
            if(!printedMediums.getPrinted_mediums_relevance().equals("")) {
                printedMedium.setPrinted_mediums_relevance(printedMediums.getPrinted_mediums_relevance());
            }
            if(!printedMediums.getPrinted_mediums_research().equals("")) {
                printedMedium.setPrinted_mediums_research(printedMediums.getPrinted_mediums_research());
            }
            if(!printedMediums.getPrinted_mediums_surface().equals("")) {
                printedMedium.setPrinted_mediums_surface(printedMediums.getPrinted_mediums_surface());
            }
            if(!printedMediums.getPrinted_mediums_text().equals("")) {
                printedMedium.setPrinted_mediums_text(printedMediums.getPrinted_mediums_text());
            }
            if(!printedMediums.getPrinted_mediums_title().equals("")) {
                printedMedium.setPrinted_mediums_title(printedMediums.getPrinted_mediums_title());
            }
            printedMediumRepository.save(printedMedium);
        }
        
       public PrintedMediums findPrintedMediums(int id) {
            return this.findAllPrintedMediums().stream().filter(t -> t.getPrinted_mediums_id()== id).findFirst().get();
     } 
        
        public void deletePrintedMedium(int id) {
            printedMediumRepository.deleteById(id);
        } 
}
