package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Tenders;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.TendersRepository;

@Service
public class TendersService {
    private final TendersRepository tenderRepository;
    
    @Autowired
    public TendersService(TendersRepository tenderRepository) {
        this.tenderRepository = tenderRepository;
    }
    
    public Tenders addTenders(Tenders tenders) {
            return tenderRepository.save(tenders);
        }
        
    public List<Tenders> findAllTenders() {
            return tenderRepository.findAll();
        }
        
    public void updateTenders(int id, Tenders tenders) {
            Tenders tender = this.findTender(id);
            if (!tenders.getTender_type().equals("")){
            tender.setTender_type(tenders.getTender_type());
            }
            if (!tenders.getTender_medium().equals("")){
            tender.setTender_medium(tenders.getTender_medium());
            }
            if (!tenders.getTender_publisher().equals("")) {
            tender.setTender_publisher(tenders.getTender_publisher());
            }
            if (!tenders.getTender_subject().equals("")) {
            tender.setTender_subject(tenders.getTender_subject());
            }
            if (!tenders.getTender_description().equals("")){
            tender.setTender_description(tenders.getTender_description());
            }
            if (!tenders.getTender_url().equals("")) {
            tender.setTender_url(tenders.getTender_url());
            }
            if (!tenders.getTender_date().equals("")){
            tender.setTender_date(tenders.getTender_date());
            }
            if (!tenders.getTender_expire().equals("")) {
            tender.setTender_expire(tenders.getTender_expire());
            }
            tenderRepository.save(tender);
    }

       public Tenders findTender(int id) {
            return this.findAllTenders().stream().filter(t -> t.getTender_id()== id).findFirst().get();
     } 
        
        public void deleteTender(int id) {
            tenderRepository.deleteById(id);
        } 
}
