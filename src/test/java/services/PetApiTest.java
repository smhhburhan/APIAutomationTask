package services;

import body.PostPet;
import body.PutPet;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetApiTest {

    static String baseURI = "https://petstore.swagger.io/v2/";
    static long petId;

    @Test(priority = 1)
    public static void PostPet() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .body(PostPet.PostPetBody())
                .when()
                .post("/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" +"Response of POST \\pet" + "\n" + "----------" + "\n" + response + "\n" + "----------");

        JsonPath jp = new JsonPath(response);
        petId = jp.getLong("id");
        System.out.println("Pet id:" + petId + "\n" + "----------");

    }

    @Test(priority = 2)
    public void getPetById(){

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .when()
                .get("/pet/"+ petId)
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" +"Response of GET \\pet\\petId" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }

    @Test(priority = 3)
    public static void PutPet() {

        String response = given()
                .header("Content-Type", "application/json")
                .baseUri(baseURI)
                .log()
                .all()
                .body(PutPet.PutPetBody())
                .when()
                .put("/pet")
                .then()
                .assertThat()
                .statusCode(200)
                .extract().response().asString();

        System.out.println("----------" + "\n" +"Response of PUT \\pet" + "\n" + "----------" + "\n" + response + "\n" + "----------");

    }
}
