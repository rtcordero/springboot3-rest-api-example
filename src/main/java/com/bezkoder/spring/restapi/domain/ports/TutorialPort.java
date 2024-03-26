package com.bezkoder.spring.restapi.domain.ports;

import com.bezkoder.spring.restapi.domain.entities.Tutorial;

import java.util.List;

public interface TutorialPort {

    List<Tutorial> findAll();

    List<Tutorial> findByTitleContaining(String title);

    Tutorial findById(long id);

    Tutorial save(Tutorial tutorial);

    void deleteById(long id);

    void deleteAll();

    List<Tutorial> findByPublished(boolean isPublished);
}
