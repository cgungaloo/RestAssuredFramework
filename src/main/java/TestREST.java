import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestREST {
    @Test
    public void test_NumberOfCircuitsForSeason_ShouldBe20(){

        given().
                when()
                .get("http://ergast.com/api/f1/2017/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }

    @Test
    public void test_ResponseHeaderData_ShouldBeCorrect(){
        given().when().get("http://ergast.com/api/f1/2017/circuits.json").then()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().header("Content-Length",equalTo("4551"));
    }

    @Test
    public void test_QueryShouldBeCorrect(){
        String originalText ="test";
        String expectedMd5CheckSum = "098f6bcd4621d373cade4e832627b4f6";

        given().param("text",originalText).when().get("http://md5.jsontest.com")
                .then().assertThat().body("md5",equalTo(expectedMd5CheckSum));
    }

    @Test
    public void test_PathParamShouldBeCorrect(){
        String season ="2017";
        int numberOfRaces =20;

        given().pathParam("raceSeason",season).
                when().get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
    }


    @DataProvider(name="seasonsAndNumberOfRaces")
    public Object[][] createTestDataRecords(){
        return new Object[][]{
                {"2017",20},
                {"2016",21},
                {"1966",9}
        };
    }

    @Test(dataProvider="seasonsAndNumberOfRaces")
    public void test_NumberOfCircuits_ShouldBe_DataDriven(String season, int numberOfRaces){
        given().pathParam("raceSeason",season).
                when().
                get("http://ergast.com/api/f1/{raceSeason}/circuits.json").
                then().
                assertThat().
                body("MRData.CircuitTable.Circuits.circuitId",hasSize(numberOfRaces));
    }

    @Test
    public void test_DataExtraction(){
        // First, retrieve the circuit ID for the first circuit of the 2017 season
        String circuitId = given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().extract().path("MRData.CircuitTable.Circuits.circuitId[0]");

        // Then, retrieve the information known for that circuit and verify it is located in Australia
        given().pathParam("circuitId",circuitId).when().get("http://ergast.com/api/f1/circuits/{circuitId}.json").then()
                .assertThat().body("MRData.CircuitTable.Circuits.Location[0].country",equalTo("Australia"));

    }

    ResponseSpecification checkStatusCodeAndContentType =
            new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    @Test
    public void test_ResponseSpecification(){
        given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().spec(checkStatusCodeAndContentType).and().body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));
    }

}
