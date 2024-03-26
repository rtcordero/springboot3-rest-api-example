package fixtures;

import com.bezkoder.spring.restapi.domain.entities.Tutorial;

public class TutorialFixture {

    static public Tutorial random() {
        return new Tutorial("", "", false);
    }
}
