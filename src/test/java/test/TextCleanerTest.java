package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TextCleanerTest {

    @Test
    public void clearWords() {

        String[] words = {
                "him.", "the:", "(house:)", "[you!", "open...", "car,", "man:",
                "gun;", "hunting)", "/good/", "[cat", "dog]", "bad?", "“fox",
                "table”", "London–Boston"
        };
        String[] expected = {
                "him", "the", "house", "you", "open", "car", "man",
                "gun", "hunting", "good", "cat", "dog", "bad", "fox",
                "table", "London"
        };

        TextCleaner textCleaner = new TextCleaner();
        List<String> clearWords = textCleaner.clearWords(words);

        Assert.assertEquals(expected[0], clearWords.get(0));
        Assert.assertEquals(expected[1], clearWords.get(1));
        Assert.assertEquals(expected[2], clearWords.get(2));
        Assert.assertEquals(expected[3], clearWords.get(3));
        Assert.assertEquals(expected[4], clearWords.get(4));
        Assert.assertEquals(expected[5], clearWords.get(5));
        Assert.assertEquals(expected[6], clearWords.get(6));
        Assert.assertEquals(expected[7], clearWords.get(7));
        Assert.assertEquals(expected[8], clearWords.get(8));
        Assert.assertEquals(expected[9], clearWords.get(9));
        Assert.assertEquals(expected[10], clearWords.get(10));
        Assert.assertEquals(expected[11], clearWords.get(11));
        Assert.assertEquals(expected[12], clearWords.get(12));
        Assert.assertEquals(expected[13], clearWords.get(13));
        Assert.assertEquals(expected[14], clearWords.get(14));
    }
}