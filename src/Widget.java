import javax.swing.*;
import java.awt.*;

public class Widget
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Widget");

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBackground(new Color(23, 99, 4));

        JButton enter = new JButton("Enter");
        JTextField textedit = new JTextField(30);

        panel.add(textedit);
        panel.add(enter);

        String[] items = new String[10];

        JComboBox combobox = new JComboBox(items);
        combobox.setEditable(true);

        frame.add(panel, BorderLayout.SOUTH);
        frame.add(combobox, BorderLayout.NORTH);

        frame.setVisible(true);
    }


}
