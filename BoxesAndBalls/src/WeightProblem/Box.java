package WeightProblem;

//This represents the two possible weights of one ball
enum BALL_WEIGHT{
    TEN(10), ELEVEN(11);
    private final int weight;

    BALL_WEIGHT(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }
};

//This represents the box by the weight of one ball that is in it
public class Box {
    private BALL_WEIGHT ballWeight;

    public Box() {
        this.ballWeight = BALL_WEIGHT.TEN;
    }

    public int getBallWeight() {
        return ballWeight.getWeight();
    }

    public void setBallWeight(BALL_WEIGHT ballWeight) {
        this.ballWeight = ballWeight;
    }
}
