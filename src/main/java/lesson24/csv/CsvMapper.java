package lesson24.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lesson24.dto.Books;
import lombok.experimental.UtilityClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@UtilityClass
public class CsvMapper {

    public List<Books> getBookInfo() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CsvMapper.class.getResourceAsStream("/lesson24books.csv")))) {
            CsvToBean<Books> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Books.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            return csvToBean.stream().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}