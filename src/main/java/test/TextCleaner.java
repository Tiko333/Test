package test;

import java.util.ArrayList;
import java.util.List;

public class TextCleaner implements Cleaner {
    public static final String DOT = ".";
    public static final String COMMA = ",";
    public static final String QUESTION_SIGN = "?";
    public static final String OPENING_QUOTE = "“";
    public static final String CLOSING_QUOTE = "”";
    public static final String EXCLAMATION_SIGN = "!";
    public static final String TWO_DOTS = "..";
    public static final String COLUMN = ":";
    public static final String SEMI_COLUMN = ";";
    public static final String OPENING_PARENTHESES = "(";
    public static final String CLOSING_PARENTHESES = ")";
    public static final String SLASH = "/";
    public static final String OPENING_BRACKETS = "[";
    public static final String CLOSING_BRACKETS = "]";
    public static final String DASH = "–";
    public static final String EMPTY_STRING = "";

    @Override
    public List<String> clearWords(String[] splitedWords) {
        final List<String> list = new ArrayList<>();

        for (String splitedWord : splitedWords) {
            String clearedWord = clearWord(splitedWord, list);

            if (!clearedWord.equals(EMPTY_STRING)) {
                list.add(clearedWord);
            }
        }

        return list;
    }

    private String clearWord(String word, List<String> list) {
        if (word.lastIndexOf(DOT) != -1) {
            word = word.substring(0, word.lastIndexOf(DOT));
        }
        if (word.endsWith(TWO_DOTS)) {
            word = word.substring(0, word.indexOf(DOT));
        }
        if (word.lastIndexOf(COMMA) != -1) {
            word = word.substring(0, word.lastIndexOf(COMMA));
        }
        if (word.lastIndexOf(COLUMN) != -1) {
            word = word.substring(0, word.lastIndexOf(COLUMN));
        }
        if (word.lastIndexOf(SEMI_COLUMN) != -1) {
            word = word.substring(0, word.lastIndexOf(SEMI_COLUMN));
        }
        if (word.indexOf(OPENING_PARENTHESES) == 0) {
            word = word.substring(1);
        }
        if (word.lastIndexOf(CLOSING_PARENTHESES) != -1) {
            word = word.substring(0, word.lastIndexOf(CLOSING_PARENTHESES));
        }
        if (word.indexOf(SLASH) == 0) {
            word = word.substring(1);
        }
        if (word.lastIndexOf(SLASH) != -1) {
            word = word.substring(0, word.lastIndexOf(SLASH));
        }
        if (word.indexOf(OPENING_BRACKETS) == 0) {
            word = word.substring(1);
        }
        if (word.lastIndexOf(CLOSING_BRACKETS) != -1) {
            word = word.substring(0, word.lastIndexOf(CLOSING_BRACKETS));
        }
        if (word.lastIndexOf(QUESTION_SIGN) != -1) {
            word = word.substring(0, word.lastIndexOf(QUESTION_SIGN));
        }
        if (word.lastIndexOf(EXCLAMATION_SIGN) != -1) {
            word = word.substring(0, word.lastIndexOf(EXCLAMATION_SIGN));
        }
        if (word.indexOf(OPENING_QUOTE) == 0) {
            word = word.substring(1);
        }
        if (word.lastIndexOf(CLOSING_QUOTE) != -1) {
            word = word.substring(0, word.lastIndexOf(CLOSING_QUOTE));
        }

        if (word.contains(DASH)) {
            String nextWord = word.substring(word.indexOf(DASH) + 1);
            list.add(nextWord);
            word = word.substring(0, word.indexOf(DASH));
        }

        return word;
    }

}
