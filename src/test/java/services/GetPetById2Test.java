package services;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static services.PostPetIdTest.petId;

public class GetPetById2Test  {

    String baseURI = "https://petstore.swagger.io/v2/";


    @Test
    public void GETPetById2() {



        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .get("/pet/" + petId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "After PUT \\pet Method, response of GET \\pet\\petId with last Pet id " + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }
}
