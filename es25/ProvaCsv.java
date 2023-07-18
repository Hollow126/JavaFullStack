package es25;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class provaCsv {
 String CSV_FILE_NAME = "prova1";

List<String[]> dataLines = new ArrayList<>();
dataLines.add(new String[] 
  { "John", "Doe", "38", "Comment Data\nAnother line of comment data" });
dataLines.add(new String[] 
  { "Jane", "Doe, Jr.", "19", "She said \"I'm being quoted\"" });

    public static void main(String[]args)
    {
        
        System.out.println("ciao");
    }

public String escapeSpecialCharacters(String data) {
    String escapedData = data.replaceAll("\\R", " ");
    if (data.contains(",") || data.contains("\"") || data.contains("'")) {
        data = data.replace("\"", "\"\"");
        escapedData = "\"" + data + "\"";
    }
    return escapedData;
}
    public String convertToCSV(String[]data)
    {
        return Stream.of(data).map(this::escapeSpecialCharacters).collect(Collectors.joining(","));
    }

    public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
    File csvOutputFile = new File(CSV_FILE_NAME);
    try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
        dataLines.stream()
          .map(this::convertToCSV)
          .forEach(pw::println);
    }
    assertTrue(csvOutputFile.exists());
}

}
