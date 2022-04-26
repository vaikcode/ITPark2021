package lesson28.service;

import java.io.IOException;

public interface ArchiveService {

    String zip (String sourcePath) throws IOException;

    String unZip (String sourcePath) throws IOException;
}
