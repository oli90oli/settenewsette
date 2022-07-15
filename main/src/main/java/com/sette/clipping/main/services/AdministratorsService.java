
package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Administrators;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.AdministratorsRepository;

@Service
public class AdministratorsService {
        private final AdministratorsRepository adminRepository;
       
        @Autowired
        public AdministratorsService(AdministratorsRepository adminRepository) {
            this.adminRepository = adminRepository;
        }
        
        public Administrators addAdministrators(Administrators administrators) {
            return adminRepository.save(administrators);
        }
        
        public List<Administrators> findAllAdministrators() {
            return adminRepository.findAll();
        }
        
        public void updateAdministrators(int id, Administrators administrators) {
            Administrators administrator = this.findAdministrator(id);
            if(!administrators.getAdministrator_username().equals("")) {
                administrator.setAdministrator_username(administrators.getAdministrator_username());
            }
            if(!administrators.getAdministrator_password().equals("")) {
                administrator.setAdministrator_password(administrators.getAdministrator_password());
            }
            if(administrators.getRole_id() != -1) {
                administrator.setRole_id(administrators.getRole_id());
            }
            adminRepository.save(administrator);
        }
        
        public Administrators findAdministrator(int id) {
            return this.findAllAdministrators().stream().filter(t -> t.getAdmin_id() == id).findFirst().get();
     }
        
        public void deleteAdministrator(int id) {
            adminRepository.deleteById(id);
        } 
}
