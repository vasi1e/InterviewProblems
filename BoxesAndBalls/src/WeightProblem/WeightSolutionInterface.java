package WeightProblem;

import java.util.List;

//This problem has two variants
//but they both have somethings in common
//we will make interface to be extended by them
public interface WeightSolutionInterface {
    //The problem says that we have 10 boxes
    //The both solutions will work fine if you insert less than 10
    //but not with more than 10
    int boxesCount = 10;
    void addBoxes(Box[] boxes) throws Exception;
    List<Integer> getBoxesWithMoreWeight() throws Exception;
}