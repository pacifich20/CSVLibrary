package com.pacifich20.csvlibrary;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    /**
     * creates csv file with specified path and content
     *
     * @param filePath path of csv file
     * @param content  content written to csv file
     * @throws IOException if error occurs while writing file
     */
    public static void createFile(String filePath, List<List<String>> content) throws IOException {
        StringBuilder toBeWritten = new StringBuilder();

        for (List<String> row : content) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < row.size(); i++) {
                sb.append(row.get(i));

                if (i < row.size() - 1) {
                    sb.append(",");
                }
            }

            sb.append("\n");
            toBeWritten.append(sb);
        }

        if (toBeWritten.length() > 0) {
            toBeWritten.setLength(toBeWritten.length() - 1);
        }

        Files.writeString(Path.of(filePath), toBeWritten.toString());
    }

    /**
     * reads content of csv file and returns as list of lists
     *
     * @param filePath path of csv file
     * @return content of csv file as list of lists
     * @throws IOException if error occurs while reading file
     */
    public static List<List<String>> getFileContent(String filePath) throws IOException {
        List<List<String>> content = new ArrayList<>();

        for (String line : Files.readAllLines(Path.of(filePath))) {
            List<String> row = new ArrayList<>();
            String[] cells = line.split(",");

            for (String cell : cells) {
                row.add(cell);
            }

            content.add(row);
        }

        return content;
    }

    /**
     * retrieves specific row from csv file based on row number
     *
     * @param filePath  path of csv file being read
     * @param rowNumber number of row to retrieve
     * @return specified row from csv file as list of strings
     * @throws IOException if error occurs while reading file
     */
    public static List<String> getRow(String filePath, int rowNumber) throws IOException {
        List<List<String>> content = getFileContent(filePath);
        List<String> row = new ArrayList<>();

        for (int i = 1; i < content.size(); i++) {
            List<String> column = content.get(i);

            if (column.size() > rowNumber) {
                row.add(column.get(rowNumber));
            }
        }

        return row;
    }
}