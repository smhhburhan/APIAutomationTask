package services;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static services.PostPetIdTest.petId;

public class PutPetByIdTest  {

     String baseURI = "https://petstore.swagger.io/v2/";


    @Test
    public  void PUTPet() {



        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .body("{\n" +
                        "  \"id\": " + petId + ",\n" +
                        "  \"name\": \"cattie\"\n" +
                        "}")
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" + "Response of PUT \\pet" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }
}
