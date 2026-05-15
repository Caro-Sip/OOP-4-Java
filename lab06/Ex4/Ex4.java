package Ex4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex4{
    public static void main(String[] args){
        JFrame frame = new JFrame("Quadratic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Find roots of quadratic equation");
        titleLabel.setBounds(20,20,200,10);
        frame.add(titleLabel);

        JLabel aLabel = new JLabel("a=");
        aLabel.setBounds(20,40,100,20);
        frame.add(aLabel);

        JTextField aField = new JTextField();
        aField.setBounds(20,70,100,20);
        frame.add(aField);

        JLabel bLabel = new JLabel("b=");
        bLabel.setBounds(20,90,100,20);
        frame.add(bLabel);

        JTextField bField = new JTextField();
        bField.setBounds(20,110,100,20);
        frame.add(bField);

        JLabel cLabel = new JLabel("c=");
        cLabel.setBounds(20,130,100,20);
        frame.add(cLabel);

        JTextField cField = new JTextField();
        cField.setBounds(20,150,100,20);
        frame.add(cField);

        JLabel solutionLabel = new JLabel("Press button to calculate");
        solutionLabel.setBounds(20,200,400,20);
        frame.add(solutionLabel);

        JButton button = new JButton("Calcualte");
        button.addActionListener(e -> {
            try {
                int a = Integer.valueOf(aField.getText());
                int b = Integer.valueOf(bField.getText());
                int c = Integer.valueOf(cField.getText());

                double[] solutions = new QuadraticEquation().solveQuadratic(a, b, c);

                if (solutions == null) {
                    solutionLabel.setText("Result: No real roots");
                } else if (solutions.length == 1) {
                    solutionLabel.setText(String.format("Result: x = %.2f", solutions[0]));
                } else {
                    solutionLabel.setText(String.format("Result: x1 = %.2f, x2 = %.2f", solutions[0], solutions[1]));
                }
            } catch (NumberFormatException ex) {
                solutionLabel.setText("Result: Invalid input");
            }
        });
        button.setBounds(20,180,100, 20);
        frame.add(button);

        frame.setLayout(null);
        frame.setSize(300,500);
        frame.setVisible(true);
    }
}