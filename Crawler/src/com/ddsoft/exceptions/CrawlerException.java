package com.ddsoft.exceptions;


import javax.swing.*;

public class CrawlerException extends Exception {
    public CrawlerException()
    {
        System.out.println("Missing directory, you need to declare where is the file");
        JOptionPane optionPane = new JOptionPane("Missing directory, you need to declare where is the file!",JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("WARNING!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }
}
