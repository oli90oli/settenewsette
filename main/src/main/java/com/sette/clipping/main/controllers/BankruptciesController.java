package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Bankruptcies;
import com.sette.clipping.main.services.BankruptciesService;
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
@RequestMapping("/bankruptcies")
public class BankruptciesController {
    private  final BankruptciesService bankruptcyService;
    public BankruptciesController(BankruptciesService bankruptcyService) {
        this.bankruptcyService = bankruptcyService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Bankruptcies>> getAllBankruptcies() {
        List<Bankruptcies> bankruptcies = bankruptcyService.findAllBankruptcies();
        return new ResponseEntity<>(bankruptcies, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Bankruptcies> getBankruptcyByID(@PathVariable("id") int id) {
        Bankruptcies bankruptcy = bankruptcyService.findBankruptcy(id);
        return new ResponseEntity<>(bankruptcy, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Bankruptcies> addBankruptcy(@RequestBody Bankruptcies bankruptcy) {
        Bankruptcies newBankruptcy = bankruptcyService.addBankruptcies(bankruptcy);
        return new ResponseEntity<>(newBankruptcy, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateBankruptcies(@PathVariable int id, @RequestBody Bankruptcies bankruptcy){
        bankruptcyService.updateBankruptcies(id, bankruptcy);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBankruptcyByID(@PathVariable("id") int id) {
        bankruptcyService.deleteBankruptcy(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
