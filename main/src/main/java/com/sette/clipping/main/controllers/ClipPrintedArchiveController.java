package com.sette.clipping.main.controllers;


import com.sette.clipping.main.model.ClipPrintedArchive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import com.sette.clipping.main.repositories.ClipPrintedArchiveRepository;

@RestController
@RequestMapping(value = "/api/clipPrintedArchive", method = RequestMethod.GET)
public class ClipPrintedArchiveController {
    @Autowired
    private ClipPrintedArchiveRepository clipPrintedArchiveRepository;

    @GetMapping("/")
    public Iterable<ClipPrintedArchive> findAllClipPrintedArchive() {
        return clipPrintedArchiveRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClipPrintedArchive> findClipPrintedArchiveById(@PathVariable(value = "id") int id) {
        Optional<ClipPrintedArchive> clip_printed_archive = clipPrintedArchiveRepository.findById(id);

        if(clip_printed_archive.isPresent()) {
            return ResponseEntity.ok().body(clip_printed_archive.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ClipPrintedArchive saveClipPrintedArchive(@Validated @RequestBody ClipPrintedArchive clip_printed_archive) {
        return clipPrintedArchiveRepository.save(clip_printed_archive);
    }

    @DeleteMapping("delete/{id}")
    public String deleteClipPrintedArchiveById(@PathVariable(value = "id") int id) {
        clipPrintedArchiveRepository.deleteById(id);
        return "Successfully deleted!";
    }

    @PutMapping("/update/{id}")
    ClipPrintedArchive updateClipPrintedArchive(@RequestBody ClipPrintedArchive newClipPrintedArchive, @PathVariable int id) {
        return clipPrintedArchiveRepository.findById(id)
                .map(clipPrintedArchive -> {
                    clipPrintedArchive.setClip_text(newClipPrintedArchive.getClip_text());
                    clipPrintedArchive.setClip_archive_id(newClipPrintedArchive.getClip_archive_id());
                    clipPrintedArchive.setImage(newClipPrintedArchive.getImage());
                    clipPrintedArchive.setPage(newClipPrintedArchive.getPage());
                    clipPrintedArchive.setPrinted_brief(newClipPrintedArchive.getPrinted_brief());
                    return clipPrintedArchiveRepository.save(clipPrintedArchive);
                })
                .orElseGet(() -> {
                    newClipPrintedArchive.setClip_printed_archive_id(id);
                    return clipPrintedArchiveRepository.save(newClipPrintedArchive);
                });
    }

}
