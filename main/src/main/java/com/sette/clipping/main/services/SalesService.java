package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Authors;
import com.sette.clipping.main.model.Sales;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.SalesRepository;

@Service
public class SalesService {
    
    private final SalesRepository saleRepository;
    
    @Autowired
    public SalesService(SalesRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    
    public Sales addSales(Sales sales) {
            return saleRepository.save(sales);
        }
        
    public List<Sales> findAllSales() {
            return saleRepository.findAll();
        }
        
    public void updateSales(int id, Sales sales) {
            Sales sale = this.findSales(id);
            if (!sales.getSales_creditor().equals("")){
            sale.setSales_creditor(sales.getSales_creditor());
            }
            if (!sales.getSales_debtor().equals("")) {
            sale.setSales_debtor(sales.getSales_debtor());
            }
            if (!sales.getSales_place().equals("")){
            sale.setSales_place(sales.getSales_place());
            }
            sale.setSales_esale(sales.isSales_esale());
            if (!sales.getSales_url().equals("")){
            sale.setSales_url(sales.getSales_url());
            }
            if (!sales.getSales_image().equals("")){
            sale.setSales_image(sales.getSales_image());
            }
            if (!sales.getSales_description().equals("")){
            sale.setSales_description(sales.getSales_description());
            }
            if (!sales.getSales_type().equals("")){
            sale.setSales_type(sales.getSales_type());
            }
            if (!sales.getSales_date().equals("")){
            sale.setSales_date(sales.getSales_date());
            }
            if (!sales.getSales_expire().equals("")){
            sale.setSales_expire(sales.getSales_expire());
            }
            saleRepository.save(sale);
    }

       public Sales findSales(int id) {
            return this.findAllSales().stream().filter(t -> t.getSales_id()== id).findFirst().get();
     } 
        
        public void deleteSales(int id) {
            saleRepository.deleteById(id);
        } 
}
