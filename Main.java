// --== CS400 File Header Information ==--
// Name: Otto Leffel
// Email: oleffel@wisc.edu
// Team: IG
// Role: Front End Developer 2
// TA: Mu Cai
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Backend backend = new Backend();
            TabPane tabpane = new TabPane();
            // "Add Major" Tab Setup
            Tab addMajorTab = new Tab("Add Major");
            addMajorTab.setClosable(false);
            Label addMajorNameLabel = new Label("Major Name:");
            TextField addMajorNameTextField = new TextField();
            setStandardSize(addMajorNameTextField);
            Button addMajorInputButton = new Button("Submit");
            Label addMajorOutcomeLabel = new Label("");
            addMajorInputButton.setOnAction(e -> {
                Boolean result = backend.addMajor(addMajorNameTextField.getText());
                if (result) {
                    addMajorOutcomeLabel
                            .setText("The major \"" + addMajorNameTextField.getText() + "\" was successfully added");
                } else {
                    addMajorOutcomeLabel
                            .setText("The major \"" + addMajorNameTextField.getText() + "\" was unable to be added");
                }
            });
            GridPane addMajorPane = new GridPane();
            addMajorPane.addRow(0, addMajorNameLabel);
            addMajorPane.addRow(1, addMajorNameTextField);
            addMajorPane.addRow(2, addMajorInputButton);
            addMajorPane.addRow(3, addMajorOutcomeLabel);
            addMajorPane.setVgap(5);
            addMajorPane.setPadding(new Insets(7, 7, 7, 7));
            addMajorTab.setContent(addMajorPane);
            tabpane.getTabs().add(addMajorTab);
            // "Delete Major" Tab Setup
            Tab deleteMajorTab = new Tab("Delete Major");
            deleteMajorTab.setClosable(false);
            Label deleteMajorNameLabel = new Label("Major Name:");
            TextField deleteMajorNameTextField = new TextField();
            setStandardSize(deleteMajorNameTextField);
            Button deleteMajorInputButton = new Button("Submit");
            Label deleteMajorOutcomeLabel = new Label("");
            deleteMajorInputButton.setOnAction(e -> {
                String majorName = deleteMajorNameTextField.getText();
                if (backend.deleteMajor(majorName) == null) {
                    deleteMajorOutcomeLabel.setText("The major \"" + majorName + "\" was unable to be deleted.");
                } else {
                    deleteMajorOutcomeLabel.setText("The major \"" + majorName + "\" was successfully deleted.");
                }
            });
            GridPane deleteMajorPane = new GridPane();
            deleteMajorPane.addRow(0, deleteMajorNameLabel);
            deleteMajorPane.addRow(1, deleteMajorNameTextField);
            deleteMajorPane.addRow(2, deleteMajorInputButton);
            deleteMajorPane.addRow(3, deleteMajorOutcomeLabel);
            deleteMajorPane.setVgap(5);
            deleteMajorPane.setPadding(new Insets(7, 7, 7, 7));
            deleteMajorTab.setContent(deleteMajorPane);
            tabpane.getTabs().add(deleteMajorTab);
            // "Check Major" Tab Setup
            Tab checkMajorTab = new Tab("Check Major");
            checkMajorTab.setClosable(false);
            Label checkMajorNameLabel = new Label("Major Name:");
            TextField checkMajorNameTextField = new TextField();
            setStandardSize(checkMajorNameTextField);
            Button checkMajorInputButton = new Button("Submit");
            Label checkMajorOutcomeLabel = new Label("");
            checkMajorInputButton.setOnAction(e -> {
                String majorName = checkMajorNameTextField.getText();
                if (backend.checkMajor(majorName)) {
                    checkMajorOutcomeLabel.setText("The major \"" + majorName + "\" does exist");
                } else {
                    checkMajorOutcomeLabel.setText("The major \"" + majorName + "\" does not exist");
                }
            });
            GridPane checkMajorPane = new GridPane();
            checkMajorPane.addRow(0, checkMajorNameLabel);
            checkMajorPane.addRow(1, checkMajorNameTextField);
            checkMajorPane.addRow(2, checkMajorInputButton);
            checkMajorPane.addRow(3, checkMajorOutcomeLabel);
            checkMajorPane.setVgap(5);
            checkMajorPane.setPadding(new Insets(7, 7, 7, 7));
            checkMajorTab.setContent(checkMajorPane);
            tabpane.getTabs().add(checkMajorTab);
            // "Add Course" Tab Setup
            Tab addCourseTab = new Tab("Add Course");
            addCourseTab.setClosable(false);
            Label addCourseMajorNameLabel = new Label("Major Name:");
            TextField addCourseMajorNameTextField = new TextField();
            setStandardSize(addCourseMajorNameTextField);
            Label addCourseCourseNameLabel = new Label("Course Name:");
            TextField addCourseCourseNameTextField = new TextField();
            setStandardSize(addCourseCourseNameTextField);
            Button addCourseInputButton = new Button("Submit");
            Label addCourseOutcomeLabel = new Label("");
            addCourseInputButton.setOnAction(e -> {
                String majorName = addCourseMajorNameTextField.getText();
                String courseName = addCourseCourseNameTextField.getText();
                if (backend.addCourse(majorName, courseName)) {
                    addCourseOutcomeLabel.setText("The course \"" + courseName
                            + "\" was successfully added to the major \"" + majorName + "\"");
                } else {
                    addCourseOutcomeLabel.setText("The course \"" + courseName
                            + "\" was unable to be added to the major \"" + majorName + "\"");
                }
            });
            GridPane addCoursePane = new GridPane();
            addCoursePane.addRow(0, addCourseMajorNameLabel);
            addCoursePane.addRow(1, addCourseMajorNameTextField);
            addCoursePane.addRow(2, addCourseCourseNameLabel);
            addCoursePane.addRow(3, addCourseCourseNameTextField);
            addCoursePane.addRow(4, addCourseInputButton);
            addCoursePane.addRow(5, addCourseOutcomeLabel);
            addCoursePane.setVgap(5);
            addCoursePane.setPadding(new Insets(7, 7, 7, 7));
            addCourseTab.setContent(addCoursePane);
            tabpane.getTabs().add(addCourseTab);
            // "Remove Course" Tab Setup
            Tab removeCourseTab = new Tab("Remove Course");
            removeCourseTab.setClosable(false);
            Label removeCourseMajorNameLabel = new Label("Major Name:");
            TextField removeCourseMajorNameTextField = new TextField();
            setStandardSize(removeCourseMajorNameTextField);
            Label removeCourseCourseNameLabel = new Label("Course Name:");
            TextField removeCourseCourseNameTextField = new TextField();
            setStandardSize(removeCourseCourseNameTextField);
            Button removeCourseInputButton = new Button("Submit");
            Label removeCourseOutcomeLabel = new Label("");
            removeCourseInputButton.setOnAction(e -> {
                String majorName = removeCourseMajorNameTextField.getText();
                String courseName = removeCourseCourseNameTextField.getText();
                if (backend.checkMajor(majorName)) {
                    if (backend.removeCourse(majorName, courseName)) {
                        removeCourseOutcomeLabel.setText("The course with the name \"" + courseName
                                + "\" was successfully removed from the major \"" + majorName + "\"");
                    } else {
                        removeCourseOutcomeLabel.setText("The course with the name \"" + courseName
                                + "\" was unable to be removed from the major \"" + majorName + "\"");
                    }
                } else {
                    removeCourseOutcomeLabel.setText("The course with the name \"" + courseName
                            + "\" was unable to be removed from the major \"" + majorName + "\"");
                }
            });
            GridPane removeCoursePane = new GridPane();
            removeCoursePane.addRow(0, removeCourseMajorNameLabel);
            removeCoursePane.addRow(1, removeCourseMajorNameTextField);
            removeCoursePane.addRow(2, removeCourseCourseNameLabel);
            removeCoursePane.addRow(3, removeCourseCourseNameTextField);
            removeCoursePane.addRow(4, removeCourseInputButton);
            removeCoursePane.addRow(5, removeCourseOutcomeLabel);
            removeCoursePane.setVgap(5);
            removeCoursePane.setPadding(new Insets(7, 7, 7, 7));
            removeCourseTab.setContent(removeCoursePane);
            tabpane.getTabs().add(removeCourseTab);
            // "Search Course" Tab Setup
            Tab searchCourseTab = new Tab("Search Course");
            searchCourseTab.setClosable(false);
            Label searchCourseMajorNameLabel = new Label("Major Name:");
            TextField searchCourseMajorNameTextField = new TextField();
            setStandardSize(searchCourseMajorNameTextField);
            Label searchCourseCourseNameLabel = new Label("Course Name:");
            TextField searchCourseCourseNameTextField = new TextField();
            setStandardSize(searchCourseCourseNameTextField);
            Button searchCourseInputButton = new Button("Submit");
            Label searchCourseOutcomeLabel = new Label("");
            searchCourseInputButton.setOnAction(e -> {
                String majorName = searchCourseMajorNameTextField.getText();
                String courseName = searchCourseCourseNameTextField.getText();
                if (backend.checkMajor(majorName)) {
                    if (backend.searchCourse(majorName, courseName)) {
                        searchCourseOutcomeLabel.setText("The course with the name \"" + courseName
                                + "\" does exist within the major \"" + majorName + "\"");
                    } else {
                        searchCourseOutcomeLabel.setText("The course with the name \"" + courseName
                                + "\" does not exist within" + " the major \"" + majorName + "\"");
                    }
                } else {
                    searchCourseOutcomeLabel.setText("The course with the name \"" + courseName
                            + "\" does not exist within" + " the major \"" + majorName + "\"");
                }
            });
            GridPane searchCoursePane = new GridPane();
            searchCoursePane.addRow(0, searchCourseMajorNameLabel);
            searchCoursePane.addRow(1, searchCourseMajorNameTextField);
            searchCoursePane.addRow(2, searchCourseCourseNameLabel);
            searchCoursePane.addRow(3, searchCourseCourseNameTextField);
            searchCoursePane.addRow(4, searchCourseInputButton);
            searchCoursePane.addRow(5, searchCourseOutcomeLabel);
            searchCoursePane.setVgap(5);
            searchCoursePane.setPadding(new Insets(7, 7, 7, 7));
            searchCourseTab.setContent(searchCoursePane);
            tabpane.getTabs().add(searchCourseTab);
            // "Add Course Connection" Tab Setup
            Tab addCourseConnectionTab = new Tab("Add Course Connection");
            addCourseConnectionTab.setClosable(false);
            Label addCourseConnectionMajorNameLabel = new Label("Major Name:");
            TextField addCourseConnectionMajorNameTextField = new TextField();
            setStandardSize(addCourseConnectionMajorNameTextField);
            Label addCourseConnectionPreNameLabel = new Label("Prerequisite Course Name:");
            TextField addCourseConnectionPreNameTextField = new TextField();
            setStandardSize(addCourseConnectionPreNameTextField);
            Label addCourseConnectionDepNameLabel = new Label("Dependent Course Name:");
            TextField addCourseConnectionDepNameTextField = new TextField();
            setStandardSize(addCourseConnectionDepNameTextField);
            Label addCourseConnectionCreditsLabel = new Label("Credit Count:");
            TextField addCourseConnectionCreditsTextField = new TextField();
            setStandardSize(addCourseConnectionCreditsTextField);
            Button addCourseConnectionInputButton = new Button("Submit");
            Label addCourseConnectionOutcomeLabel = new Label("");
            addCourseConnectionInputButton.setOnAction(e -> {
                String majorName = addCourseConnectionMajorNameTextField.getText();
                String courseNamePre = addCourseConnectionPreNameTextField.getText();
                String courseNameDep = addCourseConnectionDepNameTextField.getText();
                try {
                    if (backend.checkMajor(majorName)) {
                        int creditCount = Integer.parseInt(addCourseConnectionCreditsTextField.getText());
                        if (backend.addCourseConnection(majorName, courseNamePre, courseNameDep, creditCount)) {
                            addCourseConnectionOutcomeLabel.setText("The course connection in the major \"" + majorName
                                    + "\" with a credit count of \"" + creditCount + "\" between the courses \""
                                    + courseNamePre + "\" and \"" + courseNameDep + "\" was successfully added");
                        } else {
                            addCourseConnectionOutcomeLabel.setText("The course connection in the major \"" + majorName
                                    + "\" with a credit count of \"" + creditCount + "\" between the courses \""
                                    + courseNamePre + "\" and \"" + courseNameDep + "\" was unable to be added");
                        }
                    } else {
                        addCourseConnectionOutcomeLabel.setText(
                                "The course connection in the major \"" + majorName + "\" between the courses \""
                                        + courseNamePre + "\" and \"" + courseNameDep + "\" was unable to be added");
                    }
                } catch (java.lang.NumberFormatException exception) {
                    addCourseConnectionOutcomeLabel.setText("Please input an integer for the credit count");
                }
            });
            GridPane addCourseConnectionPane = new GridPane();
            addCourseConnectionPane.addRow(0, addCourseConnectionMajorNameLabel);
            addCourseConnectionPane.addRow(1, addCourseConnectionMajorNameTextField);
            addCourseConnectionPane.addRow(2, addCourseConnectionPreNameLabel);
            addCourseConnectionPane.addRow(3, addCourseConnectionPreNameTextField);
            addCourseConnectionPane.addRow(4, addCourseConnectionDepNameLabel);
            addCourseConnectionPane.addRow(5, addCourseConnectionDepNameTextField);
            addCourseConnectionPane.addRow(6, addCourseConnectionCreditsLabel);
            addCourseConnectionPane.addRow(7, addCourseConnectionCreditsTextField);
            addCourseConnectionPane.addRow(8, addCourseConnectionInputButton);
            addCourseConnectionPane.addRow(9, addCourseConnectionOutcomeLabel);
            addCourseConnectionPane.setVgap(5);
            addCourseConnectionPane.setPadding(new Insets(7, 7, 7, 7));
            addCourseConnectionTab.setContent(addCourseConnectionPane);
            tabpane.getTabs().add(addCourseConnectionTab);
            // "Remove Course Connection" Tab Setup
            Tab removeCourseConnectionTab = new Tab("Remove Course Connection");
            removeCourseConnectionTab.setClosable(false);
            Label removeCourseConnectionMajorNameLabel = new Label("Major Name:");
            TextField removeCourseConnectionMajorNameTextField = new TextField();
            setStandardSize(removeCourseConnectionMajorNameTextField);
            Label removeCourseConnectionPreNameLabel = new Label("Prerequisite Class Name:");
            TextField removeCourseConnectionPreNameTextField = new TextField();
            setStandardSize(removeCourseConnectionPreNameTextField);
            Label removeCourseConnectionDepNameLabel = new Label("Dependent Class Name:");
            TextField removeCourseConnectionDepNameTextField = new TextField();
            setStandardSize(removeCourseConnectionDepNameTextField);
            Button removeCourseConnectionInputButton = new Button("Submit");
            Label removeCourseConnectionOutcomeLabel = new Label("");
            removeCourseConnectionInputButton.setOnAction(e -> {
                String majorName = removeCourseConnectionMajorNameTextField.getText();
                String courseNamePre = removeCourseConnectionPreNameTextField.getText();
                String courseNameDep = removeCourseConnectionDepNameTextField.getText();
                try {
                    if (backend.removeCourseConnection(majorName, courseNamePre, courseNameDep)) {
                        removeCourseConnectionOutcomeLabel.setText(
                                "The course connection in the major \"" + majorName + "\" between the courses \""
                                        + courseNamePre + "\" and \"" + courseNameDep + "\" was successfully removed");
                    } else {
                        removeCourseConnectionOutcomeLabel.setText(
                                "The course connection in the major \"" + majorName + "\" between the courses \""
                                        + courseNamePre + "\" and \"" + courseNameDep + "\" was unable to be removed");
                    }
                } catch (java.util.NoSuchElementException exception) {
                    removeCourseConnectionOutcomeLabel
                            .setText("The course connection in the major \"" + majorName + "\" between the courses \""
                                    + courseNamePre + "\" and \"" + courseNameDep + "\" was unable to be removed");
                }
            });
            GridPane removeCourseConnectionPane = new GridPane();
            removeCourseConnectionPane.addRow(0, removeCourseConnectionMajorNameLabel);
            removeCourseConnectionPane.addRow(1, removeCourseConnectionMajorNameTextField);
            removeCourseConnectionPane.addRow(2, removeCourseConnectionPreNameLabel);
            removeCourseConnectionPane.addRow(3, removeCourseConnectionPreNameTextField);
            removeCourseConnectionPane.addRow(4, removeCourseConnectionDepNameLabel);
            removeCourseConnectionPane.addRow(5, removeCourseConnectionDepNameTextField);
            removeCourseConnectionPane.addRow(6, removeCourseConnectionInputButton);
            removeCourseConnectionPane.addRow(7, removeCourseConnectionOutcomeLabel);
            removeCourseConnectionPane.setVgap(5);
            removeCourseConnectionPane.setPadding(new Insets(7, 7, 7, 7));
            removeCourseConnectionTab.setContent(removeCourseConnectionPane);
            tabpane.getTabs().add(removeCourseConnectionTab);
            // "Find Course Dependencies" Tab Setup
            Tab findCourseDependenciesTab = new Tab("Find Course Dependencies");
            findCourseDependenciesTab.setClosable(false);
            Label findCourseDependenciesMajorNameLabel = new Label("Major Name:");
            TextField findCourseDependenciesMajorNameTextField = new TextField();
            setStandardSize(findCourseDependenciesMajorNameTextField);
            Label findCourseDependenciesCourseNameLabel = new Label("Course Name:");
            TextField findCourseDependenciesCourseNameTextField = new TextField();
            setStandardSize(findCourseDependenciesCourseNameTextField);
            Button findCourseDependenciesInputButton = new Button("Submit");
            Label findCourseDependenciesOutcomeLabel = new Label("");
            findCourseDependenciesInputButton.setOnAction(e -> {
                String majorName = findCourseDependenciesMajorNameTextField.getText();
                String course = findCourseDependenciesCourseNameTextField.getText();
                if (!backend.checkMajor(majorName) || !backend.searchCourse(majorName, course)) {
                    findCourseDependenciesOutcomeLabel
                            .setText("The course \"" + course + "\" does not exist in the major \"" + majorName);
                } else {
                    String output = backend.findCourseDependencies(majorName, course);
                    findCourseDependenciesOutcomeLabel.setText("Original Major: " + majorName + "\n" + output);
                }
            });
            GridPane findCourseDependenciesPane = new GridPane();
            findCourseDependenciesPane.addRow(0, findCourseDependenciesMajorNameLabel);
            findCourseDependenciesPane.addRow(1, findCourseDependenciesMajorNameTextField);
            findCourseDependenciesPane.addRow(2, findCourseDependenciesCourseNameLabel);
            findCourseDependenciesPane.addRow(3, findCourseDependenciesCourseNameTextField);
            findCourseDependenciesPane.addRow(4, findCourseDependenciesInputButton);
            findCourseDependenciesPane.addRow(5, findCourseDependenciesOutcomeLabel);
            findCourseDependenciesPane.setVgap(5);
            findCourseDependenciesPane.setPadding(new Insets(7, 7, 7, 7));
            findCourseDependenciesTab.setContent(findCourseDependenciesPane);
            tabpane.getTabs().add(findCourseDependenciesTab);
            // "Load Examples" Tab Setup
            Tab loadExamplesTab = new Tab("Load Examples");
            loadExamplesTab.setClosable(false);
            Button loadExamplesButton = new Button("Load Examples");
            Label loadExamplesLabel = new Label("");
            loadExamplesButton.setOnAction(e -> {
                try {
                    String compsci = "Computer Science";
                    String math = "Mathematics";
                    String econ = "Economics";
                    backend.addMajor(compsci);
                    backend.addMajor(math);
                    backend.addMajor(econ);
                    String CSFile = "./CSMajor.txt";
                    String EconFile = "./EconMajor.txt";
                    String MathFile = "./MathMajor.txt";
                    File csMajor = new File(CSFile);
                    File econMajor = new File(EconFile);
                    File mathMajor = new File(MathFile);
                    MajorMaker.maker(csMajor, compsci, backend);
                    MajorMaker.maker(econMajor, econ, backend);
                    MajorMaker.maker(mathMajor, math, backend);
                    loadExamplesLabel
                            .setText("Example courses loaded for Computer Science, Mathematics, and Economics majors");
                } catch (java.util.NoSuchElementException exception) {
                    loadExamplesLabel.setText("Examples courses unable to be loaded");
                }
            });
            GridPane loadExamplesPane = new GridPane();
            loadExamplesPane.addRow(0, loadExamplesButton);
            loadExamplesPane.addRow(1, loadExamplesLabel);
            loadExamplesPane.setPadding(new Insets(7, 7, 7, 7));
            loadExamplesPane.setVgap(5);
            loadExamplesTab.setContent(loadExamplesPane);
            tabpane.getTabs().add(loadExamplesTab);
            // TabPane Setup
            Scene scene = new Scene(tabpane, 1100, 400);
            primaryStage.setTitle("Banvas");
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setStandardSize(TextField input) {
        final int STANDARD_TEXT_FIELD_WIDTH = 150;

        input.setPrefWidth(STANDARD_TEXT_FIELD_WIDTH);
        input.setMaxWidth(STANDARD_TEXT_FIELD_WIDTH);
    }
}
