package TwelveIslanderRiddle;

public class Seesaw {
    private int attempts;

    public Seesaw() {
        this.attempts = 3;
    }

    public int getAttempts() {
        return this.attempts;
    }

    // Returns positive if A is heavier,
    //         negative if B is heavier,
    //         0 if A and B weigh the same
    public int weigh(int[] groupA, int[] groupB) {
        System.out.println("\nWeighing Islanders");
        this.attempts--;
        return sumIslander(groupA) - sumIslander(groupB);
    }

    private int sumIslander(int[] group) {
        int groupSum = 0;
        for (int islander : group) {
            groupSum += islander;
        }
        return groupSum;
    }
}
