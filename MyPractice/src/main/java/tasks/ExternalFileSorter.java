package tasks;

import java.io.*;
import java.util.*;


public class ExternalFileSorter {

    public static void main(String[] args) {
        String inputFilePath = "путь_к_вашему_большому_файлу.txt";
        String outputFilePath = "путь_к_вашему_отсортированному_файлу.txt";

        try {
            externalSort(inputFilePath, outputFilePath);
            System.out.println("Файл успешно отсортирован.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void externalSort(String inputFilePath, String outputFilePath) throws IOException {
        int chunkSize = 100000; // Размер чанка (можете подобрать под свои требования)
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
                if (lines.size() >= chunkSize) {
                    sortAndWriteChunk(lines);
                    lines.clear();
                }
            }
        }

        // Обработка последнего чанка
        if (!lines.isEmpty()) {
            sortAndWriteChunk(lines);
        }

        // Слияние временных файлов
        mergeSortedFiles(outputFilePath);
    }

    public static void sortAndWriteChunk(List<String> lines) throws IOException {
        Collections.sort(lines);

        String tempFileName = "temp" + UUID.randomUUID() + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFileName))) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
        }
    }

    public static void mergeSortedFiles(String outputFilePath) throws IOException {
        PriorityQueue<BufferedReader> pq = new PriorityQueue<>(Comparator.comparing(s -> {
            try {
                return s.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }));

        // Открываем BufferedReader для каждого временного файла
        File tempDir = new File(".");
        File[] tempFiles = tempDir.listFiles((dir, name) -> name.startsWith("temp"));
        for (File file : tempFiles) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            pq.add(reader);
        }

        // Создаем BufferedWriter для записи в итоговый файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            while (!pq.isEmpty()) {
                BufferedReader reader = pq.poll();
                String line = reader.readLine();
                if (line != null) {
                    writer.write(line + System.lineSeparator());
                    pq.add(reader);
                } else {
                    reader.close();
                }
            }
        }

        // Удаление временных файлов
        for (File file : tempFiles) {
            file.delete();
        }
    }
}