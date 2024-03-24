package fixtures;

import com.bezkoder.spring.restapi.model.Tutorial;

public class TutorialFixture {

    static public Tutorial random(){
        return new Tutorial("","",false);
    }
}
