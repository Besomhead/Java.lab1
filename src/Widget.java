import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Widget
{
    public void Manage()
    {
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        FirstTabCreating();
        SecondTabCreating();
        ThirdTabCreating();
        FourthTabCreating();
        FifthTabCreating();

        frame.add(tabs);

        frame.setVisible(true);
        frame.pack();

        autoScroll();
    }

    private void FirstTabCreating()
    {
        JPanel tab1 = new JPanel(new BorderLayout());
        downPanel.setBackground(new Color(9, 55, 9));
        JButton enter = new JButton("Enter");

        downPanel.add(textEdit);
        downPanel.add(enter);

        enter.addActionListener(new EnterActionListener());

        tab1.add(downPanel, BorderLayout.SOUTH);

        tab1.add(comboBox, BorderLayout.NORTH);

        tabs.add(tab1, "Group1");
    }

    private class EnterActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String temp = textEdit.getText();
            int i = 0;
            boolean fl = false;
            while ((!fl) && (i < comboBox.getModel().getSize()))
            {
                Object currentItem = comboBox.getItemAt(i);
                if (temp.equals(currentItem.toString())) fl = true;
                i++;
            }

            if (!fl) comboBox.addItem(temp);
            else
            {
                JOptionPane exist = new JOptionPane();
                exist.showMessageDialog(frame, "Sorry, this item is already exist. Please try again.");
            }

            textEdit.setText("");
        }
    }

    private void SecondTabCreating()
    {
        JPanel tab2 = new JPanel(new BorderLayout());

        swap1.addActionListener(new Swap1ActionListener());
        swap2.addActionListener(new Swap2ActionListener());

        extraPanel.setBackground(new Color(9, 55, 9));

        extraPanel.add(textPanel);
        extraPanel.add(swap1);

        tab2.add(extraPanel, BorderLayout.SOUTH);
        tab2.add(swap2, BorderLayout.NORTH);

        tabs.add(tab2, "Group2");
    }

    private class Swap1ActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            swap2.setText(textPanel.getText());
            textPanel.setText("");
        }
    }

    private class Swap2ActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String temp = swap2.getText();
            swap2.setText(swap1.getText());
            swap1.setText(temp);
        }
    }

    private void ThirdTabCreating()
    {
        JPanel tab3 = new JPanel(new BorderLayout());
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

    private class SelectActionListener implements ActionListener
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

            textField.setText("");
        }
    }

    private void FourthTabCreating()
    {
        JPanel tab4 = new JPanel(new BorderLayout());
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

    private class ChooseActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if (textLine.getText().equals(checkOption1.getText()))
                if (checkOption1.isSelected()) checkOption1.setSelected(false);
                else checkOption1.setSelected(true);
            else
                if (textLine.getText().equals(checkOption2.getText()))
                    if(checkOption2.isSelected()) checkOption2.setSelected(false);
                    else checkOption2.setSelected(true);
                else
                    if (textLine.getText().equals(checkOption3.getText()))
                        if (checkOption3.isSelected()) checkOption3.setSelected(false);
                        else checkOption3.setSelected(true);
                    else
                    {
                        JOptionPane notExist = new JOptionPane();
                        notExist.showMessageDialog(frame, "Sorry, this option does not exist. Please try again.");
                    }

            textLine.setText("");
        }
    }

    private void FifthTabCreating()
    {
        JPanel tab5 = new JPanel(new BorderLayout());
        addGroup.setBackground(new Color(9, 55, 9));
        JButton add = new JButton("Add");
        JPanel tableGroup = new JPanel(new GridBagLayout());
        JButton toRight = new JButton("To Right");
        JButton toLeft = new JButton("To Left");
        JScrollPane scroller = new JScrollPane(table);

        add.addActionListener(new AddActionListener());
        toRight.addActionListener(new ToRightActionListener());
        toLeft.addActionListener(new ToLeftActionListener());

        addGroup.add(addLine);
        addGroup.add(add);

        tab5.add(addGroup, BorderLayout.SOUTH);

        tableGroup.add(scroller,
                new GridBagConstraints(10, 2, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(2, 2, 2, 2), 0, 0));

        tableGroup.add(toRight,
                new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        tableGroup.add(toLeft,
                new GridBagConstraints(25, 0, 1, 1, 1, 1,
                        GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));

        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(true);

        tab5.add(tableGroup, BorderLayout.NORTH);

        tabs.add(tab5, "Group5");
    }

    private class AddActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String []newLine = new String[model.getColumnCount()];
            newLine[0] = addLine.getText();

            model.addData(newLine);
            addLine.setText("");
            model.fireTableDataChanged();
        }
    }

    private class ToRightActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            model.toRight(table.getSelectedRow());
            model.fireTableDataChanged();
        }
    }

    private class ToLeftActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            model.toLeft(table.getSelectedRow());
            model.fireTableDataChanged();
        }
    }

    private void autoScroll()
    {
        Random randomColor = new Random();

        Timer scrollTimer = new Timer();
        scrollTimer.schedule(new TimerTask()
        {
            public void run()
            {
                tabs.setSelectedIndex(0);
                int r = randomColor.nextInt(255);
                int g = randomColor.nextInt(255);
                int b = randomColor.nextInt(255);
                downPanel.setBackground(new Color(r, g, b));
            }
        }, 0, 75000);

        scrollTimer.schedule(new TimerTask()
        {
            public void run()
            {
                tabs.setSelectedIndex(1);
                int r = randomColor.nextInt(255);
                int g = randomColor.nextInt(255);
                int b = randomColor.nextInt(255);
                extraPanel.setBackground(new Color(r, g, b));
            }
        }, 15000, 75000);

        scrollTimer.schedule(new TimerTask()
        {
            public void run()
            {
                tabs.setSelectedIndex(2);
                int r = randomColor.nextInt(255);
                int g = randomColor.nextInt(255);
                int b = randomColor.nextInt(255);
                linePanel.setBackground(new Color(r, g, b));
            }
        }, 30000, 75000);

        scrollTimer.schedule(new TimerTask()
        {
            public void run()
            {
                tabs.setSelectedIndex(3);
                int r = randomColor.nextInt(255);
                int g = randomColor.nextInt(255);
                int b = randomColor.nextInt(255);
                greenPanel.setBackground(new Color(r, g, b));
            }
        }, 45000, 75000);

        scrollTimer.schedule(new TimerTask()
        {
            public void run()
            {
                tabs.setSelectedIndex(4);
                int r = randomColor.nextInt(255);
                int g = randomColor.nextInt(255);
                int b = randomColor.nextInt(255);
                addGroup.setBackground(new Color(r, g, b));
            }
        }, 60000, 75000);
    }

    private JFrame frame = new JFrame("Widget");
    private JTabbedPane tabs = new JTabbedPane();
    private JPanel downPanel = new JPanel(new FlowLayout());
    private JPanel extraPanel = new JPanel(new FlowLayout());
    private JPanel linePanel = new JPanel(new FlowLayout());
    private JPanel greenPanel = new JPanel(new FlowLayout());
    private JPanel addGroup = new JPanel(new FlowLayout());
    private JTextField textEdit = new JTextField(30);
    private JTextField textPanel = new JTextField(30);
    private JButton swap1 = new JButton("Enter");
    private JButton swap2 = new JButton("Enter button name");
    private JComboBox comboBox = new JComboBox();
    private JTextField textField = new JTextField(30);
    private JRadioButton radioOption1 = new JRadioButton("15-18");
    private JRadioButton radioOption2 = new JRadioButton("19-22");
    private JRadioButton radioOption3 = new JRadioButton("23-26");
    private JTextField textLine = new JTextField(30);
    private JCheckBox checkOption1 = new JCheckBox("Banana");
    private JCheckBox checkOption2 = new JCheckBox("Orange");
    private JCheckBox checkOption3 = new JCheckBox("Apple");
    private JTextField addLine = new JTextField(30);
    private TableModel model = new TableModel();
    private JTable table = new JTable(model);
    private String currentOption = "";
}
