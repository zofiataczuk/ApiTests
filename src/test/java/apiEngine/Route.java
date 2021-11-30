package apiEngine;

public class Route {

    private static final String VERSION = "/v1";


    public static String employeesPath() {
        return VERSION + "/employees";
    }

    public static String employeePath(String employeeNumber) {
        return VERSION + "/employee" + employeeNumber;
    }
}
