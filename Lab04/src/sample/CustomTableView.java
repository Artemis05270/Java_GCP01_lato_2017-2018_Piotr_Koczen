package sample;
import ddsoft.crawler.Student;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


public class CustomTableView extends AnchorPane {

    private static TableView<Student> table;


    public static TableView display() {


        table = new TableView();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        TableColumn<Student, Double> markColumn = new TableColumn("Mark");
        markColumn.setCellValueFactory(new PropertyValueFactory<>("mark"));

        TableColumn<Student, String> nameColumn = new TableColumn("First name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Student, String> lastNameColumn = new TableColumn("Last name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Student, Integer> ageColumn = new TableColumn("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));


        table.getColumns().addAll(markColumn, nameColumn, lastNameColumn, ageColumn);

        return table;
    }


    public static TableView getTableView() {
        return table;
    }

    public static void setTableView(final TableView tableView) {
        table = tableView;
    }

}