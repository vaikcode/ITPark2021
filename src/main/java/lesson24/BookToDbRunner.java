package lesson24;

import lesson24.csv.CsvMapper;
import lesson24.dto.DtoAuthor;
import lesson24.dto.DtoBook;
import lesson24.jdbc.JdbcAuthorsAndBooksDb;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

public class BookToDbRunner {

    public static void main(String[] args) {

        System.out.println("Удаление таблиц авторов и книг если такие имеются");
        JdbcAuthorsAndBooksDb.dropAuthorsAndBooksIfExists();
        System.out.println("Создание таблиц авторов и книг");
        JdbcAuthorsAndBooksDb.createAuthorsAndBooks();
        System.out.println("Наполнение таблиц данными из ресурсного файла");
        CsvMapper.getBookInfo().stream().map(authorAndBook -> Pair.of(
                new DtoAuthor(authorAndBook.getAuthor()),
                new DtoBook(authorAndBook.getIsbn(),
                        authorAndBook.getTitle(),
                        authorAndBook.getUrl(),
                        authorAndBook.getPageCount(),
                        authorAndBook.getPrice()))).forEach(pair ->
                {
                    final Optional<Integer> author = JdbcAuthorsAndBooksDb.insertAuthor(pair.getLeft());
                    JdbcAuthorsAndBooksDb.insertBook(author.orElse(null), pair.getRight());
                }
        );
        System.out.println("Выполнение программы завершено");
    }
}