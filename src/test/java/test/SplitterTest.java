package test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;


@RunWith(MockitoJUnitRunner.class)
public class SplitterTest {

    @Mock
    private Reader reader;

    @Mock
    private Cleaner cleaner;

    @Test
    public void run() {

        Map<String, Integer> expectedMap = createResultMap();
        List<String> testList = createTestList();
        String text = "After school, Kamal took the girls to the old house.";

        Mockito.when(reader.readText(Mockito.anyString())).thenReturn(text);
        Mockito.when(cleaner.clearWords(new String[]{Mockito.anyString()})).thenReturn(testList);



        Splitter splitter = new Splitter(reader, cleaner);
        Map<String, Integer> result = splitter.run("text-test.txt");

        Assert.assertEquals(expectedMap.get("the"), result.get("the"));
        Assert.assertEquals(expectedMap.get("took"), result.get("took"));
        Assert.assertEquals(expectedMap.get("kamal"), result.get("kamal"));
        Assert.assertEquals(expectedMap.get("school"), result.get("school"));
        Assert.assertEquals(expectedMap.get("old"), result.get("old"));
        Assert.assertEquals(expectedMap.get("after"), result.get("after"));
        Assert.assertEquals(expectedMap.get("girls"), result.get("girls"));
        Assert.assertEquals(expectedMap.get("to"), result.get("to"));
        Assert.assertEquals(expectedMap.get("house"), result.get("house"));

    }

    private Map<String, Integer> createResultMap() {
        Map<String, Integer> result = new LinkedHashMap<>();
        result.put("the", 2);
        result.put("took", 1);
        result.put("kamal", 1);
        result.put("school", 1);
        result.put("old", 1);
        result.put("after", 1);
        result.put("girls", 1);
        result.put("to", 1);
        result.put("house", 1);

        return result;
    }

    private List<String> createTestList() {
        List<String> clearedTestList = new ArrayList<>(Arrays.asList(
                "after", "school", "kamal", "took", "the", "girls", "to", "the", "old", "house"
        ));

        return clearedTestList;
    }
}