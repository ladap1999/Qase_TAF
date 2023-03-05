package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Suite;
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

    public int addSuite(String projectCode, Suite expectedSuite) {
        logger.info("add new suite in project with code " + projectCode);
        loggerFile.info("add new suite in project with code " + projectCode);

        return given()
                .pathParam("code", projectCode)
                .body(expectedSuite, ObjectMapperType.GSON)
                .when()
                .post(Endpoints.ADD_SUITE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("result.id");
    }

    public Response getSuite(String projectCode, int suiteID) {
        logger.info("get case with id: " + suiteID + " from project with projectCode: " + projectCode);
        loggerFile.info("get case with id: " + suiteID + " from project with projectCode: " + projectCode);

        return given()
                .pathParam("code", projectCode)
                .pathParam("id", suiteID)
                .when()
                .get(Endpoints.GET_SUITE)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public Response getSuites(String projectCode) {
        logger.info("get suits from project with projectCode: " + projectCode);
        loggerFile.info("get suits from project with projectCode: " + projectCode);

        return given()
                .pathParam("code", projectCode)
                .when()
                .get(Endpoints.GET_INVALID_SUITES)
                .then()
                .extract()
                .response();

    }
}
