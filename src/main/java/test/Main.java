package test;

import java.io.*;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class Main {

    public static final String FILE_LOCATION = "/home/tiko/Documents/TestTask/src/main/resources/text.txt";
    public static final String DOT = ".";
    public static final String SEPARATOR = " ";

    public static void main(String[] args) {

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_LOCATION));) {

            String currentLine = reader.readLine();

            while (currentLine != null) {

                String[] words = currentLine.toLowerCase().split(SEPARATOR);

                for (String word : words) {

                    word = removeEndDot(word);

                    if (wordCountMap.containsKey(word)) {
                        wordCountMap.put(word, wordCountMap.get(word) + 1);
                    } else {
                        wordCountMap.put(word, 1);
                    }
                }

                currentLine = reader.readLine();
            }

            System.out.println(sortByValue(wordCountMap));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String removeEndDot(String word) {
        if (word.lastIndexOf(DOT) != -1) {
            word = word.substring(0, word.lastIndexOf(DOT));
        }
        return word;
    }

    public static Map<String, Integer> sortByValue(HashMap<String, Integer> wordCountMap) {

        Map<String, Integer> sorted = wordCountMap
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
                                LinkedHashMap::new));

        sorted = wordCountMap
                .entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        sorted = wordCountMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));

        return sorted;
    }
}
