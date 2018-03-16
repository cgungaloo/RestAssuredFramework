package calls;

import cucumber.api.DataTable;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;
import utils.GetProperties;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import static io.restassured.RestAssured.given;

public class BaseCall {

    String baseUrl;
    ResponseSpecification checkStatusCodeAndContentType = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

    public BaseCall() {
        this.baseUrl = GetProperties.configItems.get("baseUrl");
    }

    public Response makeCall(String url){
        return given().when().get(url);
    }

    public Response makeBaseCall(){
        return given().when().get(baseUrl);
    }

    public ValidatableResponse makeValidatedCall(Response response){
        return response.then().assertThat().spec(checkStatusCodeAndContentType);
    }

    public void checkUrlBaseResponse(DataTable urls, ValidatableResponse vr) {
        List<List<String>> urltbl = urls.raw();
        for (List<String> row : urltbl) {
            String responseurl = vr.and().extract().path(row.get(0));
            assertThat(responseurl,is(equalTo(row.get(1))));
        }
    }

    public void checkResponseSize(String responseSize, ValidatableResponse vr){
        vr.and().assertThat().body("size()",is(6));
    }
}

