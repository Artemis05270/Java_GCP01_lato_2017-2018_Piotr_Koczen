package sample;
import javafx.scene.control.TextArea;
public class CustomTextArea {

    public static TextArea txtArea;

    public static TextArea display() {

        txtArea= new TextArea();
        txtArea.setPrefRowCount(10);
        txtArea.setPrefColumnCount(100);
        txtArea.setWrapText(true);
        txtArea.setPrefWidth(400);
        txtArea.appendText("");

        return txtArea;
    }

    public static TextArea getTextArea() {
        return txtArea;
    }

    public static void setTextArea(final TextArea textArea) {
        txtArea = textArea;
    }

}