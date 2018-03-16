package steps;
import calls.PeopleCall;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.ValidatableResponse;

import java.util.List;

public class peopleSteps {

    PeopleCall pc;
    ValidatableResponse vr;
    Object[][] chrData;
    @Given("^I make a people call for \"([^\"]*)\"$")
    public void iMakePeopleCallforCharacter(String id){
        pc = new PeopleCall();
        vr = pc.getPersonFromId(id);
    };

    @Then("^I should see \"([^\"]*)\" in the name response$")
    public void iShouldSeeInTheNameResponse(String name){
        pc.checkResponseForName(name,vr);
    }

    @Given("^the people url is correct$")
    public void iCheckPeopleUrl(){
        pc = new PeopleCall();
        pc.checkPeopleUrl();
    }

    @Then("^following ids for height and gender should be correct:$")
    public void thePeopleCallsShouldReturnTheCorrectHeightsAndGenders(DataTable dt){
        pc.testHeightGenderForId(dt);
    }

    @Then("^I should get the following film responses:$")
    public void iShouldGetTheFollowingFilmResponses(List<String> filmUrls){
        pc.testFilmUrls(filmUrls,vr);
    }
}
