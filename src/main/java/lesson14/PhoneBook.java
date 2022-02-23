package lesson14;

public class PhoneBook {
    private int id; // ID
    private String secondName; // Фамилия
    private String firstName; // Имя
    private String middleName; // Отчество
    private long phoneNumber; // Телефонный номер

    public PhoneBook() {
    }

    public PhoneBook(Contact contact) {
        this.id = contact.getId();
        this.secondName = contact.getSecondName();
        this.firstName = contact.getFirstName();
        this.middleName = contact.getMiddleName();
        this.phoneNumber = contact.getPhoneNumber();
    }

    public PhoneBook(int id, String secondName, String firstName, String middleName, long phoneNumber) {
        this.id = id;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PhoneBook) {
//            if (id == ((PhoneBook) o).id && secondName.equals(((PhoneBook) o).secondName)
//                    && firstName.equals(((PhoneBook) o).firstName) && middleName.equals(((PhoneBook) o).middleName)
//                    && (phoneNumber == ((PhoneBook) o).phoneNumber)) {
            if (phoneNumber == ((PhoneBook) o).phoneNumber) {
                return true;
            }
        }
        return false;
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
}
