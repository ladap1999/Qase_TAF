package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.apiResponseModels.AllProjectsResponseModel;
import org.apache.hc.core5.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter {
    Logger logger = LogManager.getLogger(ProjectAdapter.class);
    Logger loggerFile = LogManager.getLogger("File");

    public String addProject(String expectedProject) {
        logger.info("add new project");
        loggerFile.info("add new project");

        return given()
                .body(expectedProject)
                .when()
                .post(Endpoints.ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("result.code");
    }

    public AllProjectsResponseModel getProjects() {
        logger.info("get all projects");
        loggerFile.info("get all projects");

        return given()
                .when()
                .get(Endpoints.GET_PROJECTS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(AllProjectsResponseModel.class, ObjectMapperType.GSON);
    }

    public void deleteProject(String projectCode) {
        logger.info("delete project with code " + projectCode);
        loggerFile.info("delete project with code " + projectCode);

        given()
                .pathParam("code", projectCode)
                .when()
                .delete(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
