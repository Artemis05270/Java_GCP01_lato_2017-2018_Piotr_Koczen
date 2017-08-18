package sample;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class CustomMenuBar extends MenuBar {

    public static MenuBar display() {


        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("Program");
        MenuItem exitMenuItem = new MenuItem("Close");
        exitMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN));
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        menuFile.getItems().addAll(exitMenuItem);
        Menu menuAbout = new Menu("About");
        MenuItem menuItemAbout = new MenuItem("About");
        menuItemAbout.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Example program informations");
            alert.setContentText("Author: Piotr Koczeń");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        });
        menuAbout.getItems().addAll(menuItemAbout);
        menuBar.getMenus().addAll(menuFile, menuAbout);


        return menuBar;

    }
}

