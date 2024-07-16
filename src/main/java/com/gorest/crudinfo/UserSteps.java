package com.gorest.crudinfo;

import com.gorest.constant.EndPoints;
import com.gorest.model.Userpojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class UserSteps {

    @Step
    public ValidatableResponse createStudent(String name, String email, String gender, String status){

        Userpojo userpojo= Userpojo.getUserPojo(name,email,gender,status);

        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 7d0608a0ee76ca7ec6d277a35584cec39728c25e577d27120f1763029c1f689b")
                .when()
                .body(userpojo)
                .post()
                .then();
    }


    @Step
    public ValidatableResponse getAllUsers(){

        return SerenityRest.given()
                .when()
                .get()
                .then();
    }
    @Step
    public ValidatableResponse updateUser(int userID, String name, String email, String gender, String status){
        Userpojo userpojo= Userpojo.getUserPojo(name,email,gender,status);

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 7d0608a0ee76ca7ec6d277a35584cec39728c25e577d27120f1763029c1f689b")
                .pathParam("id", userID)
                .when()
                .body(userpojo)
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();

    }
    public ValidatableResponse deleteUser(int userID){
        return SerenityRest.given().log().all()
                .pathParam("id",userID)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 7d0608a0ee76ca7ec6d277a35584cec39728c25e577d27120f1763029c1f689b")
                .when()
                .delete(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }
}
