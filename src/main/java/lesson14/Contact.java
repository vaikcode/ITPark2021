package lesson14;

import lesson13.Employee;
import lesson13.enumerations.FirstName;
import lesson13.enumerations.MiddleName;
import lesson13.enumerations.SecondName;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    private int id; // ID
    private String secondName; // Фамилия
    private String firstName; // Имя
    private String middleName; // Отчество
    private long phoneNumber; // Телефонный номер
    private PhoneBook[] phoneBookArray = new PhoneBook[10]; // Телефонная книга в виде массива
    private List<PhoneBook> phoneBookArrayList = new ArrayList<>(); // Телефонная книга в виде ArrayList

    public Contact() {
    }

    public Contact(int id, String secondName, String firstName, String middleName, long phoneNumber) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneBookArray(PhoneBook[] phoneBookArray) {
        this.phoneBookArray = phoneBookArray;
    }

    public void setPhoneBookArrayList(List<PhoneBook> phoneBookArrayList) {
        this.phoneBookArrayList = phoneBookArrayList;
    }

    public PhoneBook[] getPhoneBookArray() {
        return phoneBookArray;
    }

    public List<PhoneBook> getPhoneBookArrayList() {
        return phoneBookArrayList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "ID = " + this.id + ", " + this.secondName + " " + this.firstName + " " + this.middleName + ", " +
                "tel: +" + this.phoneNumber;
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
