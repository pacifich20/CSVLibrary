package com.pacifich20.csvlibrary;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<String>> content = Arrays.asList(
                Arrays.asList("Name", "Age", "City"),
                Arrays.asList("John", "25", "New York"),
                Arrays.asList("Alice", "30", "London")
        );

        try {
            CSVUtils.createFile("test.csv", content);

            List<List<String>> fileContent = CSVUtils.getFileContent("test.csv");
            System.out.println("File Content:\n" + fileContent);

            int rowNumber = 2;
            List<String> row = CSVUtils.getRow("test.csv", rowNumber);
            System.out.println("Row " + rowNumber + ": " + row);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}