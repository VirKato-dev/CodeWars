package tasks;

import java.io.*;
import java.util.Arrays;

/**
 * Имеется огромный файл (потенциально больше свободной памяти).
 * Содержит ключ, значение.
 * Отсортировать строки по ключу.
 */
public class BigTextFileSorter {

    public static void main(String[] args) {
        sort(new File("tmp", "big_file.txt"));
    }

    public static void sort(File source) {
        try (BufferedReader br = new BufferedReader(new FileReader(source))) {
            System.out.println("Separating...");
            String line;
            while ((line = br.readLine()) != null) {
                String fileName = line.substring(0, line.indexOf(':'));
                File lineFile = new File("tmp", fileName);
                lineFile.createNewFile();
                try (FileWriter fr = new FileWriter(lineFile)) {
                    fr.write(line);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Sorting...");
        File directory = new File("tmp");
        File[] files = directory.listFiles(pathname -> !pathname.getName().endsWith(".txt"));
        Arrays.sort(files);
        System.out.println(Arrays.toString(files));

        System.out.println("Writing...");
        File destination = new File("tmp", source.getName() + ".txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
            destination.delete();
            for (File file : files) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    bw.write(br.readLine() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
