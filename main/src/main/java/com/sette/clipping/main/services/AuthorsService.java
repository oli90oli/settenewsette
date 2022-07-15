package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Authors;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.AuthorsRepository;

@Service
public class AuthorsService {
     
    private final AuthorsRepository authorRepository;
    
    @Autowired
    public AuthorsService(AuthorsRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public Authors addAuthors(Authors authors) {
            return authorRepository.save(authors);
        }
        
    public List<Authors> findAllAuthors() {
            return authorRepository.findAll();
        }
        
    public void updateAuthors(int id, Authors authors) {
            Authors author = this.findAuthor(id);
            if (!authors.getFull_name_c().equals("")){
            author.setFull_name_c(authors.getFull_name_c());
            }
            if (!authors.getFull_name_l().equals("")) {
            author.setFull_name_l(authors.getFull_name_l());
            }
            authorRepository.save(author);
    }

       public Authors findAuthor(int id) {
            return this.findAllAuthors().stream().filter(t -> t.getAuthor_id() == id).findFirst().get();
     } 
        
        public void deleteAuthor(int id) {
            authorRepository.deleteById(id);
        } 
}
