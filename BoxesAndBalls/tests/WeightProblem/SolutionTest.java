package WeightProblem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    private Box[] boxes;
    private WeightSolutionInterface solution;

    @BeforeEach
    public void initBoxes() {
        boxes = new Box[WeightSolutionInterface.boxesCount];
        for(int i = 0; i < WeightSolutionInterface.boxesCount; i++) {
            boxes[i] = new Box();
        }
    }

    @Nested
    @DisplayName("Testing one box solution")
    public class OneBox {

        @BeforeEach
        void initSolution() {
            solution = new OneBoxSolution();
        }

        @Test
        @DisplayName("No box has balls with weight of 11 grams")
        void getBoxNoBox() throws Exception {
            solution.addBoxes(boxes);
            assertTrue(solution.getBoxesWithMoreWeight().isEmpty());
        }

        @RepeatedTest(4)
        @DisplayName("Random tests")
        void getBoxRandom() throws Exception {
            Random random = new Random();
            int index = random.nextInt(10);

            boxes[index].setBallWeight(BALL_WEIGHT.ELEVEN);
            solution.addBoxes(boxes);

            int boxNumber = solution.getBoxesWithMoreWeight().get(0);
            System.out.printf("Try with box number: %d, The result is: %d\n", index+1, boxNumber);
            assertEquals(index+1, boxNumber);
        }
    }

    @Nested
    @DisplayName("Testing more boxes solution")
    public class MoreBoxes {

        @BeforeEach
        void initSolution() {
            solution = new MoreBoxesSolution();
        }

        @Test
        @DisplayName("No box has balls with weight of 11 grams")
        void getBoxesNoBox() throws Exception {
            solution.addBoxes(boxes);
            assertTrue(solution.getBoxesWithMoreWeight().isEmpty());
        }

        @RepeatedTest(4)
        @DisplayName("Random tests")
        void getBoxesRandom() throws Exception {

            Random random = new Random();
            int times = random.nextInt(9) + 1;

            List<Integer> expected = new ArrayList<>();
            for(int i = 0; i < times; i++) {
                int index = random.nextInt(10);
                boxes[index].setBallWeight(BALL_WEIGHT.ELEVEN);

                expected.add(index+1);
            }

            solution.addBoxes(boxes);

            List<Integer> actual = solution.getBoxesWithMoreWeight();

            System.out.println("The expected numbers: " + expected.toString());
            System.out.println("The actual numbers: " + actual.toString());
            //Check if both lists has identical members
            assertAll(
                    () -> assertTrue(expected.containsAll(actual)),
                    () -> assertTrue(actual.containsAll(expected))
            );
        }
    }

    @Nested
    @DisplayName("Testing exceptions")
    public class Errors {
        private OneBoxSolution oneBoxSolution;
        private MoreBoxesSolution moreBoxesSolution;

        @RepeatedTest(3)
        @DisplayName("Less boxes")
        void errorLess() throws Exception {
            Random random = new Random();
            int size = random.nextInt(9) + 1;

            boxes = new Box[size];
            for(int i = 0; i < size; i++) {
                boxes[i] = new Box();
            }

            System.out.printf("If you try to insert %d boxes you will get exception\n", size);
            assertThrows(Exception.class, () -> oneBoxSolution.addBoxes(boxes));
            assertThrows(Exception.class, () -> moreBoxesSolution.addBoxes(boxes));
        }

        @Test
        @DisplayName("No boxes included")
        void errorNoBoxesInit() {
            System.out.println("If you try to get which box weights more without passing the boxes you will get exception");
            assertThrows(Exception.class, () -> oneBoxSolution.getBoxesWithMoreWeight());
            assertThrows(Exception.class, () -> moreBoxesSolution.getBoxesWithMoreWeight());
        }
    }
}