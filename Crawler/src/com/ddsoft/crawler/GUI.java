package com.ddsoft.crawler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private JLabel label = new JLabel("Log:");
    public static JTextArea area = new JTextArea(30,70);
    public JButton button = new JButton("Clear");

    private ActionListener clear = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        area.setText("");
        }
    };

    public GUI()
    {
        //GridLayout gridLayout = new GridLayout(2,2);
        setLayout(new FlowLayout());
        area.setEditable(false);
        add(label);
        add(area);
        add(new JScrollPane(area));
        add(button);
        button.addActionListener(clear);
        getRootPane().setDefaultButton(button);
    }
}
