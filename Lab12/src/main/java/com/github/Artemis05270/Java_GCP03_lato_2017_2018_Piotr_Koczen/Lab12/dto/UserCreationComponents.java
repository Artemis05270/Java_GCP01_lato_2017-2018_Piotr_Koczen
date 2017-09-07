package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto;

import javax.swing.*;


public class UserCreationComponents {

    private JButton newAccountButton;
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JTextField emailTextField;

    public JButton getNewAccountButton() {
        return newAccountButton;
    }

    public void setNewAccountButton(JButton newAccountButton) {
        this.newAccountButton = newAccountButton;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public void setUsernameTextField(JTextField usernameTextField) {
        this.usernameTextField = usernameTextField;
    }

    public JPasswordField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }
}
