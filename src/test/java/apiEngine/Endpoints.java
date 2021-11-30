package apiEngine;

import apiEngine.model.Employees;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class Endpoints {

    private final RequestSpecification request;

    public Endpoints(String baseUrl) {
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
    }


    public IRestResponse<Employees> getListOfEmployees() {

        Response response = request.get(Route.employeesPath());
        return new RestResponse(Employees.class, response);

    }
}
