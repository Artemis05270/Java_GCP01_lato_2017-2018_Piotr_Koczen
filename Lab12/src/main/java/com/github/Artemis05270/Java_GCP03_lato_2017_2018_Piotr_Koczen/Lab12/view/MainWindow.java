package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view;

import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.controller.UserController;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto.UserCreationComponents;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto.UserTableComponents;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.repository.UserRepository;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class MainWindow {

    private static final int MAIN_WINDOW_WIDTH = 640;
    private static final int MAIN_WINDOW_HEIGHT = 480;
    private static final int USERNAME_TEXTFIELD_COLUMN_WIDTH = 20;
    private static final int PASSWORD_TEXTFIELD_COLUMN_WIDTH = 20;
    private JFrame mainFrame;
    private JPanel loginPanel;
    private JButton newAccountButton;

    public MainWindow() {
        UserRepository userRepository = new UserRepository();

        loginPanel = createLoginPanel();
        Map<String, JPanel> panels = new HashMap<>();
        panels.put("loginPanel", loginPanel);
        createMainFrame(panels);

        // Login data fields
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        createUsernameLabel(gridBagConstraints, loginPanel);
        JTextField usernameTextField = createUsernameTextField(gridBagConstraints, loginPanel);
        createPasswordLabel(gridBagConstraints, loginPanel);
        JPasswordField passwordTextField = createPasswordTextField(gridBagConstraints, loginPanel);

        Map<String, JTextField> credentialsTextFields = createCredentials(usernameTextField, passwordTextField);
        JButton loginButton = createLoginButton(gridBagConstraints, loginPanel);
        JButton signupButton = createSignupButton(gridBagConstraints, loginPanel);

        SignupView signupView = new SignupView();
        JPanel signupPanel = signupView.createSignupPanel();
        UserTableComponents userTableComponents = createUserTableComponents(loginPanel, signupPanel, credentialsTextFields, loginButton, signupButton);
        UserController userController = new UserController(userRepository, userTableComponents);

        JButton newAccountButton = createNewAccountButton(signupPanel, userController);

        UserCreationComponents userCreationComponents = new UserCreationComponents();
        userCreationComponents.setNewAccountButton(newAccountButton);
        userCreationComponents.setUsernameTextField(signupView.getUsernameTextField());
        userCreationComponents.setPasswordTextField(signupView.getPasswordTextField());
        userCreationComponents.setEmailTextField(signupView.getEmailTextField());

        userController.setUserCreationComponents(userCreationComponents);

        loginButton.addActionListener(userController);
        signupButton.addActionListener(userController);

        JTable usersTableView = userController.getUsersTableView().getUsersTable();
        UsersTableListener usersTableListener = new UsersTableListener(usersTableView, userRepository);
    }

    private JButton createNewAccountButton(JPanel signupPanel, UserController userController) {
        newAccountButton = new JButton("Create New Account");
        newAccountButton.addActionListener(userController);
        GridBagConstraints createNewAccountButtonConstraints = new GridBagConstraints();
        createNewAccountButtonConstraints.gridx = 0;
        createNewAccountButtonConstraints.gridy = 4;
        signupPanel.add(newAccountButton, createNewAccountButtonConstraints);
        return newAccountButton;
    }

    public JPanel createLoginPanel() {
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        return loginPanel;
    }

    public JFrame createMainFrame(Map<String, JPanel> panels) {
        JPanel loginPanel = panels.get("loginPanel");
        mainFrame = new JFrame();
        mainFrame.add(loginPanel);
        mainFrame.setTitle(Messages.MAIN_WINDOW_TITLE);
        mainFrame.setPreferredSize(new Dimension(MAIN_WINDOW_WIDTH, MAIN_WINDOW_HEIGHT));
        mainFrame.setVisible(true);
        mainFrame.pack();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        return mainFrame;
    }

    private JButton createSignupButton(GridBagConstraints gridBagConstraints, JPanel loginPanel) {
        JButton createSignupButton = new JButton("Create new Account");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        loginPanel.add(createSignupButton, gridBagConstraints);

        return createSignupButton;
    }

    private JButton createLoginButton(GridBagConstraints gridBagConstraints, JPanel loginPanel) {
        JButton loginButton = new JButton("Sign in");

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;

        loginPanel.add(loginButton, gridBagConstraints);
        return loginButton;
    }

    private UserTableComponents createUserTableComponents(JPanel loginPanel, JPanel signupPanel,
                                                          Map<String, JTextField> credentialsTextFields,
                                                          JButton loginButton, JButton signupButton) {
        UserTableComponents userTableComponents = new UserTableComponents();
        userTableComponents.setLoginButton(loginButton);
        userTableComponents.setSignupPanel(signupPanel);
        userTableComponents.setSignupButton(signupButton);
        userTableComponents.setLoginPanel(loginPanel);
        userTableComponents.setMainFrame(mainFrame);
        userTableComponents.setCredentialsTextFields(credentialsTextFields);
        return userTableComponents;
    }

    private Map<String, JTextField> createCredentials(JTextField usernameTextField, JTextField passwordTextField) {
        Map<String, JTextField> credentialsTextFields = new HashMap<>();
        credentialsTextFields.put("username", usernameTextField);
        credentialsTextFields.put("password", passwordTextField);
        return credentialsTextFields;
    }

    private JPasswordField createPasswordTextField(GridBagConstraints gridBagConstraints, JPanel loginPanel) {
        JPasswordField passwordTextField = new JPasswordField(PASSWORD_TEXTFIELD_COLUMN_WIDTH);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;

        loginPanel.add(passwordTextField, gridBagConstraints);

        return passwordTextField;
    }

    private JLabel createPasswordLabel(GridBagConstraints gridBagConstraints, JPanel loginPanel) {
        JLabel passwordLabel = new JLabel("Password");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        loginPanel.add(passwordLabel, gridBagConstraints);

        return passwordLabel;
    }

    private JLabel createUsernameLabel(GridBagConstraints gridBagConstraints, JPanel loginPanel) {
        JLabel usernameLabel = new JLabel("Username:");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        loginPanel.add(usernameLabel, gridBagConstraints);

        return usernameLabel;
    }

    private JTextField createUsernameTextField(GridBagConstraints gridBagConstraints, JPanel loginPanel) {
        JTextField usernameTextField = new JTextField(USERNAME_TEXTFIELD_COLUMN_WIDTH);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;

        loginPanel.add(usernameTextField, gridBagConstraints);

        return usernameTextField;
    }
}
