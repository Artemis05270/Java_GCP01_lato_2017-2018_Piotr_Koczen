package sample;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.chart.BarChart;


public class CustomTabPane extends AnchorPane {
    private static VBox vBox;
    private static TabPane tabPane;
    public static TableView table;
    private static TextArea textArea;
    private static BarChart barChart;

    public static TabPane display() {

        tabPane = new TabPane();
        vBox= new VBox();

        Tab studentsTab = new Tab();
        studentsTab.setText("Students");
        studentsTab.setContent(vBox);
        studentsTab.setClosable(false);
        tabPane.getTabs().add(studentsTab);
        table=CustomTableView.display();
        vBox.getChildren().addAll(table);


        Tab logTab = new Tab();
        logTab.setText("Log");
        textArea= CustomTextArea.display();
        logTab.setContent(textArea);
        logTab.setClosable(false);
        tabPane.getTabs().add(logTab);


        Tab histogramTab = new Tab();
        histogramTab.setText("Histogram");
        barChart= CustomBarChart.display();
        histogramTab.setContent(barChart);
        histogramTab.setClosable(false);
        tabPane.getTabs().add(histogramTab);




        return tabPane;
    }
}
