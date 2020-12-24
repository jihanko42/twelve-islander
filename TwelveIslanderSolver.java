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
        firstEvaluation();
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

    private boolean firstEvaluation() {
        System.out.println("***First Evaluation***");
        return false;
    }
}
