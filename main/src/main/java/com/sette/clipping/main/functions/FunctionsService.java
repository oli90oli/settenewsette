package com.sette.clipping.main.functions;

import com.sette.clipping.main.charts.ChartsModelMedium;
import com.sette.clipping.main.charts.ChartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionsService {

    @Autowired
    FunctionsRepository funcRepo;

    public List<FunctionsMediumModel> funcMedium() {
        return funcRepo.fun_mediums();
    }

    public List<FunctionsTagModel> funcTags() {
        return funcRepo.fun_tags();
    }
    
    public List<FunctionsClientModel> funcClients() {
        return funcRepo.fun_clients();
    }
    
    public List<FunctionsClipModel> funcClips() {
        return funcRepo.fun_clips();
    }
    
    public List<FunctionsClipPrintedModel> funcClipsPrinted() {
        return funcRepo.fun_clips_printed();
    }
}
