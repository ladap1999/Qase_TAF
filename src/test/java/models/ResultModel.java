package models;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResultModel {
  ArrayList<ProjectResponseModel> entities;
}
