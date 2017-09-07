package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.controller;

import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.domain.User;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto.UserCreationComponents;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto.UserTableComponents;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.repository.UserRepository;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view.SignupView;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view.UsersTableModel;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view.UsersTableView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserController implements ActionListener {

    private static final String LOGIN_INCORRECT_MESSAGE = "Username/Password incorrect.";
    private UserRepository userRepository;
    private UsersTableView usersTableView;
    private UserTableComponents userTableComponents;
    private JPanel userPanel;
    private UserCreationComponents userCreationComponents;

    public UserController(UserRepository userRepository, UserTableComponents userTableComponents) {
        this.userRepository = userRepository;
        this.userTableComponents = userTableComponents;
        List<User> users = userRepository.getUsers();
        UsersTableModel usersTableModel = new UsersTableModel(users);
        usersTableView = new UsersTableView(usersTableModel);
        userPanel = usersTableView.createUsersPanel();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JFrame mainFrame = userTableComponents.getMainFrame();
        JPanel loginPanel = userTableComponents.getLoginPanel();
        JPanel signupPanel = userTableComponents.getSignupPanel();
        Map<String, JTextField> credentialsTextFields = userTableComponents.getCredentialsTextFields();
        String username = credentialsTextFields.get("username").getText();
        String password = credentialsTextFields.get("password").getText();
        Optional<User> user = userRepository.login(username, password);
        JButton loginButton = userTableComponents.getLoginButton();
        JButton signupButton = userTableComponents.getSignupButton();
        JButton newAccountButton = userCreationComponents.getNewAccountButton();

        boolean isSignupButtonPressed = event.getSource().equals(signupButton);
        boolean isLoginButtonPressed = event.getSource().equals(loginButton);
        boolean isSignupButtonClicked = event.getSource().equals(newAccountButton);

        if (isSignupButtonPressed) {
            JOptionPane.showOptionDialog(null, signupPanel,"New Account",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, // NO Icon
                    null,
                    new Object[] {},  // No options
                    null);
        }

        if (isLoginButtonPressed) {
            validateCredentialsView(mainFrame, loginPanel, loginButton, user);
        }

        if (isSignupButtonClicked) {
            Map<String, String> newAccountCredentials = createNewAccountCredentials();
            validateNewAccountCredentials(signupPanel, newAccountCredentials);
        }
    }

    private void validateNewAccountCredentials(JPanel parentComponent, Map<String, String> newAccountCredentials) {
        if (newAccountCredentials == null) {
            throw new IllegalArgumentException("Credentials cannot be null.");
        }

        String username = newAccountCredentials.get("username");
        String password = newAccountCredentials.get("password");
        String email = newAccountCredentials.get("email");

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(parentComponent, "Username cannot be empty.");
            return;
        }

        if (password.isEmpty()) {
            JOptionPane.showMessageDialog(parentComponent, "Password cannot be empty.");
            return;
        }

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(parentComponent, "Email cannot be empty.");
            return;
        }

        userRepository.create(newAccountCredentials);
    }

    private void validateCredentialsView(JFrame mainFrame, JPanel loginPanel, JButton loginButton, Optional<User> user) {
        if (user.isPresent()) {
            mainFrame.remove(loginPanel);
            mainFrame.add(userPanel);
            mainFrame.revalidate();
            mainFrame.repaint();
        } else {
            JOptionPane.showMessageDialog(loginButton, LOGIN_INCORRECT_MESSAGE);
        }
    }

    public UsersTableView getUsersTableView() {
        return usersTableView;
    }

    private Map<String, String> createNewAccountCredentials() {
        Map<String, String> newAccountCredentials = new HashMap<>();
        String username = userCreationComponents.getUsernameTextField().getText();
        char[] newAccountPasswordArray = userCreationComponents.getPasswordTextField().getPassword();
        String password = new String(newAccountPasswordArray);
        String email = userCreationComponents.getEmailTextField().getText();
        newAccountCredentials.put("username", username);
        newAccountCredentials.put("password", password);
        newAccountCredentials.put("email", email);
        return newAccountCredentials;
    }

    public void setUserCreationComponents(UserCreationComponents userCreationComponents) {
        this.userCreationComponents = userCreationComponents;
    }
}
