import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * The program is a class named Upload, Upload is the subclass of class Application.
 * The class is used to draw a upload icon.
 * The class has a start method and a main method.
 * @author: Fuwei Feng
 * @version: 2019/11/30
 */
public class Upload extends Application {

    /**
     * @param stage The window to be displayed.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Create the polygon1 object. The object is the first part of the icon.
        Polygon polygon1 = new Polygon (100,150, 150,150, 150,300, 450,300, 450,150, 500,150, 500,350, 100,350);

        // Set the polygon1 to be black
        polygon1.setFill(Color.BLACK);
        // Set the stroke color of polygon1 to be black
        polygon1.setStroke(Color.BLACK);

        // Create the polygon2 object. The object is the second part of the icon.
        Polygon polygon2 = new Polygon(275,250,  325,250, 325,100, 375,100, 300,50, 225,100, 275,100);

        // Set the polygon2 to be black
        polygon2.setFill(Color.BLACK);
        // Set the stroke color of polygon2 to be black
        polygon2.setStroke(Color.BLACK);

        // Create a Group (scene graph) with the polygon1 and polygon2 elements.
        Group root = new Group(polygon1, polygon2);

        // Create a scene with root as group, width 600, height 400.
        Scene scene = new Scene(root, 600, 400);

        // Give the stage (window) a title and add the scene.
        stage.setTitle("Upload");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method to launch the application.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
