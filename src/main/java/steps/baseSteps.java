package steps;

import calls.BaseCall;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.Response;

public class baseSteps {
    ValidatableResponse vr;
    BaseCall bc;
    @Given ("^I make make a base call$")
    public void iMakeABaseCall(){
        bc = new BaseCall();
        Response response = bc.makeBaseCall();
        vr= bc.makeValidatedCall(response);
    }

    @Then("^I should get the following url responses:$")
    public void iShouldGetTheFollowingUrlResponses(DataTable urlTbl){
        bc.checkUrlBaseResponse(urlTbl,vr);
    }

    @And("^the size of the response is \"([^\"]*)\"$")
    public void theSizeOfTheResponseIs(String responseSize){
        bc.checkResponseSize(responseSize,vr);
    }
}
