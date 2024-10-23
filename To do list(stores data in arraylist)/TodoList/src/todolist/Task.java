/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolist;

/**
 *
 * @author munzh
 */
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Task {
    private String text;
    private BufferedImage image;
    private String audioFilePath;

    public Task(String text, BufferedImage image, String audioFilePath) {
        this.text = text;
        this.image = image;
        this.audioFilePath = audioFilePath;
    }

    // Getter and Setter methods for Task fields
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getAudioFilePath() {
        return audioFilePath;
    }

    public void setAudioFilePath(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }
}

