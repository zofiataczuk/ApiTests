package apiEngine.model;


import lombok.Data;

import java.util.List;

@Data
public class Employees {

    public String status;
    public List<EmployeeData> data;
    public String message;
}
