package lesson28.service.impl;

import lesson28.service.ArchiveService;
import net.lingala.zip4j.ZipFile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    private static final String ZIP_EXTENSION = ".zip";

    @Override
    public String zip(String sourcePath) throws IOException {

        final Path zipPath = Path.of(sourcePath).resolveSibling(Path.of(sourcePath).getFileName() + ZIP_EXTENSION);

        if (!Files.isRegularFile(Path.of(sourcePath))) {
            System.err.println("ОШИБКА! Неправильный входной параметр - не файл.");
            return "Завершение программы из-за ошибки.";
        }

        try {
            new ZipFile(zipPath.toString()).addFile(sourcePath);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода!");
        }

        return String.valueOf(zipPath);
    }

    @Override
    public String unZip(String zipPath) throws IOException {

        final Path targetPath = Path.of(zipPath).getParent();

        try {
            new ZipFile(zipPath).extractAll(targetPath.toString());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода!");
        }

        return String.valueOf(targetPath);
    }
}
