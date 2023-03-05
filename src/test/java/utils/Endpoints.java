package utils;

public class Endpoints {
    public static final String ADD_PROJECT = "/project";
    public static final String GET_PROJECTS = "/project?limit=10&offset=0";
    public static final String GET_PROJECT = "/project/{code}";
    public static final String DELETE_PROJECT = "/project/{code}";
    public static final String ADD_SUITE = "/suite/{code}";
    public static final String GET_SUITE = "/suite/{code}/{id}";
    public static final String GET_INVALID_SUITES = "suite/{code}?limit=INVALID";
    public static final String ADD_CASE = "/case/{code}";
    public static final String GET_CASE = "/case/{code}/{id}";
    public static final String DELETE_CASE = "/case/{code}/{id}";
}
