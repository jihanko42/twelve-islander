public class RiddleRunner {
    public static void main(String[] args) {
        int designated = Integer.parseInt(args[0]);
        TwelveIslander twelveIslander = new TwelveIslander(designated);
        twelveIslander.runRiddle();
    }
}