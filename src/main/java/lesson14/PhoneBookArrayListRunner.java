package lesson14;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PhoneBookArrayListRunner {

    public static void main(String[] args) {

//        int amountOfContacts = 10;
//        int amountOfPhoneBook = 5;
//        List<Contact> contactsArrayList = new ArrayList<>();
//
//        System.out.println("= = = = =");
//        System.out.println("Начальный размер коллекции контактов: " + contactsArrayList.size());
//
//        // Генерация коллекции контактов
//        for (int i = 0; i < amountOfContacts; i++) {
//            contactsArrayList.add(new Contact(i + 1, Contact.randomSecondName(), Contact.randomFirstName(),
//                    Contact.randomMiddleName(), Contact.randomPhoneNumber()));
//        }
//        System.out.println("Размер сгенерированной коллекции контактов: " + contactsArrayList.size());
//        System.out.println("Коллекция контактов: " + contactsArrayList);
//
//        // Генерация коллекций записных книжек в контактах
//        for (int i = 0; i < amountOfContacts; i++) {
//            for (int j = 0; j < amountOfPhoneBook; j++) {
//                int indexOfContact = easyRandom(0, amountOfContacts - 1);
////                Contact insertContact = contactsArrayList.listIterator(indexOfContact).next();
//                Contact insertContact = contactsArrayList.get(indexOfContact);
////                contactsArrayList.listIterator(i).next().phoneBookArrayList.add(new PhoneBook(insertContact));
////                contactsArrayList.phoneBookArrayList.add(new PhoneBook(insertContact));
//                contactsArrayList.add(new PhoneBookArray(insertContact));
//            }
////            contactsArrayList
//        }
//        System.out.println("Телефонные книги в коллекции контактов сгенерированы");
//
//        // Тестовая выборка контакта и его телефонной книги
////        Contact contactTest = contactsArrayList.listIterator(0).next();
//        Contact contactTest = contactsArrayList.get(0);
//        System.out.println("= = = = =");
//        System.out.println("Телефонная книга контакта " + contactTest + " :");
//        for (int i = 0; i < amountOfPhoneBook; i++) {
////            System.out.println(contactTest.phoneBookArrayList.listIterator(i).next());
//            System.out.println(contactTest.getPhoneBookArrayList());
//        }
//
//        // Тестовая выборка контакта и его телефонной книги
////        contactTest = contactsArrayList.listIterator(1).next();
//        contactTest = contactsArrayList.get(1);
//        System.out.println("= = = = =");
//        System.out.println("Телефонная книга контакта " + contactTest + " :");
//        for (int i = 0; i < amountOfPhoneBook; i++) {
////            System.out.println(contactTest.phoneBookArrayList.listIterator(i).next());
//            System.out.println(contactTest.getPhoneBookArrayList());
//        }
//
//        // Тестовая выборка контакта и его телефонной книги
////        contactTest = contactsArrayList.listIterator(contactsArrayList.size() - 1).next();
//        contactTest = contactsArrayList.get(contactsArrayList.size() - 1);
//        System.out.println("= = = = =");
//        System.out.println("Телефонная книга контакта " + contactTest + " :");
//        for (int i = 0; i < amountOfPhoneBook; i++) {
////            System.out.println(contactTest.phoneBookArrayList.listIterator(i).next());
//            System.out.println(contactTest.getPhoneBookArrayList());
//        }
//
//        // Подсчет количества одинаковых номеров в телефонных книгах
//        System.out.println("= = = = =");
//        System.out.println("Подсчет количества одинаковых номеров в телефонных книгах");
//        Timestamp timestampStart = new Timestamp(System.currentTimeMillis());
//////////////
//////////////
//////////////
//        List<PhoneBookArray> phoneBookFrequency = new ArrayList<>();
//        List<Integer> amountFrequency = new ArrayList<>();
//        for (ListIterator<Contact> iteratorContact = contactsArrayList.listIterator(); iteratorContact.hasNext(); ) {
//            Contact contact = iteratorContact.next();
//            int indexOfPhoneBook;
//            int amount;
//            for (ListIterator<PhoneBookArray> iteratorPhoneBook = contact.phoneBookArrayList.listIterator();
//                 iteratorPhoneBook.hasNext(); ) {
//                PhoneBookArray phoneBook = iteratorPhoneBook.next();
//////////////
//////////////
//////////////
//                if (phoneBookFrequency.contains(phoneBook)) {
//                    System.out.println("---");
//                    System.out.println("true");
//                    indexOfPhoneBook = phoneBookFrequency.indexOf(phoneBook);
//                    System.out.println("indexOfPhoneBook = " + indexOfPhoneBook);
//                    amount = amountFrequency.listIterator(indexOfPhoneBook).next();
//                    System.out.println("amount = " + amount);
//                    //amountFrequency.listIterator(indexOfPhoneBook).set(amount + 1);
//                } else {
//                    System.out.println("---");
//                    System.out.println("false");
//                    phoneBookFrequency.add(phoneBook);
//                    System.out.println(phoneBook);
//                    System.out.println(phoneBookFrequency);
//                    amountFrequency.add(1);
//                }
//            }
//        }
//
////        for (Iterator<String> iterator = words.iterator(); iterator.hasNext(); ) {
////            String next = iterator.next();
////            if (new Random().nextBoolean()) {
////                System.out.println("Удаляемый элемент: " + next);
////                iterator.remove();
////            }
////        }
//
//        System.out.println("size of amountFrequency " + amountFrequency.size());
//        System.out.println(amountFrequency);
//        System.out.println("size of phoneBookFrequency " + phoneBookFrequency.size());
//        System.out.println(phoneBookFrequency);
//
//        Timestamp timestampFinish = new Timestamp(System.currentTimeMillis());
//        System.out.println("Время начала подсчета количества одинаковых номеров: " + timestampStart);
//        System.out.println("Время окончания подсчета количества одинаковых номеров: " + timestampFinish);
//        long timeStart = timestampStart.getTime();
//        long timeFinish = timestampFinish.getTime();
//        System.out.println("Общее время, затраченное на подсчет (миллисекунд): " + (timeFinish - timeStart));
//    }
//
//    public static int easyRandom(int start, int end){
//        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
