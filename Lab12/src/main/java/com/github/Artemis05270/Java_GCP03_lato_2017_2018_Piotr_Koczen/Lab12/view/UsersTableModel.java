package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view;

import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.domain.User;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

public class UsersTableModel extends AbstractTableModel {

    private static final int USERNAME_COLUMN_INDEX = 1;
    private static final int EMAIL_COLUMN_INDEX = 2;
    private String[] columnNames = {"ID ", "Username", "Email", "Created At", "Last Login"};
    private List<User> users;

    public UsersTableModel(List<User> users) {
        this.users = users;
    }

    public int getRowCount() {
        return users.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        int userId = user.getId();
        String username = user.getUsername();
        String email = user.getEmail();
        LocalDateTime createdAt = user.getCreatedAt();
        LocalDateTime lastLogin = user.getLastLogin();
        Object[] values = new Object[]{userId, username, email, createdAt, lastLogin};

        return values[columnIndex];
    }

    public boolean isCellEditable(int row, int col) {
        return true;
    }

    public void setValueAt(Object value, int row, int column) {
        User user = users.get(row);
        switch (column) {
            case USERNAME_COLUMN_INDEX:
                user.setUsername((String) value);
                break;
            case EMAIL_COLUMN_INDEX:
                user.setEmail((String) value);
                break;
        }

        fireTableCellUpdated(row, column);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public List<User> getUsers() {
        return users;
    }
}