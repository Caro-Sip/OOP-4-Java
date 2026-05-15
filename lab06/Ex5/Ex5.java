package Ex5;

import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex5{
    public static void main(String[] args){
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("wow: " + 1);
        label.setBounds(20,10,100,10);
        frame.add(label);

        frame.setLayout(null);
        frame.setSize(300,300);
        frame.setVisible(true);

        Timer timer = new Timer(1, e -> {
            int count = Integer.parseInt(label.getText().split(": ")[1]);
            if(count < 1000){
                label.setText("wow: " + (count + 1));
            }
        });
        timer.start();
    }
}