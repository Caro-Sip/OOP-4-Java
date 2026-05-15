package Ex3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Ex3{
    public static void main(String[] args) {
        CharacterCounter  cc = new CharacterCounter();

        JFrame frame = new JFrame("CharacterCounter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jalbel1 =new JLabel("Count numbers of Vowels Consonants and Spaces");
        jalbel1.setBounds(20, 20, 200, 20);
        frame.add(jalbel1);

        JTextField textField = new JTextField("Enter a string");
        textField.setBounds(20,50,100,30);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e){
                if (textField.getText().equals("Enter a string")){
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if(textField.getText().isEmpty()){
                    textField.setText("Enter a string");
                }
            }
        });
        frame.add(textField);

        JButton button = new JButton("Find");
        button.setBounds(20,90,90,20);
        frame.add(button);

        JLabel vowelJLabel = new JLabel("Count of vowel is: 0");
        vowelJLabel.setBounds(20,120,200,10);
        frame.add(vowelJLabel);

        JLabel consonantJLabel = new JLabel("Count of consonants is: 0");
        consonantJLabel.setBounds(20,130,200,10);
        frame.add(consonantJLabel);

        JLabel spaceJLabel = new JLabel("Count of spaces is: 0");
        spaceJLabel.setBounds(20,140,200,10);
        frame.add(spaceJLabel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                int vowels = cc.countVowels(text);
                int consonant = cc.countConsonants(text);
                int spaces = cc.countSpaces(text);

                vowelJLabel.setText("Count of vowel is: " + vowels);
                consonantJLabel.setText("Count of consonants is: " + consonant);
                spaceJLabel.setText("Count of spaces is: " + spaces);
            }
        });

        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}