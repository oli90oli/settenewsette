package com.sette.clipping.main.services;

import com.sette.clipping.main.model.ClientTag;
import com.sette.clipping.main.model.ClipTag;
import com.sette.clipping.main.repositories.ClientTagRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClientTagRepository;
import com.sette.clipping.main.repositories.ClipTagRepository;

@Service
public class ClientTagService {
       private final ClientTagRepository clientTagRepository;
       
        @Autowired
        public ClientTagService(ClientTagRepository clientTagRepository) {
            this.clientTagRepository = clientTagRepository;
        }
        
        public ClientTag addClientTag(ClientTag clientTag) {
            return clientTagRepository.save(clientTag);
        }
        
        public List<ClientTag> findAllClientTag() {
            return clientTagRepository.findAll();
        }
        
        public void updateClientTag(int id, ClientTag clientTag) {
            ClientTag cTag = this.findClientTag(id);
            if(clientTag.getClient_id() != -1) {
                cTag.setClient_id(clientTag.getClient_id());
            }
            if(clientTag.getTag_id()!= -1) {
                cTag.setTag_id(clientTag.getTag_id());
            }
            clientTagRepository.save(cTag);
        }
        
       public ClientTag findClientTag(int id) {
            return this.findAllClientTag().stream().filter(t -> t.getClient_tag_id()== id).findFirst().get();
     } 
        
        public void deleteClientTag(int id) {
            clientTagRepository.deleteById(id);
        } 
}
