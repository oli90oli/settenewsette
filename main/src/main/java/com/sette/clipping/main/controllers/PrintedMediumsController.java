package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.PrintedMediums;
import com.sette.clipping.main.services.PrintedMediumsService;
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
@RequestMapping("/printedMediums")
public class PrintedMediumsController {
    
    private final PrintedMediumsService printedMediumService;
    public PrintedMediumsController(PrintedMediumsService printedMediumService){
        this.printedMediumService = printedMediumService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<PrintedMediums>> getAllPrintedMediums() {
        List<PrintedMediums> printedMediums = printedMediumService.findAllPrintedMediums();
        return new ResponseEntity<>(printedMediums, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<PrintedMediums> getPrintedMediumsByID(@PathVariable("id") int id) {
        PrintedMediums printedMediums = printedMediumService.findPrintedMediums(id);
        return new ResponseEntity<>(printedMediums, HttpStatus.OK);
    }  
 
    @PostMapping("/add")
    public ResponseEntity<PrintedMediums> addPrintedMediums(@RequestBody PrintedMediums printedMediums) {
        PrintedMediums newPrintedMedium = printedMediumService.addPrintedMediums(printedMediums);
        return new ResponseEntity<>(newPrintedMedium, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updatePrintedMediums(@PathVariable int id, @RequestBody PrintedMediums printedMedium){
        printedMediumService.updatePrintedMediums(id, printedMedium);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrintedMediumsByID(@PathVariable("id") int id) {
        printedMediumService.deletePrintedMedium(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
