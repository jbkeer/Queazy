package com.quiz.quizapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class CategoriesController {

    @FXML
    private Button mathBtn;

    @FXML
    private Button sciBtn;

    @FXML
    private Button geoBtn;

    private Clip currentClip;

    @FXML
    private void initialize() {

        mathBtn.setOnAction(event -> loadQuiz(event, "math")) ;
        sciBtn.setOnAction(event -> loadQuiz(event, "science"));
        geoBtn.setOnAction(event -> loadQuiz(event, "geography"));
    }

    private void loadQuiz(ActionEvent event, String category) {
        MusicController.playClickSound(); // Play click sound

        try {
            Stage thisStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/quiz/quizapp/quiz.fxml"));
            Scene scene = new Scene(loader.load());

            QuizController controller = loader.getController();
            controller.setCategory(category);

            // Play the corresponding music
            playMusicForCategory(category);

            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playMusicForCategory(String category) {
        String musicPath = null;

        switch (category) {
            case "math":
                musicPath = "src/main/resources/music/math_music.wav";
                break;
            case "science":
                musicPath = "src/main/resources/music/science_music.wav";
                break;
            case "geography":
                musicPath = "src/main/resources/music/geography_music.wav";
                break;
            default:
                System.out.println("No music for this category");
                return;
        }

        MusicController.playMusic(musicPath, -15.0f, true); // Adjust volume as needed
    }

}
