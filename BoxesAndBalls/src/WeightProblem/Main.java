package WeightProblem;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static int boxCount = WeightSolutionInterface.boxesCount;

    private static Box[] initializeBoxes() {
        Box[] boxes = new Box[boxCount];
        for(int i = 0; i < boxCount; i++) {
            boxes[i] = new Box();
        }

        return boxes;
    }

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Box[] boxes = initializeBoxes();
        WeightSolutionInterface ws = null;
        System.out.println("There are 10 boxes with 1000 balls. The balls weight 10 grams.\n" +
                "With one weighing on scale say which box has balls with weight of 11 grams");

        //To try the solution uncomment the piece for your needs

        //This one for one box
        /*
        ws = new OneBoxSolution();
        int index = random.nextInt(10);
        boxes[index].setBallWeight(BALL_WEIGHT.ELEVEN);
        */

        //This one for more boxes but also works for one
        /*
        ws = new MoreBoxesSolution();
        int times = random.nextInt(9) + 1;
        for(int i = 0; i < times; i++) {
            int index = random.nextInt(10);
            boxes[index].setBallWeight(BALL_WEIGHT.ELEVEN);
        }
        */

        ws.addBoxes(boxes);
        ws.getBoxesWithMoreWeight();
    }
}
