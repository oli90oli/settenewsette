package com.sette.clipping.main.functions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/func")
public class FunctionsController {
    @Autowired
    FunctionsService funcService;

    @GetMapping(value = "/fun_mediums")
    public List<FunctionsMediumModel> fun_mediums() {return funcService.funcMedium();}
    
    @GetMapping(value = "/fun_tags")
    public List<FunctionsTagModel> fun_tags() {return funcService.funcTags();}
    
    @GetMapping(value = "/fun_clients")
    public List<FunctionsClientModel> fun_clients() {return funcService.funcClients();}
    
    @GetMapping(value = "/fun_clips")
    public List<FunctionsClipModel> fun_clips() {return funcService.funcClips();}
    
    @GetMapping(value = "/fun_clips_printed")
    public List<FunctionsClipPrintedModel> fun_clips_printed() {return funcService.funcClipsPrinted();}
}
