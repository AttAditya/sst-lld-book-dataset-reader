package bookreader;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DatasetReader {
  private String fetchFileContent(String filePath) {
    try {
      return Files.readString(Paths.get(filePath));
    } catch (IOException e) {
      System.out.println("Could not read the file!");
    }

    return "";
  }

  private int[] extractOrder(String colNamesCSV) {
    String[] colNames = colNamesCSV.split(",");
    int[] order = new int[7];

    Map<String, Integer> colIndex = new HashMap<>();
    colIndex.put("name", 0);
    colIndex.put("author", 1);
    colIndex.put("user rating", 2);
    colIndex.put("reviews", 3);
    colIndex.put("price", 4);
    colIndex.put("year", 5);
    colIndex.put("genre", 6);

    for (int colOrder = 0; colOrder < colNames.length; colOrder++) {
      String colName = colNames[colOrder].toLowerCase();
      if (colIndex.containsKey(colName))
        order[colIndex.get(colName)] = colOrder;
    }

    return order;
  }

  private String[] extractDetails(String lineCSV, int[] order) {
    lineCSV += ",";
    
    List<String> tokens = new ArrayList<>();
    boolean stringMode = false;
    String token = "";

    for (int charIndex = 0; charIndex < lineCSV.length(); charIndex++) {
      char ch = lineCSV.charAt(charIndex);
      
      if (ch == '"') {
        if (token.length() == 0) {
          stringMode = true;
        } else if (stringMode) {
          stringMode = false;
          continue;
        }
      }

      if (ch == ',' && !stringMode) {
        tokens.add(token);
        token = "";
        stringMode = false;
        continue;
      }

      token += ch;
    }

    String[] extractedDetails = new String[7];
    for (int detailIndex = 0; detailIndex < 7; detailIndex++)
      extractedDetails[detailIndex] = tokens.get(order[detailIndex]);

    return extractedDetails;
  }

  private String[][] extractCSV(String rawData) {
    String[] lines = rawData.split("\n");
    String[][] extractedCSV = new String[lines.length - 1][];

    int[] order = extractOrder(lines[0]);

    for (int lineIndex = 1; lineIndex < lines.length; lineIndex++)
      extractedCSV[lineIndex - 1] = extractDetails(lines[lineIndex], order);

    return extractedCSV;
  }

  private Book compileBook(String[] bookDetails) {
    if (bookDetails == null || bookDetails.length < 7)
      return null;

    String name = bookDetails[0];
    String author = bookDetails[1];
    double userRating = Double.parseDouble(bookDetails[2]);
    int reviews = Integer.parseInt(bookDetails[3]);
    double price = Double.parseDouble(bookDetails[4]);
    int year = Integer.parseInt(bookDetails[5]);
    String genre = bookDetails[6];

    return new Book(name, author, userRating, reviews, price, year, genre);
  }

  public Book[] getBooks(String dataPath) {
    String rawData = fetchFileContent(dataPath);
    String[][] extractedCSV = extractCSV(rawData);
    Book[] books = new Book[extractedCSV.length];
    
    int bookIndex = 0;
    for (String[] details: extractedCSV)
      books[bookIndex++] = compileBook(details);
    
    return books;
  }
}
