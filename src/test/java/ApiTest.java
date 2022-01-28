package test.java;

import adapters.ProjectAdapter;
import models.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ApiTest {
    @Test (description = "Negative test for Create new project. Using an invalid value for the 'Code' field")
    public void negativeApiTest() {
        Project project = Project.builder().
                title("blabla").
                code("!!").
                build();
        ResponseStatusNegative actual = new ProjectAdapter().postProject(project, 422);
        ResponseStatusNegative expected = ResponseStatusNegative.builder()
                .status(false)
                .errorMessage("Data is invalid.")
                .build();

        assertEquals(actual, expected);
//        assertEquals(actual.isStatus(), expected.isStatus());
//        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());
    }


    @Test(description = "Positive test Create new project.")
    public void positiveApiTest() {
        Project project = Project.builder().
                title("ForApiTestProject").
                code("QWERT").
                build();

        ResponseStatusPositive actual = new ProjectAdapter().postCreateProject(project, 200);
        ResponseStatusPositive expected = ResponseStatusPositive.builder()
                .status(true)
                .result(Result.builder()
                        .code("QWERT")
                        .build())
                .build();
        assertEquals(actual, expected);
    }


    @Test(description = "A positive test for a get request for a project with one test case")
    public void getProjectTest() {
        ResponseStatusPositive actual = new ProjectAdapter().getProjectPositive(200, "SLYTHERIN");
        ResponseStatusPositive expected = ResponseStatusPositive.builder()
                .status(true)
                .result(Result.builder()
                        .title("Harry Potter and the Goblet of Fire")
                        .code("SLYTHERIN").counts(Counts.builder().cases(1)
                                .build())
                        .build())
                .build();

        assertEquals(actual,expected);
    }

    @Test(description = "A positive test for a get request for a project with no test cases")
    public void getProjectTestEmptyProject() {
        ResponseStatusPositive actual = new ProjectAdapter().getProjectPositive(200, "THUNDERBIR");
        ResponseStatusPositive expected = ResponseStatusPositive.builder()
                .status(true)
                .result(Result.builder()
                        .title("Harry Potter and the Deathly Hallows")
                        .code("THUNDERBIR").counts(Counts.builder().cases(0)
                                .build())
                        .build())
                .build();

        assertEquals(actual,expected);
    }


    @Test (description = "Negative test Get Project by code. Using non-existent codeProject")
    public void getProjectTestNegative(){
        ResponseStatusNegative actual = new ProjectAdapter().getProjectNegative(404, "DR");
        ResponseStatusNegative expected = ResponseStatusNegative.builder()
                .status(false)
                .errorMessage("Project is not found.")
                .build();
        assertEquals(actual,expected);
    }
}
