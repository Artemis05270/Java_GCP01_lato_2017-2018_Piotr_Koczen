package com.github.Artemis05270.Java_GCP03_lato_2017_2018_Piotr_Koczen.Lab12.dto;

import javax.swing.*;
import java.util.Map;

public class UserTableComponents {

    private JPanel loginPanel;
    private JPanel signupPanel;
    private JFrame mainFrame;
    private JButton loginButton;
    private JButton signupButton;
    private JButton newAccountButton;
    private Map<String, JTextField> credentialsTextFields;

    public JPanel getLoginPanel() {
        return loginPanel;
    }

    public void setLoginPanel(JPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public Map<String, JTextField> getCredentialsTextFields() {
        return credentialsTextFields;
    }

    public void setCredentialsTextFields(Map<String, JTextField> credentialsTextFields) {
        this.credentialsTextFields = credentialsTextFields;
    }

    public JButton getSignupButton() {
        return signupButton;
    }

    public void setSignupButton(JButton signupButton) {
        this.signupButton = signupButton;
    }

    public JPanel getSignupPanel() {
        return signupPanel;
    }

    public void setSignupPanel(JPanel signupPanel) {
        this.signupPanel = signupPanel;
    }

    public JButton getNewAccountButton() {
        return newAccountButton;
    }

    public void setNewAccountButton(JButton newAccountButton) {
        this.newAccountButton = newAccountButton;
    }
}
