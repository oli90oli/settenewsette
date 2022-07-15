package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.ClipArchive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import com.sette.clipping.main.repositories.ClipArchiveRepository;

@RestController
@RequestMapping(value = "/api/clipArchive", method = RequestMethod.GET)
public class ClipArchiveController {

    @Autowired
    private ClipArchiveRepository clipArchiveRepository;

    @GetMapping("/")
    public Iterable<ClipArchive> findAllClipArchive() { //LIST
        return clipArchiveRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClipArchive> findClipArchiveById(@PathVariable(value = "id") int id) {
        Optional<ClipArchive> clip_archive = clipArchiveRepository.findById(id);

        if(clip_archive.isPresent()) {
            return ResponseEntity.ok().body(clip_archive.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ClipArchive saveClipArchive(@Validated @RequestBody ClipArchive clip_archive) {
        return clipArchiveRepository.save(clip_archive);
    }

    @DeleteMapping("delete/{id}")
    public String deleteClipArchiveById(@PathVariable(value = "id") int id) {
        clipArchiveRepository.deleteById(id);
        return "Successfully deleted!";

    }

    @PutMapping("/update/{id}")
    ClipArchive updateClipArchive(@RequestBody ClipArchive newClipArchive, @PathVariable int id) {
        return clipArchiveRepository.findById(id)
                .map(clipArchive -> {
                    clipArchive.setBrief(newClipArchive.getBrief());
                    clipArchive.setClip_text(newClipArchive.getClip_text());
                    clipArchive.setClip_title(newClipArchive.getClip_title());
                    clipArchive.setClip_url(newClipArchive.getClip_url());
                    clipArchive.setCreated_at(newClipArchive.getCreated_at());
                    clipArchive.setDate_of_clip(newClipArchive.getDate_of_clip());
                    clipArchive.setImportant_information(newClipArchive.getImportant_information());
                    clipArchive.setMedium_id(newClipArchive.getMedium_id());
                    return clipArchiveRepository.save(clipArchive);
                })
                .orElseGet(() -> {
                    newClipArchive.setClip_archive_id(id);
                    return clipArchiveRepository.save(newClipArchive);
                });
    }
}
