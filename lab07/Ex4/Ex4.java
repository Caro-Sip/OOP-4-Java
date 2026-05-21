package Ex4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ex4 {
    public static void main(String[] args){
        JFrame frame = new JFrame("Phone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Setting");
        title.setFont(new Font("SansSerif", Font.BOLD, 15));
        title.setBounds(20,20,200,50);
        frame.add(title);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setBounds(50,50,300,550);
        settingsPanel.setLayout(new BoxLayout(settingsPanel, BoxLayout.Y_AXIS));
        settingsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(settingsPanel);

        JPanel generalPanel = new JPanel();
        generalPanel.setBounds(50,50,300,550);
        generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));
        generalPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        generalPanel.setVisible(false);
        frame.add(generalPanel);

        JPanel aboutPanel = new JPanel();
        aboutPanel.setBounds(50,50,300,550);
        aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
        aboutPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        aboutPanel.setVisible(false);
        frame.add(aboutPanel);

        JButton aboutButton = new JButton("1. About");
        aboutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        aboutButton.setBackground(Color.WHITE);
        aboutButton.setOpaque(true);
        aboutButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        aboutButton.setMaximumSize(new Dimension(200, 40));
        generalPanel.add(aboutButton);
        generalPanel.add(Box.createVerticalStrut(10));

        JButton softwareUpdateButton = new JButton("2. Software Update");
        softwareUpdateButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        softwareUpdateButton.setBackground(Color.WHITE);
        softwareUpdateButton.setOpaque(true);
        softwareUpdateButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        softwareUpdateButton.setMaximumSize(new Dimension(200, 40));
        generalPanel.add(softwareUpdateButton);
        generalPanel.add(Box.createVerticalStrut(10));

        JButton storageButton = new JButton("3. Storage");
        storageButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        storageButton.setBackground(Color.WHITE);
        storageButton.setOpaque(true);
        storageButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        storageButton.setMaximumSize(new Dimension(200, 40));
        generalPanel.add(storageButton);
        generalPanel.add(Box.createVerticalStrut(10));

        JButton backButton = new JButton("Back");
        backButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        backButton.setBackground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        backButton.setMaximumSize(new Dimension(200, 40));
        generalPanel.add(backButton);

        JLabel nameLabel = new JLabel("Name iPhone");
        nameLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        aboutPanel.add(nameLabel);
        aboutPanel.add(Box.createVerticalStrut(10));

        JLabel modelLabel = new JLabel("Model IXs");
        modelLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        aboutPanel.add(modelLabel);
        aboutPanel.add(Box.createVerticalStrut(10));

        JLabel versionLabel = new JLabel("Version 18.5");
        versionLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        aboutPanel.add(versionLabel);
        aboutPanel.add(Box.createVerticalStrut(20));

        JButton aboutBackButton = new JButton("Back");
        aboutBackButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        aboutBackButton.setBackground(Color.WHITE);
        aboutBackButton.setOpaque(true);
        aboutBackButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        aboutBackButton.setMaximumSize(new Dimension(200, 40));
        aboutPanel.add(aboutBackButton);

        JButton generalButton = new JButton("1. General");
        generalButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        generalButton.setBackground(Color.WHITE);
        generalButton.setOpaque(true);
        generalButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        generalButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(generalButton);
        settingsPanel.add(Box.createVerticalStrut(10));

        JButton wifiButton = new JButton("2. Wi-Fi");
        wifiButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        wifiButton.setBackground(Color.WHITE);
        wifiButton.setOpaque(true);
        wifiButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        wifiButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(wifiButton);
        settingsPanel.add(Box.createVerticalStrut(10));

        JButton bluetoothButton = new JButton("3. Bluetooth");
        bluetoothButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bluetoothButton.setBackground(Color.WHITE);
        bluetoothButton.setOpaque(true);
        bluetoothButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        bluetoothButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(bluetoothButton);
        settingsPanel.add(Box.createVerticalStrut(10));

        JButton mobileDataButton = new JButton("4. Mobile Data");
        mobileDataButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mobileDataButton.setBackground(Color.WHITE);
        mobileDataButton.setOpaque(true);
        mobileDataButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        mobileDataButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(mobileDataButton);
        settingsPanel.add(Box.createVerticalStrut(10));

        JButton hotspotButton = new JButton("5. Hotspot");
        hotspotButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        hotspotButton.setBackground(Color.WHITE);
        hotspotButton.setOpaque(true);
        hotspotButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        hotspotButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(hotspotButton);
        settingsPanel.add(Box.createVerticalStrut(10));

        JButton notificationButton = new JButton("6. Notification");
        notificationButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        notificationButton.setBackground(Color.WHITE);
        notificationButton.setOpaque(true);
        notificationButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        notificationButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(notificationButton);
        settingsPanel.add(Box.createVerticalStrut(10));

        JButton quitButton = new JButton("Quit");
        quitButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        quitButton.setBackground(Color.WHITE);
        quitButton.setOpaque(true);
        quitButton.setAlignmentX(JButton.LEFT_ALIGNMENT);
        quitButton.setMaximumSize(new Dimension(200, 40));
        settingsPanel.add(quitButton);

        generalButton.addActionListener(event -> {
            settingsPanel.setVisible(false);
            generalPanel.setVisible(true);
            title.setText("Setting > General");
        });

        aboutButton.addActionListener(event -> {
            generalPanel.setVisible(false);
            aboutPanel.setVisible(true);
            title.setText("Setting > General > About");
        });

        softwareUpdateButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        storageButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        backButton.addActionListener(event -> {
            generalPanel.setVisible(false);
            settingsPanel.setVisible(true);
            title.setText("Setting");
        });

        aboutBackButton.addActionListener(event -> {
            aboutPanel.setVisible(false);
            generalPanel.setVisible(true);
            title.setText("Setting > General");
        });

        wifiButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        bluetoothButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        mobileDataButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        hotspotButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        notificationButton.addActionListener(event ->
            JOptionPane.showMessageDialog(frame, "unimplmented feature")
        );

        quitButton.addActionListener(event -> System.exit(0));

        frame.setLayout(null);
        frame.setSize(400,700);
        frame.setVisible(true);
    }
}
