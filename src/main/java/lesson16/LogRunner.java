package lesson16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogRunner {

    private static final String LOG_FILE_NAME = "src/main/resources/lesson16log.txt";

    public static void main(String[] args) throws Exception {

        //Проверка наличия старого лог-файла и его удаление
        File logFile = new File(LOG_FILE_NAME);
        if(logFile.exists() && !logFile.isDirectory()) {
            System.out.println("Найден старый лог-файл " + logFile.getName());
            if (logFile.delete ()) {
                System.out.println ("Старый лог-файл удален");
            } else {
                System.out.println ("Старый лог-файл не удален");
            }
        } else {
            System.out.println("Старый лог-файл не найден");
        }

        //Запуск потоков логгера
        List<Thread> threads = IntStream.range(0, 3).boxed().map(i -> {
            final LogLevel[] logLevels = LogLevel.values();
            Logger logger = new Logger(logLevels[new Random().nextInt(logLevels.length)], LOG_FILE_NAME);
            return new Thread(logger);
        }).peek(Thread::start).collect(Collectors.toList());
        for (Thread thread : threads) {
            thread.join();
        }

        //Вывод в консоль нового лог-файла
        try {
            FileReader inFile = new  FileReader(LOG_FILE_NAME);
            BufferedReader inStream = new BufferedReader(inFile);
            String inString;

            System.out.println("Содержимое нового лог-файла:");
            while ((inString = inStream.readLine()) != null) {
                System.out.println(inString);
            }
            inStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}