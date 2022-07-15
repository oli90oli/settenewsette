package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Roles;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.RolesRepository;

@Service
public class RolesService {
    private final RolesRepository roleRepository;
       
        @Autowired
        public RolesService(RolesRepository roleRepository) {
            this.roleRepository = roleRepository;
        }
        
        public Roles addRoles(Roles roles) {
            return roleRepository.save(roles);
        }
        
        public List<Roles> findAllRoles() {
            return roleRepository.findAll();
        }
        
        public void updateRoles(int id, Roles roles) {
            Roles role = this.findRoles(id);
            if(!roles.getName_of_role().equals("")) {
                role.setName_of_role(roles.getName_of_role());
            }
            roleRepository.save(role);
        }
        
        public Roles findRoles(int id) {
            return this.findAllRoles().stream().filter(t -> t.getRole_id()== id).findFirst().get();
     } 
        
        public void deleteRole(int id) {
            roleRepository.deleteById(id);
        }  
}
