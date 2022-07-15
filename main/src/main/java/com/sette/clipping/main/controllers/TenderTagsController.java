package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.TenderTags;
import com.sette.clipping.main.services.TenderTagsService;
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
@RequestMapping("/tender-tags")
public class TenderTagsController {

    private final TenderTagsService tenderTagsService;
    public TenderTagsController(TenderTagsService tenderTagsService){
        this.tenderTagsService = tenderTagsService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<TenderTags>> getAllTenderTags() {
        List<TenderTags> tenderTag = tenderTagsService.findAllTenderTags();
        return new ResponseEntity<>(tenderTag, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenderTags> getTenderTagByID(@PathVariable("id") int id) {
        TenderTags tenderTag = tenderTagsService.findTenderTag(id);
        return new ResponseEntity<>(tenderTag, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TenderTags> addTenderTag(@RequestBody TenderTags tenderTag) {
        TenderTags newTenderTag = tenderTagsService.addTenderTag(tenderTag);
        return new ResponseEntity<>(newTenderTag, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public void updateTenderTag(@PathVariable int id, @RequestBody TenderTags tenderTag){
        tenderTagsService.updateTenderTag(id, tenderTag);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTenderTagByID(@PathVariable("id") int id) {
        tenderTagsService.deleteTenderTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
