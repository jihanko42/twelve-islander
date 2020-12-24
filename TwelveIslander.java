package TwelveIslanderRiddle;

public class TwelveIslander {
    private int[] islanders;
    private Seesaw seesaw;

    public TwelveIslander(int oddWeightPos) {
        setup(oddWeightPos);
    }

    public void runRiddle() {
        return;
    }

    private void setup(int oddWeightPos) {
        System.out.println("////////////////////////////");
        System.out.println("    SETTING UP PARAMETERS   ");
        System.out.println("////////////////////////////");
        System.out.println("\n Setting up seesaw");
        this.seesaw = new Seesaw();
        System.out.printf("Seesaw Atempts: %d \n", this.seesaw.getAttempts());
        setupIslanders(oddWeightPos);
        System.out.printf("Islanders setup with odd one at position %d \n", oddWeightPos);
    }

    private void setupIslanders(int oddWeightPos) {
        for (int i = 1; i < islanders.length; i++) {
            if (i == oddWeightPos) {
                islanders[i] = heavierOrLighter();
            } else {
                islanders[i] = 10;
            }
        }
    }

    // Returns a randomly heavier or lighter weight
    //      for the odd weighted islander
    private int heavierOrLighter() {
        double random = Math.random();
        if (random <= 0.5) {
            return 8;
        }
        return 12;
    }

}