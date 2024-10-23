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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TaskDetailsScreen extends JFrame {
    private ArrayList<Task> taskList; // Store the current list of tasks
    private JTextArea taskTextArea;
    private JLabel imageLabel;
    private Task currentTask; // Keep track of the currently selected task

    public TaskDetailsScreen(ArrayList<Task> taskList) {
        this.taskList = taskList;
        setTitle("Task Details");
        setSize(1400, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Create a panel to hold the image and text components
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Image label on the left
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(500, 500));
        JPanel imagePanel = new JPanel();
        imagePanel.add(imageLabel);

        // Text area on the right
        taskTextArea = new JTextArea(10, 20);
        JScrollPane textScrollPane = new JScrollPane(taskTextArea);
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.add(textScrollPane, BorderLayout.CENTER);

        // Add the image panel to the left and text panel to the right
        mainPanel.add(imagePanel, BorderLayout.WEST);
        mainPanel.add(textPanel, BorderLayout.CENTER);

        // Save Task and Upload Image buttons at the bottom
        JButton saveTaskButton = new JButton("Save Task");
        saveTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTask();
            }
        });

        JButton uploadImageButton = new JButton("Upload Image");
        uploadImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadImage();
            }
        });

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveTaskButton);
        buttonPanel.add(uploadImageButton);

        // Add components to the frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Load the first task if any exists
        if (!taskList.isEmpty()) {
            loadTask(0); // Load the first task (for example)
        }

        setVisible(true);
    }

    private void loadTask(int taskIndex) {
        currentTask = taskList.get(taskIndex); // Load the task at the specified index
        taskTextArea.setText(currentTask.getText());
        if (currentTask.getImage() != null) {
            imageLabel.setIcon(new ImageIcon(currentTask.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        }
    }

    private void saveTask() {
        String taskText = taskTextArea.getText();
        if (currentTask == null) {
            currentTask = new Task(taskText, null, null); // Create a new task
            taskList.add(currentTask); // Add the new task to the list
        } else {
            currentTask.setText(taskText); // Update the existing task
        }
        JOptionPane.showMessageDialog(this, "Task saved!");
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage img = javax.imageio.ImageIO.read(fileChooser.getSelectedFile());
                imageLabel.setIcon(new ImageIcon(img.getScaledInstance(500, 500, Image.SCALE_SMOOTH)));

                // Update the current task's image
                if (currentTask != null) {
                    currentTask.setImage(img);
                }

                JOptionPane.showMessageDialog(this, "Image uploaded!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error uploading image.");
            }
        }
    }
}
