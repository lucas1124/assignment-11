import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Write a java program to count words in an input file and write the results to an output file.

public class App {
public static void main(String[] args) {
Map<String, Integer> wordCounts = new HashMap<>();

try (BufferedReader reader = new BufferedReader(new FileReader("src/word.txt"))) {
String line;
while ((line = reader.readLine()) != null) {
String word = line.toLowerCase();
int count = wordCounts.getOrDefault(word, 0);
wordCounts.put(word, count + 1);
}
} catch (IOException e) {
System.err.println("Error reading input file: " + e.getMessage());
return;
}

try (FileWriter writer = new FileWriter("src/output.txt")) {
for (String word : wordCounts.keySet()) {
int count = wordCounts.get(word);
writer.write(word + " " + count + "\n");
}
} catch (IOException e) {
System.err.println("Error writing output file: " + e.getMessage());
return;
}

System.out.println("Word counts written to " + "src/output.txt");
}
}