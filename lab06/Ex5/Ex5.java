package Ex5;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex5{
    public static void main(String[] args){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Calculator");
        titleLabel.setBounds(20,20,100,20);
        frame.add(titleLabel);

        JLabel aLabel = new JLabel("A=");
        aLabel.setBounds(20,40,100,20);
        frame.add(aLabel);

        JTextField aField = new JTextField();
        aField.setBounds(20,60,100,20);
        frame.add(aField);

        JLabel bLabel = new JLabel("B=");
        bLabel.setBounds(20,80,100,20);
        frame.add(bLabel);
        
        JTextField bField = new JTextField();
        bField.setBounds(20,100,100,20);
        frame.add(bField);

        JButton addButton = new JButton("A+B");
        addButton.setBounds(20,120,100,20);
        frame.add(addButton);

        JLabel addLabel = new JLabel("=");
        addLabel.setBounds(20,140,100,20);
        frame.add(addLabel);

        JButton minusButton = new JButton("A-B");
        minusButton.setBounds(20,160,100,20);
        frame.add(minusButton);

        JLabel minusLabel = new JLabel("=");
        minusLabel.setBounds(20,180,100,20);
        frame.add(minusLabel);

        JButton multiplyButton = new JButton("A*B");
        multiplyButton.setBounds(20,200,100,20);
        frame.add(multiplyButton);

        JLabel multiplyLabel = new JLabel("=");
        multiplyLabel.setBounds(20,220,100,20);
        frame.add(multiplyLabel);

        JButton divisionButton = new JButton("A/B");
        divisionButton.setBounds(20,240,100,20);
        frame.add(divisionButton);

        JLabel divisionLabel = new JLabel("=");
        divisionLabel.setBounds(20,260,100,20);
        frame.add(divisionLabel);

        Calculator calculator = new Calculator();

        // Action Listeneres
        addButton.addActionListener(e -> {
            try{
                double a = Double.parseDouble(aField.getText()); 
                double b = Double.parseDouble(bField.getText()); 

                addLabel.setText("= " + calculator.add(a, b));
            } catch (NumberFormatException err){
                err.printStackTrace();
            }
        });

        minusButton.addActionListener(e -> {
                try{
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());

                minusLabel.setText("= "+calculator.subtract(a, b));
            } catch (NumberFormatException err){
                err.printStackTrace();
            }
        });

        multiplyButton.addActionListener(e -> {
            try{
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());

                multiplyLabel.setText("= "+calculator.multiply(a, b));
            } catch (NumberFormatException err){
                err.printStackTrace();
            }
        });

        divisionButton.addActionListener(e -> {
            try{
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());

                divisionLabel.setText("= " + calculator.divide(a, b));
            } catch (NumberFormatException err) {
                err.printStackTrace();
            }
        });

        frame.setSize(300,400);
        frame.setLayout(null);
        frame.setVisible(true);
        return;
    }
}