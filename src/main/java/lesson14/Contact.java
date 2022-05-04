package lesson14;

import lesson13.Employee;
import lesson13.enumerations.FirstName;
import lesson13.enumerations.MiddleName;
import lesson13.enumerations.SecondName;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String secondName;  // Фамилия
    private String firstName;   // Имя
    private String middleName;  // Отчество
    private long phoneNumber;   // Телефонный номер

    public Contact() {
    }

    public Contact(String secondName, String firstName, String middleName, long phoneNumber) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return this.secondName + " " + this.firstName + " " + this.middleName + ", " +
                "tel: +" + this.phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Contact) {
            if (secondName.equals(((Contact) o).secondName) && firstName.equals(((Contact) o).firstName)
                    && middleName.equals(((Contact) o).middleName) && (phoneNumber == ((Contact) o).phoneNumber))
                return true;
            else
                return false;
        } else
            return false;
    }

    public static String randomFirstName(){
        return FirstName.as(easyRandom(1, 10)).toString();
    }

    public static String randomMiddleName(){
        return MiddleName.as(easyRandom(1, 10)).toString();
    }

    public static String randomSecondName(){
        return SecondName.as(easyRandom(1, 10)).toString();
    }

    public static long randomPhoneNumber(){
        int stateCode = 7;
        int operatorCode = easyRandom(900, 999);
        int suffixPhoneNumber =  easyRandom(0, 9999999);
        return stateCode * 1_000_000_00_00L + operatorCode * 1_000_00_00L + suffixPhoneNumber;
    }

    public static int easyRandom(int start, int end){
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
