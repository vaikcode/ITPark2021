package lesson20;

import lesson20.dto.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeWrapper {

    List<Employee> employees;
}
