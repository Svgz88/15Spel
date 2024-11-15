package Server;

import javax.swing.*;
import java.awt.*;

public class OurServer extends JFrame{
    JPanel mainPanel = new JPanel();
    JPanel panel1 = new JPanel();
    JLabel mainLabel = new JLabel("Enter Player Name");
    JButton mainButton = new JButton("Start");
    JTextField mainTextField = new JTextField(10);

    public OurServer(){
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(mainLabel);

        panel1.add(Box.createVerticalStrut(20));

        mainTextField.setMaximumSize(new Dimension(200,30));
        mainTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(mainTextField);

        panel1.add(Box.createVerticalStrut(20));

        mainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.add(mainButton);

        mainPanel.add(panel1, BorderLayout.CENTER);

        this.setTitle("QuizDuel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new OurServer();
    }
}
