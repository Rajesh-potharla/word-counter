
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Wordcounter extends JFrame {
    private JTextArea textArea;
    private JLabel resultLabel;
    private JButton countButton;
    
    public Wordcounter() {
        // Set up the frame
        setTitle("Word Counter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        countButton = new JButton("Count Words");
        countButton.setFont(new Font("Arial", Font.BOLD, 14));
        
        resultLabel = new JLabel("Word count: 0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        
        // Set up layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        mainPanel.add(new JLabel("Enter your text:"), BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(countButton, BorderLayout.NORTH);
        bottomPanel.add(resultLabel, BorderLayout.SOUTH);
        
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        // Add action listener to the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
        
        // Add the main panel to the frame
        add(mainPanel);
        
        // Display the frame
        setVisible(true);
    }
    
    private void countWords() {
        String text = textArea.getText().trim();
        
        if (text.isEmpty()) {
            resultLabel.setText("Word count: 0");
            return;
        }
        
        // Split the text by whitespace and count the words
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        
        resultLabel.setText("Word count: " + wordCount);
    }
    
    public static void main(String[] args) {
        // Create the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Wordcounter();
            }
        });
    }
}

