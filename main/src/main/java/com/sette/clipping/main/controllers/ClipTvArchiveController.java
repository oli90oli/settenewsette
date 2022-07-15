package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.ClipTvArchive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import com.sette.clipping.main.repositories.ClipTvArchiveRepository;

@RestController
@RequestMapping(value = "/api/clipTvArchive", method = RequestMethod.GET)
public class ClipTvArchiveController {

    @Autowired
    private ClipTvArchiveRepository clipTvArchiveRepository;

    @GetMapping("/")
    public Iterable<ClipTvArchive> findAllClipTvArchive() { return clipTvArchiveRepository.findAll();}

    @GetMapping("/{id}")
    public ResponseEntity<ClipTvArchive> findClipTvArchiveById(@PathVariable(value = "id") int id) {
        Optional<ClipTvArchive> clip_tv_archive = clipTvArchiveRepository.findById(id);

        if(clip_tv_archive.isPresent()) {
            return ResponseEntity.ok().body(clip_tv_archive.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ClipTvArchive saveClipTvArchive(@Validated @RequestBody ClipTvArchive clip_tv_archive) {
        return clipTvArchiveRepository.save(clip_tv_archive);
    }

    @DeleteMapping("delete/{id}")
    public String deleteClipTvArchiveById(@PathVariable(value = "id") int id) {
        clipTvArchiveRepository.deleteById(id);
        return "Successfully deleted!";
    }

    @PutMapping("/update/{id}")
    ClipTvArchive updateClipTvArchive(@RequestBody ClipTvArchive newClipTvArchive, @PathVariable int id) {
        return clipTvArchiveRepository.findById(id)
                .map(clipTvArchive -> {
                    clipTvArchive.setClip_tv_brief(newClipTvArchive.getClip_tv_brief());
                    clipTvArchive.setClip_archive_id(newClipTvArchive.getClip_archive_id());
                    clipTvArchive.setClip_tv_text(newClipTvArchive.getClip_tv_text());
                    return clipTvArchiveRepository.save(clipTvArchive);
                })
                .orElseGet(() -> {
                    newClipTvArchive.setClip_tv_archive_id(id);
                    return clipTvArchiveRepository.save(newClipTvArchive);
                });
    }
}
