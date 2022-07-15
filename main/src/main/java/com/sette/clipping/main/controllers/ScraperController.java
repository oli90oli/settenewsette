package com.sette.clipping.main.controllers;

import com.sette.clipping.main.model.Gridkeyword;
import com.sette.clipping.main.services.ScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("cluster/new")
public class ScraperController {

    @Autowired
    private ScraperService scraperService;

    @PersistenceUnit
    EntityManagerFactory emf;

    @PostMapping
    public ResponseEntity parseNews(@PathVariable("url") String url,
                                    @RequestParam("tags") String tags) {

        return scraperService.getAllArticles(url, tags, null);
    }


    @GetMapping("search-keywords/{limit}")
    public List<Gridkeyword> searchAndImportClip(@PathVariable("limit") Integer limit) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Gridkeyword> criteria = builder.createQuery(Gridkeyword.class);
        Root<Gridkeyword> keywordsRoot = criteria.from(Gridkeyword.class);
        criteria.select(keywordsRoot);
        List<Gridkeyword> keywords = em.createQuery(criteria).setFirstResult(limit * 10).setMaxResults(10).getResultList();

        for (Gridkeyword keyword : keywords) {
            DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            String today = formatter.format(new Date());

            String k = keyword.getKeyword();
            System.out.println("keyword: " + k);
            try {
                //keyword.getTagIds() go zameniv so "1"
                scraperService.getAllArticles("https://grid.mk/search?q=" + URLEncoder.encode(k, "UTF-8") + "&beg=" + today + "&end=" + today, "1", em);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        em.close();
        return keywords;
    }
}




