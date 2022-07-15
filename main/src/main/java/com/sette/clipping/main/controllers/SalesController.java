package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Sales;
import com.sette.clipping.main.services.SalesService;
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
@RequestMapping("/sales")
public class SalesController {
    
    private  final SalesService saleService;
    public SalesController(SalesService saleService) {
        this.saleService = saleService;
    }
        
    @GetMapping("/all")
    public ResponseEntity<List<Sales>> getAllSales() {
        List<Sales> sales = saleService.findAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesByID(@PathVariable("id") int id) {
        Sales sale = saleService.findSales(id);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    } 
 
    @PostMapping("/add")
    public ResponseEntity<Sales> addSales(@RequestBody Sales sale) {
        Sales newSale = saleService.addSales(sale);
        return new ResponseEntity<>(newSale, HttpStatus.CREATED);
    }
    
    @PutMapping("/update/{id}")
    public void updateSales(@PathVariable int id, @RequestBody Sales sale){
        saleService.updateSales(id, sale);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSalesByID(@PathVariable("id") int id) {
        saleService.deleteSales(id);
        return new ResponseEntity<>(HttpStatus.OK);
    } 
}
