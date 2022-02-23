package lesson24;

import lesson24.dto.Books;
import lesson24.jdbc.JdbcAuthorsAndBooksDb;

import java.util.List;
import java.util.Scanner;

public class BookSearchRunner {

    public static void main(String[] args) {
        System.out.println("Введите название книги или имя автора для поиска " +
                "или введите EXIT для завершения программы:");
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String text = scanner.nextLine();
            if ("EXIT".equalsIgnoreCase(text)){
                return;
            }
            final List<Books> authorsAndBooks = JdbcAuthorsAndBooksDb.searchByTitleOrAuthorName(text);
            System.out.println("Найденные книги:");
            for(Books book : authorsAndBooks) {
                System.out.println(book.toString());
            }
        }
    }
}