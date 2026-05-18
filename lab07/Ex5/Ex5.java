package Ex5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex5{
    public static void main(String[] args){
        JFrame frame = new JFrame("Student Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Student Management");
        titleLabel.setBounds(20,20,200,30);

        JLabel firstNameLabel = new JLabel("First name");
        JTextField firstNameField = new JTextField();
        firstNameLabel.setBounds(20,40,100,10);
        firstNameField.setBounds(20,50,200,20);
        frame.add(firstNameLabel);
        frame.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name");
        JTextField lastNameField = new JTextField();
        lastNameLabel.setBounds(220,40,100,10);
        lastNameField.setBounds(220,50,200,20);
        frame.add(lastNameLabel);
        frame.add(lastNameField);

        JLabel ageLabel = new JLabel("Age Name");
        JTextField ageField = new JTextField();
        ageLabel.setBounds(420,40,100,10);
        ageField.setBounds(420,50,200,20);
        frame.add(ageLabel);
        frame.add(ageField);

        JLabel majorLabel = new JLabel("Major Name");
        JTextField majorField = new JTextField();
        majorLabel.setBounds(620,40,100,10);
        majorField.setBounds(620,50,200,20);
        frame.add(majorLabel);
        frame.add(majorField);

        JButton addButton = new JButton("Add new");
        addButton.setBounds(820,50,200,20);
        frame.add(addButton);

        String[] columnNames = {"First Name","Last Name","Age","Major"};
        String[][] data = {
            {"Chankolboth","Rith","19","SE"},
            {"Inthera","Chiv","19","SE"},
            {"Sathya","Poch","19","SE"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setBounds(20,80,1000,200);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20,80,1000,200);
        frame.add(scrollPane);

        addButton.addActionListener(e -> {
            String firstName = firstNameField.getText().trim();
            String lastName = lastNameField.getText().trim();
            String age = ageField.getText().trim();
            String major = majorField.getText().trim();

            if (firstName.isEmpty() || lastName.isEmpty() || age.isEmpty() || major.isEmpty()) {
                return;
            }

            model.addRow(new Object[] { firstName, lastName, age, major });

            firstNameField.setText("");
            lastNameField.setText("");
            ageField.setText("");
            majorField.setText("");
        });

        frame.setLayout(null);
        frame.setSize(1040,350);
        frame.setVisible(true);
    }
}