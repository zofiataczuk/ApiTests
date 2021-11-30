package tests;

import apiEngine.Endpoints;
import apiEngine.IRestResponse;
import apiEngine.model.EmployeeData;
import apiEngine.model.Employees;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ApiTests extends Endpoints {

    private static final String baseUrl = "http://dummy.restapiexample.com/api";

    private Endpoints endPoints;

    public ApiTests(String baseUrl) {
        super(baseUrl);
        endPoints = new Endpoints(baseUrl);
    }

    @Test
    public void checkListOfEmployees() {

        IRestResponse<Employees> employeesResponse = endPoints.getListOfEmployees();
        String status = employeesResponse.getBody().getStatus();
        List<EmployeeData> employeeDataList = employeesResponse.getBody().getData();

        assertThat(status).as("Incorrect status returned").isEqualTo("success");
        assertThat(employeeDataList).as("Employee data list is empty").isNotEmpty();
    }

    @Test
    public void checkEmployeeData() {

        IRestResponse<Employees> employeesResponse = endPoints.getListOfEmployees();
        List <EmployeeData> employeeDataList = employeesResponse.getBody().getData();

        String employeeName = employeeDataList.stream().map(m -> m.getEmployee_name())
                .findFirst().get();

        assertThat(employeeName).as("Incorrect employee name").isEqualTo("Tiger Nixon");
    }

}
