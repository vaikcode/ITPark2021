package lesson14;

import java.sql.Timestamp;
import java.util.*;

public class PhoneBookArrayRunner {

    final public static int FULL_AMOUNT_OF_CONTACTS = 10000;
    final public static int AMOUNT_OF_PHONEBOOKS = 100;
    final public static int AMOUNT_OF_CONTACTS_IN_PHONEBOOK = 2000;

    public static void main(String[] args) {

        Contact[] fullContactsArray = new Contact[FULL_AMOUNT_OF_CONTACTS];
        PhoneBookArray[] phoneBookArray = new PhoneBookArray[AMOUNT_OF_PHONEBOOKS];
        Contact[] contacts = new Contact[AMOUNT_OF_CONTACTS_IN_PHONEBOOK];
        int indexOfContact;

        Timestamp timestampStartGenerate = new Timestamp(System.currentTimeMillis());
        System.out.println("= = = = =");
        System.out.println("Генерация полного массива контактов");
        for (int i = 0; i < FULL_AMOUNT_OF_CONTACTS; i++) {
             fullContactsArray[i] = new Contact(Contact.randomSecondName(), Contact.randomFirstName(),
                    Contact.randomMiddleName(), Contact.randomPhoneNumber());
        }
        System.out.println("Размер сгенерированного полного массива контактов: " + fullContactsArray.length);
        System.out.println("Полный массив контактов: " + fullContactsArray.toString());

        System.out.println("= = = = =");
        System.out.println("Генерация данных в массив телефонных книг");
        for (int i = 0; i < AMOUNT_OF_PHONEBOOKS; i++) {
            for (int j = 0; j < AMOUNT_OF_CONTACTS_IN_PHONEBOOK; j++) {
                indexOfContact = easyRandom(0, FULL_AMOUNT_OF_CONTACTS - 1);
                Contact insertContact = fullContactsArray[indexOfContact];
                contacts[j] = insertContact;
            }
            phoneBookArray[i] = new PhoneBookArray(fullContactsArray[i], contacts);
        }
        System.out.println("Количество сгенерированных телефонных книг: " + phoneBookArray.length);

        System.out.println("= = = = =");
        System.out.println("Тестовая выборка первого контакта и его телефонной книги (10 первых контактов)");
        int firstContactIndex = 0;
        System.out.println("Индекс контакта: " + firstContactIndex);
        System.out.println("Вледелец: " + phoneBookArray[firstContactIndex].getOwner());
        System.out.println("Телефонная книга контакта:");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + phoneBookArray[firstContactIndex].getContacts()[i]);
        }

        System.out.println("= = = = =");
        System.out.println("Тестовая выборка последнего контакта и его телефонной книги (10 последних контактов)");
        int lastContactIndex = phoneBookArray.length - 1;
        System.out.println("Индекс контакта: " + lastContactIndex);
        System.out.println("Вледелец: " + phoneBookArray[lastContactIndex].getOwner());
        System.out.println("Телефонная книга контакта:");
        for (int i = phoneBookArray[lastContactIndex].getContacts().length - 10; i < phoneBookArray[lastContactIndex].getContacts().length; i++) {
            System.out.println(i + ": " + phoneBookArray[1].getContacts()[i]);
        }

        System.out.println("= = = = =");
        Timestamp timestampFinishGenerate = new Timestamp(System.currentTimeMillis());
        System.out.println("Время начала подсчета количества одинаковых номеров: " + timestampStartGenerate);
        System.out.println("Время окончания подсчета количества одинаковых номеров: " + timestampFinishGenerate);
        long timeStartGenerate = timestampStartGenerate.getTime();
        long timeFinishGenerate = timestampFinishGenerate.getTime();
        System.out.println("Общее время, затраченное на подсчет (миллисекунд): " + (timeFinishGenerate - timeStartGenerate));

        System.out.println("= = = = =");
        System.out.println("Подсчет количества одинаковых номеров в телефонных книгах");
        Timestamp timestampStartCount = new Timestamp(System.currentTimeMillis());

//        Map<Contact, Integer> map = new HashMap<Contact, Integer>();
//        for (PhoneBookArray i : phoneBookArray) {
//            Integer count = map.get(i);
//            map.put(i, count != null ? count+1 : 1);
//        }

        Map<Contact, Integer> mapCount = new HashMap<Contact, Integer>();
        for (int i = 0; i < AMOUNT_OF_PHONEBOOKS; i++) {
            for (int j = 0; j < AMOUNT_OF_CONTACTS_IN_PHONEBOOK; j++) {
                Contact contactCount = phoneBookArray[i].getContacts()[j];
                Integer count = mapCount.get(contactCount);
                mapCount.put(contactCount, count != null ? count + 1 : 1);
            }
        }

        System.out.println("MAP: " + mapCount);

//        Integer popular = Collections.max(mapCount.entrySet(),
//                new Comparator<Map.Entry<Contact, Integer>>() {
//                    @Override
//                    public int compare(Map.Entry<Contact, Integer> o1, Map.Entry<Contact, Integer> o2) {
//                        return o1.getValue().compareTo(o2.getValue());
//                    }
//                }).getKey();
//
//        System.out.println(popular);


        Timestamp timestampFinishCount = new Timestamp(System.currentTimeMillis());
        System.out.println("Время начала подсчета количества одинаковых номеров: " + timestampStartCount);
        System.out.println("Время окончания подсчета количества одинаковых номеров: " + timestampFinishCount);
        long timeStartCount = timestampStartCount.getTime();
        long timeFinishCount = timestampFinishCount.getTime();
        System.out.println("Общее время, затраченное на подсчет (миллисекунд): " + (timeFinishCount - timeStartCount));
    }

    public static int easyRandom(int start, int end){
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
