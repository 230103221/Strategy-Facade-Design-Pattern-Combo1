public class EspressoPullStrategy implements BrewingStrategy {
    @Override
    public BrewParameters getBrewParameters() {
        return new BrewParameters("Extra Fine", 93, 28);
    }

    @Override
    public String getMethodName() {
        return "Espresso Pull (9 Bar)";
    }
}