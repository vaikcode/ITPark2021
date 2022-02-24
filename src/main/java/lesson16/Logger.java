package lesson16;

import lombok.RequiredArgsConstructor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RequiredArgsConstructor
public class Logger implements Runnable {

    private static final String FORMAT_LOG_MESSAGE = "%s %s %s %s\n"; //Форматированная строка сообщения в лог
    private static final DateTimeFormatter FULL_DATE_TIME_FORMAT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"); //Форматированное время записи в лог
    private static final int LIFETIME = 60 * 1000; //Общее время работы логгера в миллисекундах (60 секунд)

    private final LogLevel logLevel; //Уровень работы логгера
    private final String logFileName; //Имя лог-файла
    private final long currentTimeMillis = System.currentTimeMillis(); //Текущее время
    private int counter = 1; //Счетчик сообщений в лог

    //Содание потока логгера
    @Override
    public void run() {
        System.out.printf("Начал работу поток %s\n", Thread.currentThread().getName());
        while(System.currentTimeMillis() <= currentTimeMillis + LIFETIME) { //Время работы потока ограничено 1 минутой
            try(FileWriter fileWriter = new FileWriter(logFileName, true)) {
                fileWriter.write(generateLogMessage());
                Thread.sleep(new Random().nextInt(5_000)); //Задержка записи в лог не более 5 секунд
            } catch (IOException | InterruptedException exception) {
                exception.printStackTrace();
                break;
            }
        }
    }

    //Генерация сообщения в лог
    private String generateLogMessage() {
        LocalDateTime now = LocalDateTime.now();
        return String.format(FORMAT_LOG_MESSAGE, FULL_DATE_TIME_FORMAT.format(now),
                logLevel, "Поток " + Thread.currentThread().getName(), "записал сообщение #" + counter++);
    }
}
