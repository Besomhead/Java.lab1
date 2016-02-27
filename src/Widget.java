import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Widget
{
    static JFrame frame = new JFrame("Widget");
    static JTabbedPane tabs = new JTabbedPane();
    static JTextField textedit = new JTextField(30);
    static JTextField textpanel = new JTextField(30);
    static JButton swap1 = new JButton("Enter");
    static JButton swap2 = new JButton("Enter button name");
    static JComboBox combobox = new JComboBox();
<<<<<<< HEAD
=======
    static JTextField textField = new JTextField(30);
    static JRadioButton radioOption1 = new JRadioButton("15-18");
    static JRadioButton radioOption2 = new JRadioButton("19-22");
    static JRadioButton radioOption3 = new JRadioButton("23-26");
    static JTextField textLine = new JTextField(30);
    static JCheckBox checkOption1 = new JCheckBox("Banana");
    static JCheckBox checkOption2 = new JCheckBox("Orange");
    static JCheckBox checkOption3 = new JCheckBox("Apple");
>>>>>>> extra

    public static void main(String[] args)
    {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        FirstTabCreating();
        SecondTabCreating();
<<<<<<< HEAD

=======
        ThirdTabCreating();
        FourthTabCreating();
>>>>>>> extra

        frame.add(tabs);

        frame.setVisible(true);
    }

    public static void FirstTabCreating()
    {
        JPanel tab1 = new JPanel(new BorderLayout());
        JPanel downpanel = new JPanel(new FlowLayout());
        downpanel.setBackground(new Color(9, 55, 9));
        JButton enter = new JButton("Enter");

        downpanel.add(textedit);
        downpanel.add(enter);

        enter.addActionListener(new EnterActionListener());

        tab1.add(downpanel, BorderLayout.SOUTH);

        tab1.add(combobox, BorderLayout.NORTH);

        tabs.add(tab1, "Group1");
    }

    public static class EnterActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String temp = textedit.getText();
            int i = 0;
            boolean fl = false;
            while ((!fl) && (i < combobox.getModel().getSize()))
            {
                Object currentItem = combobox.getItemAt(i);
                if (temp.equals(currentItem.toString())) fl = true;
                i++;
            }

            if (!fl) combobox.addItem(temp);
            else
            {
                JOptionPane exist = new JOptionPane();
                exist.showMessageDialog(frame, "Sorry, this item is already exist. Please try again.");
            }
        }
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
<<<<<<< HEAD
=======

    public static void ThirdTabCreating()
    {
        JPanel tab3 = new JPanel(new BorderLayout());
        JPanel linePanel = new JPanel(new FlowLayout());
        linePanel.setBackground(new Color(9, 55, 9));
        JPanel buttonBox = new JPanel(new GridLayout(3, 1));
        JLabel question = new JLabel("How old are you?");
        JButton select = new JButton("Select");

        linePanel.add(textField);
        linePanel.add(select);

        select.addActionListener(new SelectActionListener());

        buttonBox.add(radioOption1);
        buttonBox.add(radioOption2);
        buttonBox.add(radioOption3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioOption1);
        buttonGroup.add(radioOption2);
        buttonGroup.add(radioOption3);

        tab3.add(question, BorderLayout.NORTH);
        tab3.add(buttonBox, BorderLayout.CENTER);
        tab3.add(linePanel, BorderLayout.SOUTH);

        tabs.add(tab3, "Group3");
    }

    static String currentOption = "";

    public static class SelectActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (!currentOption.equals(textField.getText()))
            {
                currentOption = textField.getText();
                if (currentOption.equals(radioOption1.getText())) radioOption1.setSelected(true);
                else
                    if (currentOption.equals(radioOption2.getText())) radioOption2.setSelected(true);
                    else
                        if(currentOption.equals(radioOption3.getText())) radioOption3.setSelected(true);
                        else
                        {
                            JOptionPane wrongOption = new JOptionPane();
                            wrongOption.showMessageDialog(frame, "Sorry, this option does not exist. Please try again.");
                        }
            }
        }
    }

    public static void FourthTabCreating()
    {
        JPanel tab4 = new JPanel(new BorderLayout());
        JPanel greenPanel = new JPanel(new FlowLayout());
        greenPanel.setBackground(new Color(9, 55, 9));
        JPanel checkBoxPanel = new JPanel(new GridLayout(3, 1));
        JLabel title = new JLabel("Choose your favourite fruit:");
        JButton choose = new JButton("Choose");
        choose.addActionListener(new ChooseActionListener());

        greenPanel.add(textLine);
        greenPanel.add(choose);

        checkBoxPanel.add(checkOption1);
        checkBoxPanel.add(checkOption2);
        checkBoxPanel.add(checkOption3);

        tab4.add(title, BorderLayout.NORTH);
        tab4.add(checkBoxPanel, BorderLayout.CENTER);
        tab4.add(greenPanel, BorderLayout.SOUTH);

        tabs.add(tab4, "Group4");
    }

    public static class ChooseActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (textLine.getText().equals(checkOption1.getText())) checkOption1.setSelected(true);
            else
                if (textLine.getText().equals(checkOption2.getText())) checkOption2.setSelected(true);
                else
                    if (textLine.getText().equals(checkOption3.getText())) checkOption3.setSelected(true);
                    else
                    {
                        JOptionPane notExist = new JOptionPane();
                        notExist.showMessageDialog(frame, "Sorry, this option does not exist. Please try again.");
                    }
        }
    }
>>>>>>> extra
}
