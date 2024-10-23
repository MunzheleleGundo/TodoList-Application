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
import java.util.ArrayList;

public class MainScreen extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> listDisplay;
    private ArrayList<ArrayList<Task>> taskLists; // Store multiple lists, each containing tasks
    private int listCount = 0;

    public MainScreen() {
        setTitle("Task Lists");
        setSize(1400, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        listModel = new DefaultListModel<>();
        listDisplay = new JList<>(listModel);
        taskLists = new ArrayList<>(); // ArrayList to store all task lists
        
        JScrollPane listScrollPane = new JScrollPane(listDisplay);

        JButton addButton = new JButton("Add New List");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewList();
            }
        });

        JButton deleteButton = new JButton("Delete List");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteList(listDisplay.getSelectedIndex());
            }
        });

        JButton viewButton = new JButton("View Details");
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDetails(listDisplay.getSelectedIndex());
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addNewList() {
        if (listCount < 30) {
            String newListName = JOptionPane.showInputDialog(null,"Enter The tittle of your Task ");
            listModel.addElement(newListName);
            taskLists.add(new ArrayList<>()); // Add a new empty list of tasks
            listCount++;
        } else {
            JOptionPane.showMessageDialog(this, "Maximum limit of lists (30) reached.");
        }
    }

    private void deleteList(int index) {
        if (index >= 0) {
            int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this list?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                listModel.remove(index);
                taskLists.remove(index); // Remove the task list as well
                listCount--;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a list to delete.");
        }
    }

    private void viewDetails(int index) {
        if (index >= 0) {
            // Pass the selected list of tasks to the TaskDetailsScreen
            ArrayList<Task> selectedList = taskLists.get(index);
            new TaskDetailsScreen(selectedList); // Pass the selected list
        } else {
            JOptionPane.showMessageDialog(this, "Please select a list to view.");
        }
    }

  
}
