package configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles {
    public static String readFileContent(String fileName) throws IOException {
        return Files.readString(Paths.get("src/test/resources/specialValidationData/" + fileName));
    }
}
