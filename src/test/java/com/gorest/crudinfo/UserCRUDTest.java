package com.gorest.crudinfo;

import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;
    static int userID;
    static String name = TestUtils.getRandomValue() + " keyur";
    static String email = "keyur"+TestUtils.generateLastName()+"@gmail.com";
    static String gender = "male";
    static String status = "active";

    @Steps
    UserSteps userSteps;



    @Title("This will create a new user")
    @Test
    public void a_verifyUserCreatedSuccessfully() {
        ValidatableResponse response=userSteps.createStudent(name,email,gender,status);
        response.statusCode(201);
        userID = response.log().all().extract().path("id");
        System.out.println(userID);
    }
    @Title("This will read all user details")
    @Test
    public void b_verifyUserReadSuccessfully() {
       ValidatableResponse response= userSteps.getAllUsers().statusCode(200);

    }
    @Title("This will updated a created user")
    @Test
    public void c_verifyUserUpdateSuccessfully() {
        name = name + "Updated";


        ValidatableResponse response1= userSteps.updateUser(userID,name,email,gender,status).statusCode(200);
    }
    @Title("This will delete a user")
    @Test
    public void d_VerifyUserDeleteSuccessfully() {
        ValidatableResponse response1= userSteps.deleteUser(userID);
    }

}
 
 