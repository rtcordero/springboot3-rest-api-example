package com.bezkoder.spring.restapi.infrastructure.adapters;

import com.bezkoder.spring.restapi.domain.entities.Tutorial;
import com.bezkoder.spring.restapi.domain.ports.TutorialPort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TutorialAdapter implements TutorialPort {
    static List<Tutorial> tutorials = new ArrayList<>();
    static long id = 0;

    @Override
    public List<Tutorial> findAll() {
        return tutorials;
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorials.stream().filter(tutorial -> tutorial.getTitle().contains(title)).toList();
    }

    @Override
    public Tutorial findById(long id) {
        return tutorials.stream().filter(tutorial -> id == tutorial.getId()).findAny().orElse(null);
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        // update Tutorial
        if (tutorial.getId() != 0) {
            long _id = tutorial.getId();

            for (int idx = 0; idx < tutorials.size(); idx++)
                if (_id == tutorials.get(idx).getId()) {
                    tutorials.set(idx, tutorial);
                    break;
                }

            return tutorial;
        }

        // create new Tutorial
        tutorial.setId(++id);
        tutorials.add(tutorial);
        return tutorial;
    }

    @Override
    public void deleteById(long id) {
        tutorials.removeIf(tutorial -> id == tutorial.getId());
    }

    @Override
    public void deleteAll() {
        tutorials.removeAll(tutorials);
    }

    @Override
    public List<Tutorial> findByPublished(boolean isPublished) {
        return tutorials.stream().filter(tutorial -> isPublished == tutorial.isPublished()).toList();
    }
}
