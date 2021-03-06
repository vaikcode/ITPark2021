package lesson28;

import lesson28.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ZipRunner {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Укажите входной файл для архивирования.");
            return;
        }
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(ZipRunner.class, args);
        final ArchiveService archiveService = applicationContext.getBean(ArchiveService.class);

        System.out.println("Архивируемый файл: " + args[0]);
        final String zipFile = archiveService.zip(args[0]);
        System.out.println("Заархивированный файл: " + zipFile);
    }
}
