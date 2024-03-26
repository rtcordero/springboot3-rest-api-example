package com.bezkoder.spring.restapi.application.useCases;

import com.bezkoder.spring.restapi.domain.entities.Tutorial;
import com.bezkoder.spring.restapi.domain.ports.TutorialPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllTutorialsUseCase {

    private final TutorialPort tutorialPort;

    public List<Tutorial> execute(String title) {
        List<Tutorial> tutorials = new ArrayList<>();

        if (title == null) {
            tutorials.addAll(tutorialPort.findAll());
        } else {
            tutorials.addAll(tutorialPort.findByTitleContaining(title));
        }


        return tutorials;
    }
}

