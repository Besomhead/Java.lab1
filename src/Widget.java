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

        JTabbedPane tabs = new JTabbedPane();

        JPanel tab1 = new JPanel(new BorderLayout());
        JPanel downpanel = new JPanel(new FlowLayout());
        downpanel.setBackground(new Color(9, 55, 9));

        JButton enter = new JButton("Enter");
        JTextField textedit = new JTextField(30);

        downpanel.add(textedit);
        downpanel.add(enter);

        tab1.add(downpanel, BorderLayout.SOUTH);

        String[] items = new String[10];

        JComboBox combobox = new JComboBox(items);

        tab1.add(combobox, BorderLayout.NORTH);

        tabs.add(tab1, "Group1");

        JPanel tab2 = new JPanel(new BorderLayout());

        JTextField textpanel = new JTextField(30);

        JButton swap1 = new JButton("Enter");
        JButton swap2 = new JButton("Second button");

        JPanel extrapanel = new JPanel(new FlowLayout());
        extrapanel.setBackground(new Color(9, 55, 9));

        extrapanel.add(textpanel);
        extrapanel.add(swap1);

        tab2.add(extrapanel, BorderLayout.SOUTH);
        tab2.add(swap2, BorderLayout.NORTH);

        tabs.add(tab2, "Group2");

        frame.add(tabs);

        frame.setVisible(true);
    }


}
