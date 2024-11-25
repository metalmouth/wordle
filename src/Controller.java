import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class Controller {
    private Model model;
    private View view;

    char[] word;
    int count = 0;

    public Controller(Model model, View view) {

        this.model = model;
        this.view = view;
        this.view.setBackspaceButtonActionListener(new BackspaceButtonListener());
        this.view.setEnterButtonActionListener(new EnterButtonListener());
        this.view.setClearButtonActionListener(new ClearButtonListener());

        boolean printWordToConsole = true;

        String row1 = "qwertyuiop", row2 = "asdfghjkl", row3 = "zxcvbnm";
        String[] rows = { row1, row2, row3};
        final int BUTTON_HEIGHT = 50;
        final int BUTTON_WIDTH = 50;
        ArrayList<String> lines = model.handleLines();
        this.word = getRandomWord(lines).toUpperCase().toCharArray();

        if (printWordToConsole) {
            for (char c : word) {
                System.out.println(c);
            }
        }


        int rowC = 0;
        for (String row : rows) {
            int buttonC = 0;
            char[] keys = row.toCharArray();
            int rl = row.length();
            for (char key : keys) {
                String ch = Character.toString(key).toUpperCase();
                JButton button = new JButton(ch);
                button.setBounds( ((view.getFrameWidth() / 2 - 5 * (BUTTON_WIDTH + 5)) +
                                rl * Math.abs(rl - 10) * 3 + buttonC),
                        view.getKeyboardPanelHeight() + rows.length * 10 + rowC, BUTTON_WIDTH, BUTTON_HEIGHT);
                button.setBackground(new Color(252, 211, 144));
                button.setFont(new Font("Arial", Font.PLAIN, 15));
                button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
                view.addKeyboardButton(button, new KeyboardButtonListener(ch));
                buttonC += BUTTON_WIDTH + 5;
            }
            rowC += BUTTON_HEIGHT + 20;
        }

        for (int i = 0; i < 5; i++) {
            JLabel[] worldColumns = new JLabel[5];
            JPanel panel = view.getEmptyLabelPannel();
            for (int j = 0; j < 5; j++) {
                worldColumns[j] = view.getEmptyLabel();
                worldColumns[j].setOpaque(true);
                worldColumns[j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(worldColumns[j]);
            }
            view.addPanel(panel, worldColumns, i);
        }
    }



    class BackspaceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String text = view.getTextFieldText();
            if (!text.isEmpty()) {
                view.setTextFieldText(text.substring(0, text.length() - 1));
            }
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setTextFieldText("");
        }
    }

    class EnterButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            boolean win = true;

            char[] input = view.getTextFieldText().toCharArray();


            if (input.length == 5) {
                for (int k = 0; k < 5; k++) {
                    String ch = Character.toString(input[k]).toUpperCase();

                    view.setLabelPanelText(ch, count, k, Color.BLACK);
                    if (input[k] == word[k]) {
                        view.setLabelPanelBackgroundColor(count, k, new Color(75, 190, 100));
                    }
                    else if ((Arrays.toString(word).indexOf(input[k]) != -1)) {
                        view.setLabelPanelBackgroundColor(count, k, new Color(237, 119, 29));
                        win = false;
                    }
                    else {
                        view.setLabelPanelBackgroundColor(count, k, new Color(118, 123, 145));
                        win = false;
                    }
                }

                if (win) {
                    view.showMessageDialogWindow("Congradulations. The word was: " + new String(word), "You win!");
                    System.exit(0);

                }
                count++;
                view.setTextFieldText("");
                if (count > 4) {
                    view.showMessageDialogWindow("Too many attempts. Try again! The word was: "
                                    + new String(word), "Try again!");
                    System.exit(0);}

            }

        }
    }

    class KeyboardButtonListener implements ActionListener {
        private final String keyText;

        public KeyboardButtonListener(String text) {
            keyText = text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getTextFieldText();
            if (currentText.length() < 5) {
                view.setTextFieldText(currentText + keyText);
            }
        }
    }


    public void openWindow(){
        view.createWindow();
    }

    public String getRandomWord(ArrayList<String> lines) {
        int index = (int)(Math.random() * lines.size());
        return lines.get(index);
    }


}