package com.bezkoder.spring.restapi.e2e;

import com.bezkoder.spring.restapi.controller.TutorialController;
import com.bezkoder.spring.restapi.model.Tutorial;
import com.bezkoder.spring.restapi.service.TutorialService;
import fixtures.TutorialFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TutorialController.class)
public class TutorialControllerTest {


    @Autowired
    private MockMvc mvc;

    @SpyBean
    private TutorialService tutorialService;

    @BeforeEach
    public void setup() {
        resetData();
    }


    @Test
    public void getAllTutorialsAPI() throws Exception {
        //Given
        var tutorial = givenATutorialService();

        //When
        var result = mvc.perform(MockMvcRequestBuilders
                .get("/api/tutorials")
                .accept(MediaType.APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk());

        //Verify
        //TODO Verify responseBody is the same as FirstTutorial
    }

    @Test
    public void getTutorialsAPI() throws Exception {
        //Given
        var tutorial = givenATutorialService();
        var tutorialId = tutorial.getId();

        //When
        var result = mvc.perform(MockMvcRequestBuilders
                .get("/api/tutorials/" + tutorialId)
                .accept(MediaType.APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk());

        //Verify
        //TODO Verify responseBody is the same as FirstTutorial
    }

    private void resetData() {
        tutorialService.deleteAll();
    }

    private Tutorial givenATutorialService() {
        return tutorialService.save(TutorialFixture.random());
    }
}