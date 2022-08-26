package services;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static services.PostPetIdTest.petId;

public class DeletePetTest  {

    String baseURI = "https://petstore.swagger.io/v2/";

    @Test
    public void DELETEPet() {



        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .delete("/pet/" + petId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of DELETE \\pet\\petId" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }
}
