package lesson14;

public class PhoneBookArray {

    private Contact owner = new Contact(); // Владелец телефона

    private Contact[] contacts = new Contact[PhoneBookArrayRunner.AMOUNT_OF_CONTACTS_IN_PHONEBOOK]; // Телефонная книга в виде массива

    public PhoneBookArray() {
    }

    public PhoneBookArray(Contact owner, Contact[] contacts) {
        this.owner = owner;
        this.contacts = contacts;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof PhoneBookArray) {
////            if (id == ((PhoneBook) o).id && secondName.equals(((PhoneBook) o).secondName)
////                    && firstName.equals(((PhoneBook) o).firstName) && middleName.equals(((PhoneBook) o).middleName)
////                    && (phoneNumber == ((PhoneBook) o).phoneNumber)) {
//            if (phoneNumber == ((PhoneBookArray) o).phoneNumber) {
//                return true;
//            }
//        }
//        return false;
//    }

    public Contact getOwner() {
        return owner;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Owner: " + this.owner + "; Phonebook: " + this.contacts;
    }
}
