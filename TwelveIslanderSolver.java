import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwelveIslanderSolver {
    private Seesaw seesaw;
    private int[] islanders;
    private int[][] threeGroups;
    private String[] aliases = new String[] {
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
    };

    private static final Map<Integer, String> indexToAlias = new HashMap<>();

    public TwelveIslanderSolver(Seesaw seesaw, int[] islanders) {
        this.seesaw = seesaw;
        this.islanders = islanders;
    }

    public void solve() {
        System.out.println("\n////////////////////////////");
        System.out.println("           SOLVING          ");
        System.out.println("////////////////////////////\n");
        System.out.println("Mapping aliases to respective weights");
        divideIntoThreeGroups();
        evaluation();
    }

    // private void mapAliasesToWeights(int[] islanders) {
    //     System.out.println("Mapping aliases to respective weights");
        
    // }

    
    private void divideIntoThreeGroups() {
        System.out.println("\nDividing islanders into 3 groups of four...");
        threeGroups = new int[3][4];
        threeGroups[0] = Arrays.copyOfRange(islanders, 1, 5);
        threeGroups[1] = Arrays.copyOfRange(islanders, 5, 9);
        threeGroups[2] = Arrays.copyOfRange(islanders, 9, 13);
        threeGroupsToString();
    }
    
    private void threeGroupsToString() {
        System.out.println("Members of the three groups...");
        for (int i = 0; i < threeGroups.length; i++) {
            System.out.printf("GROUP %d:\n", i + 1);
            for (int j = 0; j < threeGroups[i].length; j++) {
                System.out.printf("         " + aliases[i * 4 + j] + "\n");
            }
        }
    }

    private int evaluation() {
        System.out.println("***First Evaluation***");
        System.out.println("\nWeighing group 1 and 2...");
        int seesawResult = this.seesaw.weigh(threeGroups[0], threeGroups[1]);
        if (seesawResult > 0) {
            System.out.println("Group 1 is heavier than Group 2!!!");
            return firstInequalityEvaluation(seesawResult);
        } else if (seesawResult < 0) {
            System.out.println("Group 1 is lighter than Group 2!!!");
            return firstInequalityEvaluation(seesawResult);
        } else {
            System.out.println("Group 1 and Group 2 weigh the same!!!");
            System.out.println("Group 3 contains the odd weighted islander!!!");
        }
        System.out.printf("\nRemaining seesaw attempts: %d", this.seesaw.getAttempts());
        return equalityEvaluation();
    }

    private int firstInequalityEvaluation(int seesawResult) {
        System.out.println("***SECOND EVALUATION***");
        System.out.println("\nWeighing Group 1 and 3...");
        int newSeesawResult = this.seesaw.weigh(threeGroups[0], threeGroups[2]);
        if (seesawResult == newSeesawResult) {
            System.out.println("Group 1 contains the odd weighted islander!!!");
        } else {
            System.out.println("Group 2 contains the odd weighted islander!!!");
        }
        return 0;
    }

    private int equalityEvaluation() {
        return 0;
    }
}
