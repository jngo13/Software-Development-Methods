import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class GUILLOfFortune extends JFrame {
    JLabel instructions;
    JButton submit;
    JTextArea enterArea;

    JLabel livesRemaining;
    JLabel lettersEntered;
    JLabel wordOutput;

    // IMPORTANT
    boolean[] lettersCorrect = { false, false, false, false, false };
    int lives;
    String password;
    ArrayList<String> letters;
    // ENDS HERE

    public static void main(String[] args) {
        new GUILLOfFortune();
    }

    public GUILLOfFortune() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        this.setSize(width, height);

        // IMPORTANT
        password = "print";
        lives = 5;
        letters = new ArrayList<String>();
        // ENDS HERE

        instructions = new JLabel("<html>Enter a letter to see if it's in the word!</html>");
        submit = new JButton("ENTER");
        enterArea = new JTextArea();
        livesRemaining = new JLabel("Lives: " + lives);
        lettersEntered = new JLabel("<html>Letters Entered: " + letters + "</html>");
        wordOutput = new JLabel("_ _ _ _ _");
        wordOutput.setFont(new Font("Times", Font.BOLD, 20));

        instructions.setSize(23 * width / 60, height / 6);
        submit.setSize(width / 3, 50);
        enterArea.setSize(width / 3, 50);
        livesRemaining.setSize(width / 4, height / 12);
        lettersEntered.setSize(width / 3, height / 3);
        wordOutput.setSize(width / 2, height / 6);

        instructions.setLocation(width / 15, 1);
        submit.setLocation(width / 2, height / 2);
        enterArea.setLocation(width / 6, height / 2);
        livesRemaining.setLocation(11 * width / 15, 1);
        lettersEntered.setLocation(17 * width / 30, height / 20);
        wordOutput.setLocation(width / 3, height / 3);

        submit.addActionListener(new passwordButtonListener());

        this.add(instructions);
        this.add(submit);
        this.add(enterArea);
        this.add(livesRemaining);
        this.add(lettersEntered);
        this.add(wordOutput);

        this.add(new JLabel());
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    private class passwordButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // Turns entered string into the first letter
            String s = enterArea.getText();
            char c = s.charAt(0);
            s = Character.toString(c);
            enterArea.setText("");

            if (!letters.contains(s)) {
                letters.add(s);
                lettersEntered.setText("<html>Letters Entered: " + letters + "</html>");
            } else {
                instructions.setText("<html>Letter " + s + " already entered. Try again.<html>");
            }

            if (password.contains(s)) {
                int correctGuesses = 0;
                lettersCorrect[password.indexOf(s)] = true;
                String output = "";

                for (int i = 0; i < lettersCorrect.length; i++) {
                    if (lettersCorrect[i] == false) {
                        output += "_ ";
                    }
                    if (lettersCorrect[i] == true) {
                        output += (password.charAt(i) + " ");
                    }

                    wordOutput.setText(output);
                }
                if (correctGuesses == password.length()) {
                    enterArea.setVisible(false);
                    submit.setVisible(false);
                }
            } else {
                lives--;
                livesRemaining.setText("Lives: " + lives);

                if (lives <= 0) {
                    enterArea.setVisible(false);
                    submit.setVisible(false);
                }
            }

        }
    }
}
