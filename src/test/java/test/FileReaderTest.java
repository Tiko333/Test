package test;

import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {

    @Test
    public void readTextSuccessTest() {

        String text = "After school, Kamal took the girls to the old house.";
        FileReader fileReader = new FileReader();
        String result = fileReader.readText("text-test.txt");

        Assert.assertEquals(text, result);
    }

    @Test
    public void readTextFailTest() {
        String text = "After school, Kamal took the girls to the old house.";
        FileReader fileReader = new FileReader();
        String result = fileReader.readText("text.txt");


        Assert.assertNotEquals(text, result);
    }
}