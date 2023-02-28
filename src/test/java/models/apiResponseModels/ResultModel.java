package models.apiResponseModels;

import lombok.Data;
import models.apiResponseModels.ProjectResponseModel;

import java.util.ArrayList;

@Data
public class ResultModel {
  ArrayList<ProjectResponseModel> entities;
}
