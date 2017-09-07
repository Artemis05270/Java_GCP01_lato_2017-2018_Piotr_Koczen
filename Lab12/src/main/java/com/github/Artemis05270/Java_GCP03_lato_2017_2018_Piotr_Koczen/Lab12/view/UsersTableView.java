package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view;

import javax.swing.*;
import java.awt.*;

public class UsersTableView {

    private JPanel usersPanel;
    private JTable usersTable;

    public UsersTableView( UsersTableModel usersTableModel) {
        usersPanel = new JPanel();
        usersTable = new JTable(usersTableModel);
    }

    public JPanel createUsersPanel() {
        usersPanel.setLayout(new GridBagLayout());
        GridBagConstraints userPanelConstraints = new GridBagConstraints();
        userPanelConstraints.gridx = 0;
        userPanelConstraints.gridy = 0;
        usersPanel.add(new JScrollPane(usersTable), userPanelConstraints);
        return usersPanel;
    }

    public JTable getUsersTable() {
        return usersTable;
    }

}
