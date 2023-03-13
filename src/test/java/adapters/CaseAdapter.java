package adapters;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Case;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class CaseAdapter{
    Logger logger = LogManager.getLogger(CaseAdapter.class);
    Logger loggerFile = LogManager.getLogger("File");

    public int addCase(Case expectedCase, String projectCode) {
        logger.info("add new case to project: " + projectCode);
        loggerFile.info("add new case to project: " + projectCode);

        return given()
                .body(expectedCase, ObjectMapperType.GSON)
                .pathParam("code", projectCode)
                .when()
                .post(Endpoints.ADD_CASE)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("result.id");
    }

    public Response getCase(String projectCode, int caseID) {
        logger.info("get case with id: " + caseID + " from project with projectCode: " + projectCode);
        loggerFile.info("get case with id: " + caseID + " from project with projectCode: " + projectCode);

        return given()
                .pathParam("code", projectCode)
                .pathParam("id", caseID)
                .when()
                .get(Endpoints.GET_CASE)
                .then()
                .log().body()
                .extract()
                .response();
    }

    public void deleteCase(String projectCode, int caseID) {
        logger.info("delete case with id: " + caseID + " from project with projectCode: " + projectCode);
        loggerFile.info("delete case with id: " + caseID + " from project with projectCode: " + projectCode);

        given()
                .pathParam("code", projectCode)
                .pathParam("id", caseID)
                .when()
                .delete(Endpoints.DELETE_CASE)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
