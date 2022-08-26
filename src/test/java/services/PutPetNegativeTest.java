package services;

import body.PutPet;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static services.PostPetTest.baseURI;

public class PutPetNegativeTest {

    //String baseURI = "https://petstore.swagger.io/v2/";

    @Test
    public void PUTPetNegative() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .body(PutPet.PutPetBody()) // incorrect from values has been input ex. there should not be "string" as a pet name
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .statusCode(200) // endpoint generates new pet id that's why response code always 200
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of PUT \\pet" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

}