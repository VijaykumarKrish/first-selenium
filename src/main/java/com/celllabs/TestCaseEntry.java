package com.celllabs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestCaseEntry {

    private JTextField usernameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextArea resultTextArea;

    public TestCaseEntry() {
        JFrame frame = new JFrame("Test Case Entry");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        JPanel panel = new JPanel();
        frame.add(panel);

        usernameField = new JTextField(20);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        JButton runTestButton = new JButton("Run Test");
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);

        panel.add(new JLabel("Username: "));
        panel.add(usernameField);
        panel.add(new JLabel("Phone: "));
        panel.add(phoneField);
        panel.add(new JLabel("Email: "));
        panel.add(emailField);
        panel.add(runTestButton);
        panel.add(new JScrollPane(resultTextArea));

        runTestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                // Implement your Selenium test case execution logic here
                // ...
                String result = "Test case executed successfully.";
                // Display the result in the text area
                resultTextArea.setText(username);
//                resultTextArea.setText(phone);
//                resultTextArea.setText(email);
//                resultTextArea.setText(result);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestCaseEntry());
    }
}