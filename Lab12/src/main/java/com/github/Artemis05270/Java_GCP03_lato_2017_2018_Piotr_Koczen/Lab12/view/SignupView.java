package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.view;


import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.controller.UserController;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto.UserCreation;
import com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.repository.UserRepository;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class SignupView {

    private static final String USERNAME_LABEL = "Username";
    private static final String PASSWORD_LABEL = "Password";
    private static final String EMAIL_LABEL = "Email";
    private static final int TEXT_FIELDS_COLUMN_WIDTH = 20;
    private static final String SIGNUP_BUTTON_LABEL = "Create Account";
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JPanel signupPanel;

    public JPanel createSignupPanel() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        signupPanel = new JPanel(new GridBagLayout());

        distributeUsernameLabel(gridBagConstraints);
        distributeUsernameTextField(gridBagConstraints);
        distributeEmailLabel(gridBagConstraints);
        distributeEmailTextField(gridBagConstraints);
        distributePasswordLabel(gridBagConstraints);
        distributePasswordTextField(gridBagConstraints);

        return signupPanel;
    }

    private void distributeUsernameLabel(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        signupPanel.add(createUsernameLabel(), gridBagConstraints);
    }

    private void distributeUsernameTextField(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        signupPanel.add(createUsernameTextField(), gridBagConstraints);
    }

    private void distributeEmailLabel(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        signupPanel.add(createEmailLabel(), gridBagConstraints);
    }

    private void distributeEmailTextField(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        signupPanel.add(createEmailTextField(), gridBagConstraints);
    }

    private void distributePasswordLabel(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        signupPanel.add(createPasswordLabel(), gridBagConstraints);
    }

    private void distributePasswordTextField(GridBagConstraints gridBagConstraints) {
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        signupPanel.add(createPasswordTextField(), gridBagConstraints);
    }

    public JLabel createUsernameLabel() {
        usernameLabel = new JLabel(USERNAME_LABEL);
        return usernameLabel;
    }

    public JLabel createEmailLabel() {
        emailLabel = new JLabel(EMAIL_LABEL);
        return emailLabel;
    }

    public JLabel createPasswordLabel() {
        passwordLabel = new JLabel(PASSWORD_LABEL);
        return passwordLabel;
    }

    public JTextField createUsernameTextField() {
        usernameTextField = new JTextField(TEXT_FIELDS_COLUMN_WIDTH);
        return usernameTextField;
    }

    public JPasswordField createPasswordTextField() {
        passwordTextField = new JPasswordField(TEXT_FIELDS_COLUMN_WIDTH);
        return passwordTextField;
    }

    public JTextField createEmailTextField() {
        emailTextField = new JTextField(TEXT_FIELDS_COLUMN_WIDTH);
        return emailTextField;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }
}
