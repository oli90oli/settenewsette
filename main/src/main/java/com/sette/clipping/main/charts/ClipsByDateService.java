package com.sette.clipping.main.charts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClipsByDateService {

    @Autowired
    ClipsByDateRepository clipsByDateRepo;

    public List<ChartsModelClipsByDate> findAllClipsByDate() {
        return clipsByDateRepo.return_clips_by_date();
    }

}
