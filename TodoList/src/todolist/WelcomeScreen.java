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

public class WelcomeScreen extends JFrame {
    public WelcomeScreen() {
        setTitle("ToDo List");
        setSize(1400, 680);
         setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("WELCOME", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 80));
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JButton getStartedButton = new JButton("GET STARTED");
        getStartedButton.setFont(new Font("Arial", Font.PLAIN, 20));
        getStartedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainScreen();
                dispose(); // Close the welcome screen
            }
        });
        panel.add(getStartedButton, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }
}
