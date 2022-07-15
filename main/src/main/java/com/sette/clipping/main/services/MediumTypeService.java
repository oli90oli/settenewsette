package com.sette.clipping.main.services;

import com.sette.clipping.main.model.MediumType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.MediumTypeRepository;

@Service
public class MediumTypeService {
    private final MediumTypeRepository mediumTypeRepository;
       
        @Autowired
        public MediumTypeService(MediumTypeRepository mediumTypeRepository) {
            this.mediumTypeRepository = mediumTypeRepository;
        }
        
        public MediumType addMediumType(MediumType mediumType) {
            return mediumTypeRepository.save(mediumType);
        }
        
        public List<MediumType> findAllMediumType() {
            return mediumTypeRepository.findAll();
        }
        
        public void updateMediumType(int id, MediumType mediumType) {
            MediumType mType = this.findMediumType(id);
            if(!mediumType.getMedium_type_name().equals("")) {
                mType.setMedium_type_name(mediumType.getMedium_type_name());
            }
            mediumTypeRepository.save(mType);
        }
        
       public MediumType findMediumType(int id) {
            return this.findAllMediumType().stream().filter(t -> t.getMedium_type_id()== id).findFirst().get();
     } 
        
        public void deleteMediumType(int id) {
            mediumTypeRepository.deleteById(id);
        } 
}
