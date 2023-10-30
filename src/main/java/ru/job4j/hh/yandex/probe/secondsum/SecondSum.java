package ru.job4j.hh.yandex.probe.secondsum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class SecondSum {

    public static void main(String[] args) throws IOException {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        writeResultToFile(outputFile, readNumbersFromFileAndSumThem(inputFile));
    }

    private static int readNumbersFromFileAndSumThem(String path) throws IOException {
        Path filePath = Paths.get(path);
        Scanner scanner = new Scanner(filePath);
        int sum = 0;
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            } else {
                scanner.next();
            }
        }
        return sum;
    }

    private static void writeResultToFile(String path, int number) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(valueOf(number));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
