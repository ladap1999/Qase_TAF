package configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles {
    public static String readFileContent() throws IOException {
        return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/src/test/resources/specialValidationData/WindowMassageData")));
    }
}
