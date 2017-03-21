package com.ddsoft.crawler;

import javax.swing.*;


public class Start {
    public static void start(final JFrame f, final int width, final int height)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setTitle("Crawler");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(800, 600);
                f.setVisible(true);
            }
        });
    }
}
