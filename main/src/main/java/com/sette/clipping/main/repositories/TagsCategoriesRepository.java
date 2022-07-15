/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sette.clipping.main.repositories;

import com.sette.clipping.main.model.TagsCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsCategoriesRepository extends JpaRepository<TagsCategories, Integer>{

}