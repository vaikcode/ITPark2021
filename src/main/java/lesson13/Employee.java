package lesson13;

public class Employee {

    private String secondName;
    private String firstName;
    private String middleName;
    private int serviceNumber;
    private int workAge;

    public Employee(String secondName, String firstName, String middleName, int serviceNumber, int workAge) {
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.serviceNumber = serviceNumber;
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "secondName='" + secondName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", serviceNumber=" + serviceNumber +
                ", workAge=" + workAge +
                '}';
    }

    public String asString() {
        return secondName + " " + firstName + " " + middleName + ", табельный номер " + serviceNumber +
                ", стаж работы (лет) " + workAge;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(int serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }
}
