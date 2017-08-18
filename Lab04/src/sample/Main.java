package sample;
import ddsoft.crawler.Crawler;
import javafx.concurrent.Task;
import javafx.application.Application;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.MenuBar;




public class Main extends Application {

    private static AnchorPane root;
    private static MenuBar menuBar;
    private static TabPane tabPane;


    public void start(Stage stage) throws Exception{

        Crawler test = new Crawler();
        test.enableLogAdd();
        test.enableLogRemove();
        //test.disableLogisModifed();
        test.enableLogIteration();
        test.enableLogIsModifed();
        test.changeDirectory("S:\\Lab04\\students.txt");

        stage.setTitle("JavaFX hard programming");
        Scene scene = new Scene(new VBox(), 400, 350);
        scene.setFill(Color.OLDLACE);
        root= new AnchorPane();
        menuBar= CustomMenuBar.display();
        tabPane= CustomTabPane.display();


        AnchorPane.setTopAnchor(menuBar, 5.0);
        AnchorPane.setTopAnchor(tabPane, 30.0);
        AnchorPane.setBottomAnchor(tabPane, 20.0);
        AnchorPane.setRightAnchor(menuBar,0.0);
        AnchorPane.setLeftAnchor(menuBar,0.0);
        AnchorPane.setRightAnchor(tabPane,0.0);
        AnchorPane.setLeftAnchor(tabPane,0.0);
        menuBar.prefWidthProperty().bind(scene.widthProperty());
        tabPane.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().addAll(menuBar,tabPane);
        menuBar.isResizable();




        scene= new Scene(root,400,350);
        scene.setFill(Color.OLDLACE);

        stage.setScene(scene);
        stage.show();

        Task task = new Task<Void>() {
            @Override
            public Void call() throws Exception {
                test.run();
                return null;
            }
        };
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();


}


    public static void main(String[] args) {
        launch(args);
    }
}
