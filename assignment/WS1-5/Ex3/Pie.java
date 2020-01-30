import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The program is a class named Pie, the class is used to draw the pie chart.
 * The class has a countValue method, getAngleOfExpenditure method, makePie method, start method and main method.
 *
 * @author: Fuwei Feng
 * @version: 2019/12/1
 */
public class Pie extends Application {

    public static final int maximum = 8;
    Expenditure[] expenditures = new Expenditure[] {
            new Expenditure("Salaries", 11000),
            new Expenditure("Paper", 2000),
            new Expenditure("Rent", 5000),
            new Expenditure("Most popular books on Java etc.", 10000),
            new Expenditure("Heating", 3000),
            new Expenditure("Coffee/Tea", 7000),
            new Expenditure("Biscuits", 8000),
            new Expenditure("Travel", 18000),
            new Expenditure("Electricity", 1000),
            new Expenditure("Pencils", 3000)
    };

    /**
     * The method is used to calculate the total value of expenditures.
     * @return totalValue
     */
    public static double countValue(Expenditure[] expenditures) {
        double totalValue = 0;
        for (int i = 0; i < expenditures.length; i++) {
            totalValue = totalValue + expenditures[i].getValue();
        }
        return totalValue;
    }

    /**
     * The method is used to get the angle of different expenditures.
     * @param expenditures
     * @return
     */
    public static ArrayList<Double> getAngleOfExpenditure(Expenditure[] expenditures) {

        ArrayList<Double> angleList = new ArrayList<>();

        if (expenditures.length <= maximum) {
            for (int i = 0; i < expenditures.length; i++) {
                double angel = expenditures[i].getValue()/countValue(expenditures) * 360;
                angleList.add(angel);
            }
        } else {
            for (int i = 0; i < maximum-1; i++) {
                double angel = expenditures[i].getValue()/countValue(expenditures) * 360;
                angleList.add(angel);
            }
        }

        return angleList;
    }

    /**
     * The makePie method is used to draw the pie chart to show the expenditures.
     */
    public void makePie(Group root) {
        // Sort the expenditures from the biggest value to the smallest.
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) -> exp2.getValue() - exp1.getValue());

        // Set the center of the circle. and the radius of the circle.
        double xOffset = 400;
        double yOffset = 200;
        double radius = 100;
        double angle = 0;

        Circle circle = new Circle(xOffset, yOffset, radius);
        Line mainLine = new Line(xOffset,yOffset, xOffset+radius,yOffset);

        ArrayList<Line> lineList = new ArrayList<>();
        ArrayList<Text> textList = new ArrayList<>();

        // The for loop is used to draw the line of every expenditure in the expenditures, and show the description of every expenditure.
        for (int i = 0; i < getAngleOfExpenditure(expenditures).size(); i++) {
            double textAngle = angle + getAngleOfExpenditure(expenditures).get(i)/ 2;
            double testRealAngle = Math.toRadians(textAngle);
            Text text = new Text(xOffset+(radius+radius/3) * Math.cos(testRealAngle),
                                yOffset-(radius+radius/3) * Math.sin(testRealAngle),
                                    expenditures[i].getDescription());
            angle = angle + getAngleOfExpenditure(expenditures).get(i);
            double realAngle = Math.toRadians(angle);
            Line line = new Line(xOffset,yOffset, xOffset+radius * Math.cos(realAngle),yOffset-radius* Math.sin(realAngle));
            lineList.add(line);
            textList.add(text);
        }

        // Set the rest of the expenditures to be showed as other.
        Text text = new Text(xOffset + (radius+radius/3)*Math.cos(Math.toRadians(angle+(360-angle)/2)),
                            yOffset-(radius+radius/3)*Math.sin(Math.toRadians(angle+(360-angle)/2)),
                             "Other");
        textList.add(text);

        // Set the long description does not block the circle.
        textList.get(2).setX(textList.get(2).getX() - textList.get(2).getLayoutBounds().getWidth());

        // Set the circle to be filled nothing.
        circle.setFill(null);

        // Set the stroke of the circle to be black.
        circle.setStroke(Color.BLACK);

        // Draw the circle on the root.
        root.getChildren().add(circle);

        // Draw the mainLine on the root.
        root.getChildren().add(mainLine);

        // Draw the lines on the root.
        root.getChildren().addAll(lineList);

        // Draw the texts on the root.
        root.getChildren().addAll(textList);
    }

    /**
     * @param stage     The window to be displayed.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Create the root object.
        Group root = new Group();

        // Draw the pie chart.
        makePie(root);

        // Set the size of the scene.
        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("Pie");
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
