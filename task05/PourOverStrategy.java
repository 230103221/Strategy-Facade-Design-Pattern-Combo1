public class PourOverStrategy implements BrewingStrategy {
    @Override
    public BrewParameters getBrewParameters() {
        return new BrewParameters("Medium-Fine", 96, 180);
    }

    @Override
    public String getMethodName() {
        return "Pour-Over (V60 Drip)";
    }
}