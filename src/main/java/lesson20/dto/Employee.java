package lesson20.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int serviceNumber;
    private String login;
    private String fullName;
    private Department department;
    private Position position;
}
