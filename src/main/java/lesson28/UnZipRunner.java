package lesson28;

import lesson28.service.ArchiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class UnZipRunner {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Укажите входной файл для разархивирования.");
            return;
        }
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(ZipRunner.class, args);
        final ArchiveService archiveService = applicationContext.getBean(ArchiveService.class);

        System.out.println("Разархивируемый файл: " + args[0]);
        final String unZipPath = archiveService.unZip(args[0]);
        System.out.println("Архив разархивирован в директорию: " + unZipPath);
    }
}
