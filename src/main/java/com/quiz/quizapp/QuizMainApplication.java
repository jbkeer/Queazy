package com.quiz.quizapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.quiz.quizapp.controller.MusicController;
import com.quiz.quizapp.model.QuizQuestion;
import javafx.application.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QuizMainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizMainApplication.class.getResource("home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.show();

        // Play the initial background music
        MusicController.playMusic("src/main/resources/music/default_music.wav", -10.0f, true); // Adjust volume and loop as needed
    }

    private List<QuizQuestion> loadQuestions() {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = getClass().getResourceAsStream("/questions.json")) {
            return mapper.readValue(is, new TypeReference<List<QuizQuestion>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
