package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.ClipGridkeyword;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sette.clipping.main.repositories.ClipGridkeywordRepository;

@RestController
@RequestMapping(value = "/api/clipGridkeyword", method = RequestMethod.GET)
public class ClipGridkeywordController {
    
    @Autowired
    private ClipGridkeywordRepository clipGridkeywordRepository;
        
    @GetMapping("/")
    public Iterable<ClipGridkeyword> findAllClipGridkeyword() { //LIST
        return clipGridkeywordRepository.findAll();
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<ClipGridkeyword> findClipGridkeywordById(@PathVariable(value = "id") int id) {
         Optional<ClipGridkeyword> clip_keyword = clipGridkeywordRepository.findById(id);
 
    if(clip_keyword.isPresent()) {
        return ResponseEntity.ok().body(clip_keyword.get());
    } else {
        return ResponseEntity.notFound().build();
    }
    }
 
    @PostMapping("/save")
    public ClipGridkeyword saveClipGridkeyword(@Validated @RequestBody ClipGridkeyword clip_keyword) {
        return clipGridkeywordRepository.save(clip_keyword);
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteClipGridkeywordById(@PathVariable(value = "id") int id) {
        clipGridkeywordRepository.deleteById(id);
        return "Successfully deleted!";

    }
    
    @PutMapping("/update/{id}")
    ClipGridkeyword updateClipGridkeyword(@RequestBody ClipGridkeyword newClipGridkeyword, @PathVariable int id) {
    return clipGridkeywordRepository.findById(id)
      .map(clipGridkeyword -> {
        clipGridkeyword.setClip_id(newClipGridkeyword.getClip_id());
        clipGridkeyword.setKeyword(newClipGridkeyword.getKeyword());
        return clipGridkeywordRepository.save(clipGridkeyword);
      })
      .orElseGet(() -> {
        newClipGridkeyword.setClip_key_id(id);
        return clipGridkeywordRepository.save(newClipGridkeyword);
      });
  }
}
