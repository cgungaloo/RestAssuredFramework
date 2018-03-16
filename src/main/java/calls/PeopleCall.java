package calls;

import config.MySharedData;
import cucumber.api.DataTable;
import cucumber.api.junit.Cucumber;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.GetProperties;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PeopleCall extends BaseCall {
    String peopleUrl;

    public PeopleCall() {
        this.peopleUrl = GetProperties.configItems.get("baseUrl")+GetProperties.configItems.get("people");
    }

    public void checkPeopleUrl(){
        assertThat(peopleUrl,is(equalTo("https://swapi.co/api/people/")));
    }

    public ValidatableResponse getPersonFromId(String id){
        Response response = this.makeCall(peopleUrl+id);
        return this.makeValidatedCall(response);
    }

    public void checkResponseForName(String name, ValidatableResponse vr){
        vr.and().body("name",is(equalTo(name)));
    }

    @DataProvider(name="idHeightGenderData")
    public Object[][] createTestDataRecords(){
        return new Object[][]{
                {"1", Arrays.asList("172","male")},
                {"2", Arrays.asList("167","n/a")},
                {"3", Arrays.asList("96","n/a")},
                {"4", Arrays.asList("202","male")},
                {"5", Arrays.asList("49","female")}
        };
    }

    public void testHeightGenderForId(DataTable dt){
        List<List<String>> dtList = dt.raw();
        for(List<String> row: dtList){
            System.out.println(peopleUrl+row.get(0));
            given().when().get(peopleUrl+row.get(0)).then().assertThat().body("height",is(equalTo(row.get(1)))).and().assertThat().body("gender",is(equalTo(row.get(2))));
        }
    }

    public void testFilmUrls(List<String> filmUrls,ValidatableResponse vr){
        int filmIndex =0;
        for (String filmUrl : filmUrls) {
            String path = "films["+filmIndex+"]";
            System.out.println(path);
            String responseurl = vr.and().extract().path(path);
            assertThat(filmUrl, Matchers.is(equalTo(responseurl)));
            filmIndex++;
        }
        MySharedData.vr = vr;
    }
}
