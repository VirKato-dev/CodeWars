package tasks;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExternalFileSorterTest {
    private String tempDirPath;

    @BeforeEach
    void setUp() {
        tempDirPath = "temp";
        new File(tempDirPath).mkdir();
    }

    @AfterEach
    void tearDown() {
        File tempDir = new File(tempDirPath);
        for (File file : tempDir.listFiles()) {
            file.delete();
        }
        tempDir.delete();
    }

    @Test
    void testSortAndWriteChunk() throws IOException {
        ExternalFileSorter sorter = new ExternalFileSorter();
        List<String> lines = Arrays.asList("foo", "bar", "baz");

        sorter.sortAndWriteChunk(lines);

        String tempFileName = tempDirPath + File.separator + "tempFile.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFileName))) {
            assertEquals("bar", reader.readLine());
            assertEquals("baz", reader.readLine());
            assertEquals("foo", reader.readLine());
        }
    }

    @Test
    void testMergeSortedFiles() throws IOException {
        ExternalFileSorter sorter = new ExternalFileSorter();
        String outputFilePath = "output.txt";

        // Создаем временные файлы
        String tempFileName1 = tempDirPath + File.separator + "tempFile1.txt";
        String tempFileName2 = tempDirPath + File.separator + "tempFile2.txt";
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(tempFileName1));
             BufferedWriter writer2 = new BufferedWriter(new FileWriter(tempFileName2))) {
            writer1.write("bar");
            writer1.newLine();
            writer1.write("foo");
            writer1.newLine();
            writer2.write("baz");
            writer2.newLine();
        }

        // Вызываем метод mergeSortedFiles
        sorter.mergeSortedFiles(outputFilePath);

        // Проверяем, что результат слияния верен
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFilePath))) {
            assertEquals("bar", reader.readLine());
            assertEquals("baz", reader.readLine());
            assertEquals("foo", reader.readLine());
        }
    }
}