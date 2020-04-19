package test;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class Splitter {

    public static final String SEPARATOR = " ";

    private Reader reader;
    private Cleaner cleaner;

    public Splitter(Reader reader, Cleaner cleaner) {
        this.reader = reader;
        this.cleaner = cleaner;
    }

    public Map<String, Integer> run(String fileLocation) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        String text = reader.readText(fileLocation);

        String[] splitedText = getTextSplit(text);

        List<String> cleanedWordList = cleaner.clearWords(splitedText);

        for (String word : cleanedWordList) {

            if (wordCountMap.containsKey(word)) {
                wordCountMap.put(word, wordCountMap.get(word) + 1);
            } else {
                wordCountMap.put(word, 1);
            }
        }

        return sortByValue(wordCountMap);
    }


    private String[] getTextSplit(String text) {
        return text.toLowerCase().split(SEPARATOR);
    }

    private Map<String, Integer> sortByValue(Map<String, Integer> wordCountMap) {
        return wordCountMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }

}
