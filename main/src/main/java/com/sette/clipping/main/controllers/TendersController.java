package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Tenders;
import com.sette.clipping.main.services.TendersService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenders")
public class TendersController {
    private final TendersService tenderService;
    
    public TendersController(TendersService tenderService){
        this.tenderService = tenderService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Tenders>> getAllTenders() {
        List<Tenders> tenders = tenderService.findAllTenders();
        return new ResponseEntity<>(tenders, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Tenders> getTendersByID(@PathVariable("id") int id) {
        Tenders tender = tenderService.findTender(id);
        return new ResponseEntity<>(tender, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Tenders> addTenders(@RequestBody Tenders tender) {
        Tenders newTender = tenderService.addTenders(tender);
        return new ResponseEntity<>(newTender, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateTenders(@PathVariable int id, @RequestBody Tenders tender){
        tenderService.updateTenders(id, tender);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTendersByID(@PathVariable("id") int id) {
        tenderService.deleteTender(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
