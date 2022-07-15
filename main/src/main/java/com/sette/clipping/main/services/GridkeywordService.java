package com.sette.clipping.main.services;

import com.sette.clipping.main.model.Gridkeyword;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sette.clipping.main.repositories.GridkeywordRepository;

@Service
public class GridkeywordService {
    private final GridkeywordRepository gridkeywordRepository;

    @Autowired
    public GridkeywordService(GridkeywordRepository gridkeywordRepository) {
        this.gridkeywordRepository = gridkeywordRepository;
    }

    public Gridkeyword addGridkeywords(Gridkeyword gridkeyword) {
        return gridkeywordRepository.save(gridkeyword);
    }

    public List<Gridkeyword> findAllGridkeywords() {
        return gridkeywordRepository.findAll();
    }

    public Gridkeyword findGridkeyword(int keywordID) {
        return this.findAllGridkeywords().stream().filter(t -> t.getKeyword_id() == keywordID).findFirst().get();
    }

    public void deleteGridkeyword(int keywordID) {
        gridkeywordRepository.deleteById(keywordID);
    }
}
