package stepDefs;

import adapters.ProjectAdapter;
import baseEntities.BaseCucumberTest;
import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static io.restassured.RestAssured.given;

public class Hook extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;
    protected String projectCode;
    protected ProjectAdapter projectAdapter;
    Logger logger = LogManager.getLogger(Hook.class);
    Logger loggerFile = LogManager.getLogger("File");

    public Hook(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Before(value = "@api", order = 1)
    public void setupApi() {
        logger.info("Authorization in Qase.io");
        loggerFile.info("Authorization in Qase.io");

        projectAdapter = new ProjectAdapter();

        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        RestAssured.baseURI = ReadProperties.getApiUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .header("token", ReadProperties.getApiKey());
    }

    @Before(value = "@api", order = 2)
    public void addProject() throws IOException {
        logger.info("Create Project API request");
        loggerFile.info("Create Project API request");

        InputStream stream = this.getClass().getResourceAsStream("/postJsonData/ProjectBody.json");
        String projectToAdd = CharStreams.toString(new InputStreamReader(stream));

        projectCode = projectAdapter.addProject(projectToAdd);
    }

    @After(value = "@api")
    public void clearTestData() {
        logger.info("Clear project with code " + projectCode);
        loggerFile.info("Clear project with code " + projectCode);

        projectAdapter.deleteProject(projectCode);
    }
}
