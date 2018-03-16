package steps;

import calls.FilmCall;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import sun.text.resources.iw.FormatData_iw_IL;

public class filmSteps {
    FilmCall fc;
    @And("^I should be taken to be taken to \"([^\"]*)\" with entry \"([^\"]*)\"$")
    public void iShouldBeTakenToBeTakenToWithEntry(String film, String filmurl){
        fc = new FilmCall();
        System.out.println(film + " " + filmurl);
        fc.checkFilmUrl(film,filmurl);
    }
}
