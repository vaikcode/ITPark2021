package lesson20;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson13.EmployeeUtils;
import lesson20.dto.Department;
import lesson20.dto.Employee;
import lesson20.dto.EmployeeWrapper;
import lesson20.dto.Position;
import jakarta.xml.bind.JAXB;
import lombok.SneakyThrows;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EmployeeRunner {

    private static int SERVICE_NUMBER_COUNTER = 1;

    private static final List<Department> DEPARTMENTS = List.of(
            new Department("IT Center", "Moscow"),
            new Department("IT Ural", "Yekaterinburg"),
            new Department("IT Siberia", "Novosibirsk"));

    private static final List<Position> POSITIONS = List.of(
            new Position("Trainee", new BigDecimal(800)),
            new Position("Junior Java Developer", new BigDecimal(1_000)),
            new Position("Middle Java Developer", new BigDecimal(2_000)),
            new Position("Senior Java Developer", new BigDecimal(3_000)),
            new Position("Team Leader", new BigDecimal(3_500)));

    private static final TypeReference<EmployeeWrapper> TR = new TypeReference<>(){};

    @SneakyThrows
    public static void main(String[] args) {

        System.out.println("Генерация списка сотрудников");
        EmployeeWrapper employees =
                new EmployeeWrapper(List.of(
                        getEmployee(),
                        getEmployee(),
                        getEmployee(),
                        getEmployee()
                ));
        System.out.println("Вывод списка сотрудников:");
        System.out.println(employees);
        System.out.println("");

        Path xmlFile = Paths.get("src/main/resources/lesson20employees.xml");

        System.out.println("JAXB-маршалинг данных в XML-файл " + xmlFile);
        JAXB.marshal(employees, xmlFile.toFile());
        System.out.println("");

        System.out.println("=== Работа с XML-файлом ===");
        Document xmlDocument = getXmlDocument(xmlFile.toFile());
        Integer averageSalary = getAverageSalary(xmlDocument);
        System.out.println("Средняя зарплата сотрудников составляет: " + averageSalary);

        List<String> employeeList = searchEmployeesWithMoreAverageSalary(xmlDocument, averageSalary);
        System.out.println("Число сотрудников с зарплатой выше средней: " + employeeList.size());
        System.out.println("Список сотрудников с зарплатой выше средней:");
        System.out.println(employeeList);
        System.out.println("");

        System.out.println("=== Работа с JSON-файлом ===");
        System.out.println("Преобразование XML в JSON");
        String json = XML.toJSONObject(String.join("", Files.readAllLines(xmlFile))).toString();
        Path jsonFile = Paths.get("src/main/resources/lesson20employees.json");
        System.out.println("Сохранение данных в JSON-файл " + jsonFile.getFileName());
        Files.writeString(jsonFile, json, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        System.out.println("Вывод информации о сотрудниках на нечетных позициях:");
        List<Employee> oddEmployees = getOddEmployees(jsonFile);
        System.out.println(oddEmployees);
    }

    private static Employee getEmployee() {
        return new Employee().setServiceNumber(SERVICE_NUMBER_COUNTER + "")
                .setLogin("user" + SERVICE_NUMBER_COUNTER++)
                .setFullName(EmployeeUtils.randomSecondName() + " " + EmployeeUtils.randomFirstName() + " "
                        + EmployeeUtils.randomMiddleName())
                .setDepartment(DEPARTMENTS.get(new Random().nextInt(DEPARTMENTS.size())))
                .setPosition(POSITIONS.get(new Random().nextInt(POSITIONS.size())));
    }

    @SneakyThrows
    private static Document getXmlDocument(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        return documentBuilder.parse(xmlFile);
    }

    @SneakyThrows
    private static Integer getAverageSalary(Document xmlDocument) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        Double result = (Double) xPathFactory.newXPath()
                .compile("sum(//position/@salary) div count(//position)")
                .evaluate(xmlDocument, XPathConstants.NUMBER);
        return result != null ? result.intValue() : 0;
    }

    @SneakyThrows
    private static List<String> searchEmployeesWithMoreAverageSalary(Document xmlDocument, int salary) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        NodeList nodeList = (NodeList) xPathFactory.newXPath()
                .compile("//employee/position[@salary > " + salary + "]/ancestor::employee/fullName/text()")
                .evaluate(xmlDocument, XPathConstants.NODESET);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            result.add(nodeList.item(i).getNodeValue());
        }
        System.out.println("- Сформирован NodeList: " + nodeList);
        System.out.println("- Размер NodeList: " + nodeList.getLength());
        return result;
    }

    @SneakyThrows
    private static List<Employee> getOddEmployees(Path jsonPath) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        EmployeeWrapper employeesFromJson = objectMapper.readValue(jsonPath.toFile(), TR);
        return employeesFromJson.getEmployees().stream().filter(employee -> employeesFromJson.getEmployees()
                .indexOf(employee) % 2 == 1).collect(Collectors.toList());
    }
}
