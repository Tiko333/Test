package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileReader implements Reader {

    @Override
    public String readText(String fileName) {

        ClassLoader classLoader = FileReader.class.getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());

        String content = null;
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }
}
