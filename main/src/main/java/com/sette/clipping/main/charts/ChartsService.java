package com.sette.clipping.main.charts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChartsService {

    @Autowired
    ChartsRepository chartsRepo;

    public List<ChartsModelMedium> findAllClipsByMedium() {
        return chartsRepo.return_clips_by_medium();
    }

    public List<ChartsModelTag> findAllClipsByTag() { return chartsRepo.return_clips_by_tag();}

    public List<ChartsModelAuthor> findAllClipsByAuthor() {
        return chartsRepo.return_clips_by_author();
    }

    //public List<ChartsModelClipsByDate> findAllClipsByDate() {
//        return chartsRepo.return_clips_by_date();
//    }


}
