module com.quiz.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.quiz.quizapp to javafx.fxml, com.fasterxml.jackson.databind;
    opens com.quiz.quizapp.model to com.fasterxml.jackson.databind;
    exports com.quiz.quizapp;
    exports com.quiz.quizapp.controller;
    opens com.quiz.quizapp.controller to javafx.fxml;
}