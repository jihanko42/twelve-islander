public class TwelveIslander {
    private int[] islanders;
    private Seesaw seesaw;
    private TwelveIslanderSolver solver;

    public TwelveIslander(int oddWeightPos) {
        setup(oddWeightPos);
        solver = new TwelveIslanderSolver(seesaw, islanders);
    }

    public void runRiddle() {
        solver.solve();
        return;
    }

    private void setup(int oddWeightPos) {
        System.out.println("\n////////////////////////////");
        System.out.println("    SETTING UP PARAMETERS   ");
        System.out.println("////////////////////////////\n");
        System.out.println("Setting up seesaw");
        this.seesaw = new Seesaw();
        System.out.printf("Seesaw Atempts: %d \n", this.seesaw.getAttempts());
        setupIslanders(oddWeightPos);
        System.out.printf("Islanders setup with odd one at position %d \n", oddWeightPos);
    }

    private void setupIslanders(int oddWeightPos) {
        islanders = new int[13];
        int randomWeight = (int) (Math.random() * 5) + 5;
        for (int i = 1; i < islanders.length; i++) {
            if (i == oddWeightPos) {
                islanders[i] = heavierOrLighter(randomWeight);
            } else {
                islanders[i] = randomWeight;
            }
        }
    }

    // Returns a randomly heavier or lighter weight
    //      for the odd weighted islander
    private int heavierOrLighter(int commonWeight) {
        double random = Math.random();
        if (random <= 0.5) {
            return commonWeight + 1;
        }
        return commonWeight - 1;
    }

}