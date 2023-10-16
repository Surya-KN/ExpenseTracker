package org.SuryaKN;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class NewExpense {
    public NewExpense() {

        JFrame frame = new JFrame("Input Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 2));
        frame.setLocationRelativeTo(null);

        frame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        frame.add(nameField);

        frame.add(new JLabel("Description:"));
        JTextField descriptionField = new JTextField();
        frame.add(descriptionField);

        frame.add(new JLabel("Amount:"));
        JTextField amountField = new JTextField();
        frame.add(amountField);

        frame.add(new JLabel("Date(YYYY-MM-DD):"));
        JTextField dateField = new JTextField();
        frame.add(dateField);

        frame.add(new JLabel("Category:"));
        String[] categoryList = ExpenseDB.getCategories();
        JComboBox<String> categoryField = new JComboBox<>(categoryList);
        frame.add(categoryField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e1 -> {
            String name = nameField.getText();
            String description = descriptionField.getText();
            int amount = Integer.parseInt(amountField.getText());
            String date = dateField.getText();
            String category = (String) categoryField.getSelectedItem();
            frame.dispose();
            ExpenseDB.insertExpenses(name, description, amount, category, date);
            try {
                HomeWindow.updateTable();
                HomeWindow.updateTotal();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        frame.add(submitButton);

        frame.pack();
        frame.setVisible(true);
    }
}
