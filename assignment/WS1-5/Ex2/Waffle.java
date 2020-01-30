import javafx.application.Application;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The program is a class named Waffle, the class is used to draw a waffle chart.
 * The class has a countValue method, squareWidth method, makeWaffle method, makeExample method, makeDescription method,
 * start method and the main method.
 *
 * @author: Fuwei Feng
 * @version: 2019/11/30
 */
public class Waffle extends Application {

    private final static int gap = 3;
    private final static int maximum = 8;
    private Expenditure[] expenditures = new Expenditure[] {
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
     * The method is used to get the width of the square.
     * @param gap   The gap between squares.
     * @return the width of the square.
     */
    public static int squareWidth(int gap) {
        return gap* 10;
    }

    /**
     * The method is used to draw the waffle chart.
     * And paint the chart with different colors.
     *
     * @param root      The scene graph.
     */
    public void makeWaffle(Group root) {
        // The ArrayList rlist is used to store the square of the waffle chart.
        ArrayList<Rectangle> rlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                rlist.add(new Rectangle((squareWidth(gap) + gap) *j + squareWidth(gap)+gap,
                        (squareWidth(gap)+gap)*i+squareWidth(gap)+gap,
                        squareWidth(gap),
                        squareWidth(gap)));
            }
        }

        // The ArrayList numberOFRectangle is used to store the number that every expenditure will use how many squares.
        ArrayList<Integer> numberOFRectangle = new ArrayList<>();
        for (int i = 0; i < maximum-1; i++) {
            numberOFRectangle.add((int) Math.round((double)expenditures[i].getValue()/countValue(expenditures)*(double)100));
        }

        // The for loop is used to paint the waffle chart.
        for (int i = 0; i < rlist.size(); i++) {
            if (i < numberOFRectangle.get(0)) {
                rlist.get(i).setFill(Color.BLACK);
            } else if (i < numberOFRectangle.get(0) + numberOFRectangle.get(1)) {
                rlist.get(i).setFill(Color.BLUE);
            } else if (i < numberOFRectangle.get(0) + numberOFRectangle.get(1) + numberOFRectangle.get(2)){
                rlist.get(i).setFill(Color.RED);
            } else if (i < numberOFRectangle.get(0) + numberOFRectangle.get(1) + numberOFRectangle.get(2) + numberOFRectangle.get(3)){
                rlist.get(i).setFill(Color.YELLOW);
            } else if (i < numberOFRectangle.get(0) + numberOFRectangle.get(1) + numberOFRectangle.get(2) + numberOFRectangle.get(3)
            + numberOFRectangle.get(4)){
                rlist.get(i).setFill(Color.GREEN);
            } else if (i < numberOFRectangle.get(0) + numberOFRectangle.get(1) + numberOFRectangle.get(2) + numberOFRectangle.get(3)
                    + numberOFRectangle.get(4) + numberOFRectangle.get(5)){
                rlist.get(i).setFill(Color.DARKRED);
            } else if (i < numberOFRectangle.get(0) + numberOFRectangle.get(1) + numberOFRectangle.get(2) + numberOFRectangle.get(3)
                    + numberOFRectangle.get(4) + numberOFRectangle.get(5) + numberOFRectangle.get(6)){
                rlist.get(i).setFill(Color.DARKBLUE);
            } else {
                rlist.get(i).setFill(Color.DEEPSKYBLUE);
            }
        }
        root.getChildren().addAll(rlist);
    }

    /**
     * The makeExample method is used to draw the legend.
     *
     * @param root
     */
    public void makeExample(Group root) {
        // The ArrayList exampleList is used to store the square of the legend.
        ArrayList<Rectangle> exampleList = new ArrayList<>();
        for (int i = 0; i < maximum; i++) {
            exampleList.add(new Rectangle((squareWidth(gap)+gap) * 12,
                    (squareWidth(gap)+gap)*(i + 2),
                    squareWidth(gap),
                    squareWidth(gap)));
        }
        exampleList.get(0).setFill(Color.BLACK);
        exampleList.get(1).setFill(Color.BLUE);
        exampleList.get(2).setFill(Color.RED);
        exampleList.get(3).setFill(Color.YELLOW);
        exampleList.get(4).setFill(Color.GREEN);
        exampleList.get(5).setFill(Color.DARKRED);
        exampleList.get(6).setFill(Color.DARKBLUE);
        exampleList.get(7).setFill(Color.DEEPSKYBLUE);
        root.getChildren().addAll(exampleList);
    }

    /**
     * The makeDescription method is used to print the text of every legend.
     *
     * @param root
     */
    public void makeDescription(Group root) {
        /**
         * For an array of up to maximum elements, display all elements.
         * For an array with more than maximum elements. display only the maximum-1 biggest ones and accumulate the others summed up
         * as an entry with the description "Other".
         */
        if (expenditures.length <= maximum) {
            for (int i = 0; i < maximum; i ++) {
                Text text = new Text((gap*10+gap) * 12 + gap*12,
                        (gap*10+gap)*(i + 2)+gap*5,
                        expenditures[i].getDescription());
                root.getChildren().addAll(text);
            }
        } else {
            for (int i = 0; i < maximum - 1; i ++) {
                Text text = new Text((gap*10+gap) * 12 + gap*12,
                        (gap*10+gap)*(i + 2)+gap*5,
                        expenditures[i].getDescription());
                root.getChildren().addAll(text);
            }
            Text text = new Text ((gap*10+gap) * 12 + gap*12,
                    (gap*10+gap)*(7 + 2)+ gap*5,
                    "Other");
            root.getChildren().addAll(text);
        }
    }

    /**
     * @param stage     The window to be displayed.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        // Sort the array from the biggest to the smallest.
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) -> exp2.getValue() - exp1.getValue());
        makeDescription(root);
        makeWaffle(root);
        makeExample(root);
        Scene scene = new Scene(root, 650, 400);
        stage.setTitle("Waffle");
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
