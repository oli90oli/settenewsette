package com.sette.clipping.main.charts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/charts")
public class ClipsByDateController {

        @Autowired
        ClipsByDateService clipsByDateService;

        @GetMapping(value = "/clips_by_date_procedure")
        public List<ChartsModelClipsByDate> return_clips_by_date() {
            return clipsByDateService.findAllClipsByDate();
        }


}
