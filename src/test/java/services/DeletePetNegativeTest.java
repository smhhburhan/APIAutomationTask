package services;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static services.PostPetTest.baseURI;

public class DeletePetNegativeTest {

    //String baseURI = "https://petstore.swagger.io/v2/";

    @Test
    public void DELETEPetNegative() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .delete("/pet/" + 1) // incorrect pet id has been input
                .then()
                .assertThat()
                .statusCode(404) // expected result is pet not found
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of DELETE \\pet\\petId" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

}