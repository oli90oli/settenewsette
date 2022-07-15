package com.sette.clipping.main.charts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class ChartsController {

    @Autowired
    ChartsService chartsService;

    @GetMapping(value = "/clips_by_medium_procedure")
    public List<ChartsModelMedium> return_clips_by_medium() {
        return chartsService.findAllClipsByMedium();
    }

    @GetMapping(value = "/clips_by_tag_procedure")
    public List<ChartsModelTag> return_clips_by_tag() {return chartsService.findAllClipsByTag();}

    @GetMapping(value = "/clips_by_author_procedure")
    public List<ChartsModelAuthor> return_clips_by_author() {
        return chartsService.findAllClipsByAuthor();
    }

//    @GetMapping(value = "/clips_by_date_procedure")
//    public List<ChartsModelClipsByDate> return_clips_by_date() {
//        return chartsService.findAllClipsByDate();
//    }
}
