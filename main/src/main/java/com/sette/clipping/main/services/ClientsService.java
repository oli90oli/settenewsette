package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Clients;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.ClientsRepository;

@Service
public class ClientsService {
    private final ClientsRepository clientRepository;
       
        @Autowired
        public ClientsService(ClientsRepository clientRepository) {
            this.clientRepository = clientRepository;
        }
        
        public Clients addClients(Clients clients) {
            return clientRepository.save(clients);
        }
        
        public List<Clients> findAllClients() {
            return clientRepository.findAll();
        }
        
        public void updateClients(int id, Clients clients) {
            Clients client = this.findClients(id);
            if(!clients.getClient_name().equals("")) {
                client.setClient_name(clients.getClient_name());
            }
            if(!clients.getClient_email().equals("")) {
                client.setClient_email(clients.getClient_email());
            }
            if(!clients.getClient_bcc().equals("")) {
                client.setClient_bcc(clients.getClient_bcc());
            }
            if(!clients.getClient_password().equals("")) {
                client.setClient_password(clients.getClient_password());
            }
            if(!clients.getClient_username().equals("")) {
                client.setClient_username(clients.getClient_username());
            }
            if(!clients.getMail_title().equals("")) {
                client.setMail_title(clients.getMail_title());
            }
            if(!clients.getPdf_title().equals("")) {
                client.setPdf_title(clients.getPdf_title());
            }
            if(!clients.isFollows_clips()) {
                client.setFollows_clips(clients.isFollows_clips());
            }
            if(!clients.isFollows_analytics()) {
                client.setFollows_analytics(clients.isFollows_analytics());
            }
            if(!clients.isFollows_tenders()) {
                client.setFollows_tenders(clients.isFollows_tenders());
            }
            if(!clients.isFollows_bankruptcies()) {
                client.setFollows_bankruptcies(clients.isFollows_bankruptcies());
            }
            if(!clients.isFollows_sales()) {
                client.setFollows_sales(clients.isFollows_sales());
            }
            if(!clients.isFollows_notifications()) {
                client.setFollows_notifications(clients.isFollows_notifications());
            }
            if(!clients.isIs_latin()) {
                client.setIs_latin(clients.isIs_latin());
            }
            if(!clients.isIs_trial()) {
                client.setIs_trial(clients.isIs_trial());
            }
            if(!clients.isIs_tags()) {
                client.setIs_tags(clients.isIs_tags());
            }
            clientRepository.save(client);
        }
        
        public Clients findClients(int id) {
            return this.findAllClients().stream().filter(t -> t.getClient_id() == id).findFirst().get();
     }
        
        public void deleteClients(int id) {
            clientRepository.deleteById(id);
        }
}
