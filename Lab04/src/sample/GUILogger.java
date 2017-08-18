package sample;
import ddsoft.interfaces.Logger;
import javafx.scene.chart.BarChart;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import static sample.CustomBarChart.getBarChart;
import static sample.CustomBarChart.setBarChart;
import static sample.CustomTableView.getTableView;
import static sample.CustomTableView.setTableView;
import static sample.CustomTextArea.getTextArea;
import static sample.CustomTextArea.setTextArea;

public class GUILogger implements Logger {
    public static TableView table;
    private static TextArea txtArea;
    private static BarChart bar;
    @Override
    public void log(String status, String student) {

        txtArea = getTextArea();
        table = getTableView();
        bar = getBarChart();
        switch(status){
            case "ADDED":
                txtArea.appendText("[ADDED] "+student+"\n");
                if(!table.getItems().contains(student)){
                }
                break;
            case "REMOVED":
                txtArea.appendText("[REMOVED] "+student+"\n");
                if(table.getItems().contains(student)){
                }
                break;
            case "NOTHING CHANGED":
                txtArea.appendText("[UNCHANGED]\n");
                break;
        }
        setTextArea(txtArea);
        setTableView(table);
        setBarChart(bar);

    }
}
