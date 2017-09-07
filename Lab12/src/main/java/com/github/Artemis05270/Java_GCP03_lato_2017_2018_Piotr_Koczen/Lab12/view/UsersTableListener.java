package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view;

import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.domain.User;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.repository.UserRepository;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;


public class UsersTableListener implements TableModelListener {

    private JTable userTable;
    private UserRepository userRepository;

    public UsersTableListener(JTable userTable, UserRepository userRepository) {
        this.userTable = userTable;
        this.userRepository = userRepository;

        userTable.getModel().addTableModelListener(this);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        UsersTableModel usersTableModel = (UsersTableModel) e.getSource();
        User user = usersTableModel.getUsers().get(row);
        String columnName = usersTableModel.getColumnName(column);
        Object newValue = usersTableModel.getValueAt(row, column);

        userRepository.update(user);
    }
}
