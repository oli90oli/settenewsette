package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Authors;
import com.sette.clipping.main.model.Bankruptcies;
import java.util.List;

import com.sette.clipping.main.repositories.BankruptciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ackovski
 */
@Service
public class BankruptciesService {
    private final BankruptciesRepository bankruptcyRepository;
    
    @Autowired
    public BankruptciesService(BankruptciesRepository bankruptcyRepository) {
        this.bankruptcyRepository = bankruptcyRepository;
    }
    
    public Bankruptcies addBankruptcies(Bankruptcies bankruptcies) {
            return bankruptcyRepository.save(bankruptcies);
        }
        
    public List<Bankruptcies> findAllBankruptcies() {
            return bankruptcyRepository.findAll();
        }
        
    public void updateBankruptcies(int id, Bankruptcies bankruptcies) {
            Bankruptcies bankruptcy = this.findBankruptcy(id);
            if (!bankruptcies.getBankruptcy_name().equals("")){
            bankruptcy.setBankruptcy_name(bankruptcies.getBankruptcy_name());
            }
            if (bankruptcies.getBankruptcy_embs() == -1) {
            bankruptcy.setBankruptcy_embs(bankruptcies.getBankruptcy_embs());
            }
            if (!bankruptcies.getBankruptcy_url().equals("")){
            bankruptcy.setBankruptcy_url(bankruptcies.getBankruptcy_url());
            }
            if (!bankruptcies.getBankruptcy_image().equals("")){
            bankruptcy.setBankruptcy_image(bankruptcies.getBankruptcy_image());
            }
            if (!bankruptcies.getBankruptcy_description().equals("")){
            bankruptcy.setBankruptcy_description(bankruptcies.getBankruptcy_description());
            }
            if (!bankruptcies.getBankruptcy_phase().equals("")){
            bankruptcy.setBankruptcy_phase(bankruptcies.getBankruptcy_phase());
            }
            if (!bankruptcies.getBankruptcy_date().equals("")){
            bankruptcy.setBankruptcy_date(bankruptcies.getBankruptcy_date());
            }
            bankruptcyRepository.save(bankruptcy);
    }

       public Bankruptcies findBankruptcy(int id) {
            return this.findAllBankruptcies().stream().filter(t -> t.getBankruptcy_id()== id).findFirst().get();
     } 
        
        public void deleteBankruptcy(int id) {
            bankruptcyRepository.deleteById(id);
        } 
}
