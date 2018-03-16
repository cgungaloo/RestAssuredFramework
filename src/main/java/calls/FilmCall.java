package calls;

import config.MySharedData;
import io.restassured.response.ValidatableResponse;
import utils.GetProperties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class FilmCall extends BaseCall {

    String filmUrl;

    public FilmCall() {
        this.filmUrl = GetProperties.configItems.get("baseUrl")+GetProperties.configItems.get("films");
    }

    public void checkFilmUrl(String film, String filmurl){

        String filmUrlBreaks[] =filmurl.split("/");
        String entryIndex = filmUrlBreaks[filmUrlBreaks.length -1];
        System.out.println("Calling " + filmUrl + entryIndex);
        ValidatableResponse vr = MySharedData.vr;
        given().pathParam("filmId",entryIndex).when().get(filmUrl+"{filmId}").then().assertThat().body("title",is(equalTo(film)));

    }
}
