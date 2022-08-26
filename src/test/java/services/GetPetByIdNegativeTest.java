package services;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static services.PostPetTest.baseURI;
import static services.PostPetTest.petId;

public class GetPetByIdNegativeTest { //After DELETE check & Negative scenario invalid pet id input

    //String baseURI = "https://petstore.swagger.io/v2/";

    @Test
    public void GETPetByIdNegative() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .get("/pet/" + petId) // deleted pet id has been input
                .then()
                .assertThat()
                .log()
                .all()
                .statusCode(404) // expected result is pet not found
                .extract().response().asString();

        System.out.println("----------" + "\n" + "After DELETE \\pet\\petId Method, response of GET \\pet\\petId with DELETED Pet id " + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

}