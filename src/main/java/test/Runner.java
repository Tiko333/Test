package test;

import java.util.*;

public class Runner {

    public static final String FILE_NAME = "text.txt";
    public static final String EQUALS_SIGN = "=";

    public static void main(String[] args) {

        Reader reader = new FileReader();
        Cleaner cleaner = new TextCleaner();

        Splitter splitter = new Splitter(reader, cleaner);
        Map<String, Integer> result = splitter.run(FILE_NAME);
        printMap(result);
    }


    private static void printMap(Map<String, Integer> wordCountMap) {
        wordCountMap
                .forEach((key, value) -> System.out.println(key + EQUALS_SIGN + value));
    }

}
