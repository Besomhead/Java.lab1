import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Widget
{
    static JFrame frame = new JFrame("Widget");
    static JButton enter = new JButton("Enter");
    static JTabbedPane tabs = new JTabbedPane();
    static JTextField textedit = new JTextField(30);
    static JTextField textpanel = new JTextField(30);
    static JButton swap1 = new JButton("Enter");
    static JButton swap2 = new JButton("Second button");

    public static void main(String[] args)
    {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        FirstTabCreating();
        SecondTabCreating();


        frame.add(tabs);

        frame.setVisible(true);
    }

    public static void FirstTabCreating()
    {
        JPanel tab1 = new JPanel(new BorderLayout());
        JPanel downpanel = new JPanel(new FlowLayout());
        downpanel.setBackground(new Color(9, 55, 9));

        downpanel.add(textedit);
        downpanel.add(enter);

        tab1.add(downpanel, BorderLayout.SOUTH);

        String[] items = new String[10];

        JComboBox combobox = new JComboBox(items);

        tab1.add(combobox, BorderLayout.NORTH);

        tabs.add(tab1, "Group1");
    }

    public static void SecondTabCreating()
    {
        JPanel tab2 = new JPanel(new BorderLayout());

        swap1.addActionListener(new Swap1ActionListener());
        swap2.addActionListener(new Swap2ActionListener());

        JPanel extrapanel = new JPanel(new FlowLayout());
        extrapanel.setBackground(new Color(9, 55, 9));

        extrapanel.add(textpanel);
        extrapanel.add(swap1);

        tab2.add(extrapanel, BorderLayout.SOUTH);
        tab2.add(swap2, BorderLayout.NORTH);

        tabs.add(tab2, "Group2");
    }

    public static class Swap1ActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            swap2.setText(textpanel.getText());
            textpanel.setText("");
        }
    }

    public static class Swap2ActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String temp = swap2.getText();
            swap2.setText(swap1.getText());
            swap1.setText(temp);
        }
    }
}
