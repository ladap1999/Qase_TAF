package adapters;

import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class SuiteAdapter extends BaseAdapter {
    Logger logger = LogManager.getLogger(ProjectAdapter.class);
    Logger loggerFile = LogManager.getLogger("File");

    public void addSuite(String projectCode, String expectedSuite) {
        logger.info("add new suite in project with code " + projectCode);
        loggerFile.info("add new suite in project with code " + projectCode);

        given()
                .pathParam("code", projectCode)
                .body(expectedSuite)
                .when()
                .post(Endpoints.ADD_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}
