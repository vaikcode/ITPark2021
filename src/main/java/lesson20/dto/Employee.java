package lesson20.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlAttribute
    private String serviceNumber;
    @XmlAttribute
    private String login;
    private String fullName;
    private Department department;
    private Position position;
}
