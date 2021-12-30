package lesson13;

import lesson13.enumerations.FirstName;
import lesson13.enumerations.MiddleName;
import lesson13.enumerations.SecondName;

import java.util.*;

public class EmployeeUtils {

    public static void main(String[] args) {

        int amount = 400;
        int currentServiceNumber = 0;
        List<Employee> employees = new ArrayList<>();

        // Generate list od employee
        for (int i = 0; i < amount; i++) {
            employees.add(employeeGenerate(++currentServiceNumber));
        }

        System.out.println(employees);
        System.out.println();

        System.out.println("=== Печать первых 10 элементов ===");
        printFirstEmployee(employees, 10);
        System.out.println();

        printEmployee(employees, 1);
        System.out.println();
        printEmployee(employees, 3);
        System.out.println();
        printEmployee(employees, 5);
        System.out.println();
        printEmployee(employees, 10);
        System.out.println();

        System.out.println("=== Удаление нечетных элементов ===");
        removeOddElementsFromEnd(employees);

        System.out.println();
        System.out.println("=== Печать первых 10 элементов после удаления ===");
        printFirstEmployee(employees, 10);
    }

    public static void printFirstEmployee(Collection<Employee> employees, int amount) {

        int i = 0;

        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            System.out.println(next.asString());
            i++;
            if (i == amount)
                break;
        }
    }

    public static void printEmployee(Collection<Employee> employees, int workAge) {

        switch (workAge) {
            case 1:
            case 21:
            case 31:
            case 41:
                System.out.println("Список работников, которые имеют стаж 1 год:");
                break;
            case 2:
            case 22:
            case 23:
            case 24:
            case 3:
            case 32:
            case 33:
            case 34:
            case 4:
            case 42:
            case 43:
            case 44:
                System.out.println("Список работников, которые имеют стаж " + workAge + " года:");
                break;
            default:
                System.out.println("Список работников, которые имеют стаж " + workAge + " лет:");
                break;
        }
        for (Iterator<Employee> iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee next = iterator.next();
            if (next.getWorkAge() == workAge) {
                System.out.println(next.asString());
            }
        }
    }

    public static void removeOddElementsFromEnd(List<Employee> employees) {

        int originalSize = employees.size();
        boolean isCurrentOdd;

        isCurrentOdd = originalSize % 2 != 0;

        System.out.println("Количество элементов в коллекции до удаления: " + originalSize);

        ListIterator listIterator = employees.listIterator(employees.size());

        while (listIterator.hasPrevious()) {
            listIterator.previous();
            if (isCurrentOdd) {
                listIterator.remove();
                isCurrentOdd = false;
            } else {
                isCurrentOdd = true;
            }
        }

        System.out.println("Количество удаленных элементов: " + (originalSize - employees.size()));
        System.out.println("Количество элементов в коллекции после удаления: " + employees.size());
    }

    public static Employee employeeGenerate(int serviceNumber){
        String secondName = randomSecondName();
        String firstName = randomFirstName();
        String middleName = randomMiddleName();
        int workAge = easyRandom(0, 50);

        return new Employee(secondName, firstName, middleName, serviceNumber, workAge);
    }

    public static String randomFirstName(){
        return FirstName.as(easyRandom(1,10)).toString();
    }

    public static String randomMiddleName(){
        return MiddleName.as(easyRandom(1,10)).toString();
    }

    public static String randomSecondName(){
        return SecondName.as(easyRandom(1,10)).toString();
    }

    public static int easyRandom(int start, int end){
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
