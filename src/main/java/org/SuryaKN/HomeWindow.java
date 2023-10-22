package org.SuryaKN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeWindow extends JFrame {
    private static JTable expenseTable;
    private static JComboBox<String> categories;
    private static final JLabel label = new JLabel();

    public HomeWindow() throws SQLException {
        setTitle("Expense Tracker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        createView();
        updateTotal();
    }

    private void createView() throws SQLException {
        JPanel selectionPanel = createSelectionPanel();
        JScrollPane scrollPane = createExpensePanel();// this creates my table

        JPanel panel = new JPanel();
        new BoxLayout(panel, BoxLayout.Y_AXIS);
        Box[] boxes = new Box[2];

        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();
        panel.add(boxes[0]);
        panel.add(Box.createRigidArea(new Dimension(1000, 10)));
        panel.add(boxes[1]);

        boxes[0].add(selectionPanel);
        boxes[1].add(scrollPane);
        getContentPane().add(panel);
    }

    public static void updateTotal() {
        label.setText(ExpenseDB.totalExpenses());
    }

    private JPanel createSelectionPanel() {
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new BoxLayout(selectionPanel, BoxLayout.X_AXIS));

        JButton newButton = new JButton("+NEW");
        newButton.addActionListener(new MyActionListener());

        JComboBox<String> categoriesBox;
        categoriesBox = createSortPanel();

        JButton calculateButton = new JButton("Summary");
        calculateButton.addActionListener(new MyActionListener());
        JPanel totalPanel = new JPanel();
        totalPanel.add(label);

        selectionPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        selectionPanel.add(newButton);
        selectionPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        selectionPanel.add(new JLabel("Sort:"));
        selectionPanel.add(Box.createRigidArea(new Dimension(3, 0)));
        selectionPanel.add(categoriesBox);
        selectionPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        selectionPanel.add(totalPanel);
        selectionPanel.add(Box.createRigidArea(new Dimension(490, 0)));
        selectionPanel.add(calculateButton);
        selectionPanel.add(Box.createRigidArea(new Dimension(20, 0)));
        selectionPanel.setPreferredSize(new Dimension(1000, 30));
        return selectionPanel;
    }

    private JComboBox<String> createSortPanel() {
//        JPanel sortPanel = new JPane

        String[] categoryList = ExpenseDB.getCategories();

        categories = new JComboBox<>(categoryList);
        categories.addActionListener(new MyActionListener());

        categories.setPreferredSize(new Dimension(70, 20));
        return categories;
    }

    private JScrollPane createExpensePanel() throws SQLException {
        JPanel expensePanel = new JPanel();

        DefaultTableModel model = createTableModel();

        expenseTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(expenseTable);
        expenseTable.setPreferredScrollableViewportSize(new Dimension(900, 450));
        expenseTable.setFillsViewportHeight(true);
        expenseTable.setPreferredScrollableViewportSize(new Dimension(900, 450));

        expenseTable.setFillsViewportHeight(true);

        expensePanel.setBackground(Color.BLACK);
        expensePanel.setPreferredSize(new Dimension(1000, 600));
        return scrollPane;
    }

    private DefaultTableModel createTableModel() throws SQLException {
        ResultSet rs = ExpenseDB.getALL();
        String[] columns = ExpenseDB.getColumns();
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        while (rs.next()) {
            Object[] row = new Object[columns.length];
            for (int i = 0; i < columns.length; i++) {
                row[i] = rs.getString(i + 1);
            }
            model.addRow(row);
        }

        return model;
    }

    public static void updateTable() throws SQLException {
        DefaultTableModel model = (DefaultTableModel) expenseTable.getModel();
        model.setRowCount(0); // Clear the existing table

        ResultSet rs = ExpenseDB.getALL();
        String[] columns = ExpenseDB.getColumns();

        while (rs.next()) {
            Object[] row = new Object[columns.length];
            for (int i = 0; i < columns.length; i++) {
                row[i] = rs.getString(i + 1);
            }
            model.addRow(row);
        }
    }

    public static String getSort() {
        return (String) categories.getSelectedItem();
    }
}
