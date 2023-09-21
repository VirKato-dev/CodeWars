package tasks;

import java.io.*;
import java.util.*;

//todo не работает пока
public class SortFileLines {
    // Максимальное количество элементов, которое можно загрузить в память одновременно
    private static final int CHUNK_SIZE = 2;

    // Функция для разделения большого файла на меньшие части и их сортировки
    public static void externalSort(String inputFile, String outputFile) throws IOException {
        List<String> chunk = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                chunk.add(line);
                if (chunk.size() >= CHUNK_SIZE) {
                    // Сортируем и записываем текущий кусок во временный файл
                    Collections.sort(chunk);
                    writeChunkToFile(chunk, "temp_chunk.txt");
                    chunk.clear();
                }
            }
        }

        // Если остались данные в куске, сортируем и записываем их
        if (!chunk.isEmpty()) {
            Collections.sort(chunk);
            writeChunkToFile(chunk, "temp_chunk.txt");
        }

        // Объединяем отсортированные куски в выходной файл
        mergeChunks("temp_chunk.txt", outputFile);
    }

    // Функция для записи куска во временный файл
    private static void writeChunkToFile(List<String> chunk, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : chunk) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // Функция для объединения отсортированных кусков
    private static void mergeChunks(String inputFileName, String outputFileName) throws IOException {
        PriorityQueue<BufferedReader> pq = new PriorityQueue<>(new Comparator<BufferedReader>() {
            @Override
            public int compare(BufferedReader br1, BufferedReader br2) {
                try {
                    String line1 = br1.readLine();
                    String line2 = br2.readLine();
                    if (line1 == null) return 1;
                    if (line2 == null) return -1;
                    return line1.compareTo(line2);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Создаем выходной файл и пишем в него отсортированные данные
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
             BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {

            // Открываем каждый отсортированный кусок и добавляем его BufferedReader в PriorityQueue
            String l;
            while ((l = reader.readLine()) != null) {
                pq.add(new BufferedReader(new StringReader(l)));
            }

            while (!pq.isEmpty()) {
                BufferedReader br = pq.poll();
                String line = br.readLine();
                if (line != null) {
                    writer.write(line);
                    writer.newLine();
                    pq.add(br);
                }
            }
        }

        // Удаляем временные файлы
        File tempChunkFile = new File(inputFileName);
        tempChunkFile.delete();
    }

    public static void main(String[] args) throws IOException {
        String inputFile = "large_input.txt";   // Имя большого входного файла
        String outputFile = "sorted_output.txt"; // Имя выходного файла с отсортированными данными

        externalSort(inputFile, outputFile);

        System.out.println("Сортировка завершена. Результаты сохранены в " + outputFile);
    }
}
