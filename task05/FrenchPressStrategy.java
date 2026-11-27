public class FrenchPressStrategy implements BrewingStrategy {
    @Override
    public BrewParameters getBrewParameters() {
        return new BrewParameters("Coarse", 92, 240);
    }

    @Override
    public String getMethodName() {
        return "French Press Immersion";
    }
}