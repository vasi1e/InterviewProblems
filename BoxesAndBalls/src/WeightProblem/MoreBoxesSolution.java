package WeightProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//This is solution for the variant with more than one box
//with balls that weights 11 grams

//Summary:
//We need to take different amounts of balls from each box and
//these amounts have to be some sort of unique(their sums must not
//have duplicates)
//I found out taking 1,2,4 and after that multiplying by 10(10, 20,
//40 and again till we have amounts for each of the 10 boxes) will work
//just fine
//You get 3 groups of 3 boxes(one more with one box) and their sums
//can be easily calculated from which box they come from

//Example:
//The first, second and sixth boxes has balls that weight 11 each
//So from the first box we take 1 ball*11g, second box-2 balls*11g
//third-4 balls*10g, forth-10 balls*10g,..., sixth-40balls*11g and so on
//The weight after weighing says 17813 which is by 43 heavier than WEIGHT_IF_ALL_TEN
//This means that from the first group(1,2,4) we have sum 3 and from the second
//group(10,20,40) we have sum of 40
//From now it is easy to calculate which index of box was weighing more

public class MoreBoxesSolution implements WeightSolutionInterface{
    //This is the sum if all 10 boxes had balls with weight of 10
    private final int WEIGHT_IF_ALL_TEN = 17770;
    private Box[] boxes = null;
    //This is array to store how many balls should be taken from i-th box
    private final int[] takeNBalls = {1,2,4,10,20,40,100,200,400,1000};
    //This is table that represents the takeNBalls array but in reverse
    //(take number of box by giving how many balls were taken from it)
    private HashMap<Integer, Integer> NBallsToBox = new HashMap<>();

    private void initializeNBallsToBoxTable() {
        NBallsToBox.put(1,1);
        NBallsToBox.put(2,2);
        NBallsToBox.put(4,3);
        NBallsToBox.put(10,4);
        NBallsToBox.put(20,5);
        NBallsToBox.put(40,6);
        NBallsToBox.put(100,7);
        NBallsToBox.put(200,8);
        NBallsToBox.put(400,9);
        NBallsToBox.put(1000,10);
    }

    public MoreBoxesSolution() {
        initializeNBallsToBoxTable();
    }

    //This method have to weighs the weight of all passed balls
    private int calculateWeightOfTakenBalls() {
        int weight = 0;
        for(int i = 0; i < boxesCount; i++) {
            //We add to the weight of n balls from the i-th box
            //Here we used the array takeNBalls so that we know how
            //to separate and get the right indexes after the weighing is done
            weight += this.boxes[i].getBallWeight() * takeNBalls[i];
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
        //Get how much the weight has been risen
        int sumOfTakenBalls = weight - WEIGHT_IF_ALL_TEN;

        //Get list of all box numbers
        return transformSumToNumbers(sumOfTakenBalls);
    }

    //We know from the logic that every digit is the sum of box numbers
    //for each group so that is the point of this method
    //Get list of all numbers
    private List<Integer> transformSumToNumbers(int number) {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        while(number != 0) {
            int digit = number % 10;

            //If the digit is not 1,2 or 4 then this group
            //has 2 or 3 boxes with more weight
            if(digit != 1 && digit != 2 && digit != 4) {
                switch (digit){
                    //if the digit is 3 than boxes from which was taken
                    //1 and 2 are wanted(1and2 * 10^(current position))
                    case 3:
                        list.add(NBallsToBox.get((int) (1*Math.pow(10,i))));
                        list.add(NBallsToBox.get((int) (2*Math.pow(10,i))));
                        break;
                    //If 5 - 1 and 4
                    case 5:
                        list.add(NBallsToBox.get((int) (1*Math.pow(10,i))));
                        list.add(NBallsToBox.get((int) (4*Math.pow(10,i))));
                        break;
                    //If 6 - 2 and 4
                    case 6:
                        list.add(NBallsToBox.get((int) (2*Math.pow(10,i))));
                        list.add(NBallsToBox.get((int) (4*Math.pow(10,i))));
                        break;
                    //If 7 - all of them
                    case 7:
                        list.add(NBallsToBox.get((int) (1*Math.pow(10,i))));
                        list.add(NBallsToBox.get((int) (2*Math.pow(10,i))));
                        list.add(NBallsToBox.get((int) (4*Math.pow(10,i))));
                        break;
                }
            } else {
                list.add(NBallsToBox.get((int)(digit*Math.pow(10,i))));
            }
            i++;
            number /= 10;
        }

        return list;
    }
}
