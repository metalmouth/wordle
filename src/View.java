import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    JFrame frame;
    JPanel mainPanel, panel, panelButtons, panelLables, panelRowLables;
    JLabel[][] panelRowLabelsList = new JLabel[5][5];

    JButton button_backspace, button_enter, button_clear;
    JTextField textField;

    public View() {

        frame = new JFrame("Woordle");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        panel = new JPanel(null);

        panelButtons = new JPanel(null);
        panelLables = new JPanel(new GridLayout(5, 1));
        panelRowLables = new JPanel(new GridLayout(1, 5));

        Color color1 = new Color(239, 241, 237);

        Toolkit tk1 = Toolkit.getDefaultToolkit();
        Dimension dim1 = tk1.getScreenSize();
        frame.setBounds(0, 0, 1600, 900);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(frame.getWidth()/2 - 160,20,300,40);
        textField.setBackground(Color.WHITE);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));

        button_backspace = new JButton("BackSpace");
        button_backspace.setFont(new Font("Arial", Font.PLAIN, 20));
        button_backspace.setBackground(Color.WHITE);
        button_backspace.setBounds((frame.getWidth()/2 + 300), panelButtons.getHeight() + 30, 200, 50);

        button_clear = new JButton("Clear");
        button_clear.setFont(new Font("Arial", Font.PLAIN, 20));
        button_clear.setBackground(Color.WHITE);
        button_clear.setBounds((frame.getWidth()/2 + 300), panelButtons.getHeight() + 100, 200, 50);

        button_enter = new JButton("Enter");
        button_enter.setFont(new Font("Arial", Font.PLAIN, 20));
        button_enter.setBackground(Color.WHITE);
        button_enter.setBounds(frame.getWidth()/2 - 100, panelButtons.getHeight() + 250, 200, 50);
  
        panel.setBackground(color1);
        panelButtons.setBackground(color1);
        panelLables.setBackground(color1);

    }

    public void createWindow(){

        GridBagConstraints gbc = new GridBagConstraints();


        panel.add(textField);
        panelButtons.add(button_backspace);
        panelButtons.add(button_enter);
        panelButtons.add(button_clear);


        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10,0,10,0);
        mainPanel.add(panel, gbc);

        gbc.weightx = 1;
        gbc.weighty = 0.8;
        gbc.insets = new Insets(0,500,10,500);
        gbc.gridx = 0;
        gbc.gridy = 1;

        mainPanel.add(panelLables, gbc);

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(panelButtons, gbc);


        frame.add(mainPanel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void addKeyboardButton(JButton keyButton, ActionListener listener) {
        keyButton.addActionListener(listener);
        panelButtons.add(keyButton);
    }

    public JPanel getEmptyLabelPannel() {
        return new JPanel(new GridLayout(1, 5, 50, 70));
    }
    public JLabel getEmptyLabel() {
        JLabel label = new JLabel();
        label.setText(" ");
        return label;
    }
    public void addPanel(JPanel panel, JLabel[] worldColumn, int i) {
        panelRowLabelsList[i] = worldColumn;
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelLables.add(panel);

    }

    public void setLabelPanelText(String ch, int i, int j, Color color) {
        panelRowLabelsList[i][j].setHorizontalAlignment(SwingConstants.CENTER);
        panelRowLabelsList[i][j].setFont(new Font("Arial", Font.BOLD, 15));
        panelRowLabelsList[i][j].setText(ch);
        panelRowLabelsList[i][j].setForeground(color);
    }

    public void setLabelPanelBackgroundColor(int i, int j, Color color) {
        panelRowLabelsList[i][j].setBackground(color);
    }


    public void setBackspaceButtonActionListener(ActionListener listener) {
        button_backspace.addActionListener(listener);
    }

    public void showMessageDialogWindow(String message, String title) {
        JOptionPane.showMessageDialog(null,
                message, title,
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void setClearButtonActionListener(ActionListener listener) {
        button_clear.addActionListener(listener);
    }

    public void setEnterButtonActionListener(ActionListener listener) {
        button_enter.addActionListener(listener);
    }

    public void setTextFieldText(String text) {
        textField.setText(text);
    }

    public String getTextFieldText() {
        return textField.getText();
    }

    public int getFrameWidth() {
        return frame.getWidth();
    }

    public int getKeyboardPanelHeight() {
        return panelButtons.getWidth();
    }


}
