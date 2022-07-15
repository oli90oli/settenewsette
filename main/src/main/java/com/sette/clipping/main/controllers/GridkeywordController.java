package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Gridkeyword;
import com.sette.clipping.main.services.GridkeywordService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keywords")
public class GridkeywordController {

    private final GridkeywordService gridkeywordService;
    public GridkeywordController(GridkeywordService gridkeywordService){
        this.gridkeywordService = gridkeywordService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Gridkeyword>> getAllGridkeywords() {
        List<Gridkeyword> keywords = gridkeywordService.findAllGridkeywords();
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gridkeyword> getGridkeywordsByID(@PathVariable("id") int keywordID) {
        Gridkeyword keywords = gridkeywordService.findGridkeyword(keywordID);
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Gridkeyword> addGridkeywords(@RequestBody Gridkeyword keyword) {
        Gridkeyword newKeyword = gridkeywordService.addGridkeywords(keyword);
        return new ResponseEntity<>(newKeyword, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGridkeywordsByID(@PathVariable("id") int keywordID) {
        gridkeywordService.deleteGridkeyword(keywordID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}