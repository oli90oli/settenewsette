package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Mediums;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.MediumsRepository;

@Service
public class MediumsService {
    
    private final MediumsRepository mediumRepository;
    
    @Autowired
    public MediumsService(MediumsRepository mediumRepository) {
        this.mediumRepository = mediumRepository;
    }
    
    public Mediums addMediums(Mediums mediums) {
            return mediumRepository.save(mediums);
        }
        
    public List<Mediums> findAllMediums() {
            return mediumRepository.findAll();
        }
    public void updateMediums(int id, Mediums mediums) {
            Mediums medium = this.findMedium(id);
            if(!mediums.getMedium_name().equals("")) {
                medium.setMedium_name(mediums.getMedium_name());
            }
            if(!mediums.getMedium_name_cyrilic().equals("")) {
                medium.setMedium_name_cyrilic(mediums.getMedium_name_cyrilic());
            }
            if(mediums.getMedium_type_id() != -1) {
                medium.setMedium_type_id(mediums.getMedium_type_id());
            }
            mediumRepository.save(medium);
        }
        
       public Mediums findMedium(int id) {
            return this.findAllMediums().stream().filter(t -> t.getMedium_id()== id).findFirst().get();
     } 
        
        public void deleteMedium(int id) {
            mediumRepository.deleteById(id);
        }

   /* public List<Mediums> getMediumDataFromInnerJoin(){
        List<Mediums> list = mediumRepository.fetchMediumDataInnerJoin();
        //list.forEach(l -> System.out.println(l));
        return list;
    }*/
}
