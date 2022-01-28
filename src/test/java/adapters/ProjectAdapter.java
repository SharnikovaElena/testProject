package test.java.adapters;

import models.Project;
import models.ResponseStatusNegative;
import models.ResponseStatusPositive;


public class ProjectAdapter extends BaseAdapter {

    public ResponseStatusNegative postProject(Project project, int statusCode) {
        String response = super.post(gson.toJson(project, Project.class), statusCode, "project");
        return gson.fromJson(response, ResponseStatusNegative.class);
    }

    public ResponseStatusPositive postCreateProject(Project project, int statusCode) {
        String response = super.post(gson.toJson(project, Project.class), statusCode, "project");
        return gson.fromJson(response, ResponseStatusPositive.class);
    }


    public ResponseStatusNegative getProjectNegative (int statusCode, String codeProject){
        return gson.fromJson(get(statusCode,"project/" + codeProject), ResponseStatusNegative.class);
    }

    public ResponseStatusPositive getProjectPositive (int statusCode, String codeProject){
        return gson.fromJson(get(statusCode,"project/" + codeProject), ResponseStatusPositive.class);
    }
}

