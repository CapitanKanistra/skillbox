import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MainForm {
    private JPanel mainPanel;
    private JButton сollapseButton;
    private JLabel familiaText;
    private JTextArea familiaField;
    private JTextArea otchField;
    private JLabel nameText;
    private JLabel otchText;
    private JTextArea nameField;
    private JLabel text;
    private JLabel text1;
    private JLabel text2;
    private JButton clearButton;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public MainForm() {


        сollapseButton.addActionListener(ActionEvent -> {
            if (сollapseButton.getText().equals("Collapse")) {
                if (nameField.getText().isEmpty() || familiaField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Заполните имя и фамилию.");
                    text.setText("");
                    text1.setText("");
                    text2.setText("");
                } else {
                    familiaField.setVisible(false);
                    familiaText.setVisible(false);
                    nameField.setVisible(false);
                    nameText.setVisible(false);
                    otchField.setSize(100, 50);
                    otchField.setText(collapseText());
                    otchText.setText("Имя, " +
                            "Отчество, " +
                            " Фамилия");
                    сollapseButton.setText("Expand");
                    text.setText("");
                    text1.setText("");
                    text2.setText("");
                }
            } else if (сollapseButton.getText().equals("Expand")) {
                var fio = otchField.getText().split("\n");
                if (fio.length > 3) {
                    text.setText("");
                    text1.setText("");
                    text2.setText("");
                    JOptionPane.showMessageDialog(mainPanel, "Не более трёх слов (Фамилия и (или) Имя и (или) Отчество).");

                } else {
                    if (fio.length < 2) {
                        text.setText("");
                        text1.setText("");
                        text2.setText("");
                        JOptionPane.showMessageDialog(mainPanel, "Не менее двух слов (Фамилия и (или) Имя и (или) Отчество). Каждое слово с новой строки.");

                    } else {
                        int n = fio.length - 1;
                        otchField.setSize(100, -1);
                        nameField.setText(fio[0]);
                        familiaField.setText(fio[n]);
                        otchField.setText("");
                        if (fio.length == 3) {
                            otchField.setText(fio[1]);
                        }
                        nameField.setVisible(true);
                        nameText.setVisible(true);
                        familiaField.setVisible(true);
                        familiaText.setVisible(true);
                        otchText.setText("Отчество");
                        familiaText.setText("Фамилия");
                        nameText.setText("Имя");
                        сollapseButton.setText("Collapse");
                    }
                }
            }

        });

    }


    private String collapseText() {
        return nameField.getText() + "\n" + otchField.getText() + "\n" + familiaField.getText();
    }
}
