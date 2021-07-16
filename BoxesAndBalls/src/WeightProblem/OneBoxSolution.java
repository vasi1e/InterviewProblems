package WeightProblem;

//This is solution for the variant with only one box
//with balls that weights 11 grams

import java.util.ArrayList;
import java.util.List;

//Summary:
//If we numerate the boxes from 1 to 10(if there are 10 boxes)
//we can take exactly N balls from the N-th box
//After collecting the balls from the boxes we put them
//on the scale
//The weight that we got will have last digit representing
//the number of the box that has balls with weight 11
public class OneBoxSolution implements WeightSolutionInterface{
    private Box[] boxes = null;
    private final int WEIGHT_IF_ALL_TEN = 550;

    //This method have to weighs the weight of all passed balls
    private int calculateWeightOfTakenBalls() {
        int weight = 0;
        for(int i = 1; i <= boxesCount; i++) {
            //We add to the weight of i-th balls from the i-th box
            weight += this.boxes[i-1].getBallWeight() * i;
        }

        return weight;
    }

    @Override
    public void addBoxes(Box[] boxes) throws Exception {
        if(boxes.length != boxesCount) {
            throw new Exception("The passed array isn't in valid size");
        }

        this.boxes = boxes;
    }

    @Override
    public List<Integer> getBoxesWithMoreWeight() throws Exception {
        if(this.boxes == null) {
            throw new Exception("The array isn't initialized(call method addBoxes)");
        }

        //Do the one weighing
        int weight = this.calculateWeightOfTakenBalls();
        List<Integer> list = new ArrayList<>();
        if (weight != WEIGHT_IF_ALL_TEN) {
            //Take the last digit representing the number of the box
            int number = weight % 10;
            if(number == 0) {
                number = 10;
            }

            list.add(number);
        }

        return list;
    }
}
