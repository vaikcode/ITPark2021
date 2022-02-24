package lesson18;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderRunner {

    private static final String FILE_PATH = "src/main/resources/";
    private static final String INPUT_FILE_NAME = "lesson18input.txt";
    private static final String OUTPUT_FILE_NAME = "lesson18output";
    private static final String OUTPUT_FILE_EXTENSION = ".txt";

    public static void main(String[] args) {

        System.out.printf("1. Читаем ресурсный файл: %s%n", FILE_PATH + INPUT_FILE_NAME);
        ArrayList<String> listOfText = readFileToList(FILE_PATH + INPUT_FILE_NAME);

        System.out.printf("2. Отпарсено строк: %s%n", listOfText.size());
        System.out.println("3. ArrayList с отпарсенным текстом:");
        System.out.println(listOfText.toString());

        System.out.println("4. Запись ArrayList в файлы");
        int i = writeListToFiles(listOfText, FILE_PATH, OUTPUT_FILE_NAME, OUTPUT_FILE_EXTENSION);
        System.out.printf("5. Записано файлов: %s%n", i);
    }

    @SneakyThrows(IOException.class)
    private static ArrayList<String> readFileToList (String filename) {

        Scanner s = new Scanner(new File(filename));
        ArrayList<String> listOfText = new ArrayList<>();
        while (s.hasNextLine()){
            listOfText.add(s.nextLine());
        }
        s.close();

        return listOfText;
    }

    @SneakyThrows
    private static int writeListToFiles (ArrayList<String> listOfText, String filePath, String fileName,
                                          String fileExtension) {

        int i = 1;
        for(String string: listOfText) {
            FileWriter writer = new FileWriter(filePath + fileName + i + fileExtension);
            writer.write(string);
            writer.close();
            i++;
        }
        return i-1;
    }
}
