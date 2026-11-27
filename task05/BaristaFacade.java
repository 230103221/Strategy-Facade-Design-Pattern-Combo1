public class BaristaFacade {
    private final BeanGrinder grinder;
    private final WaterBoiler boiler;
    private final BrewChamber chamber;
    private BrewingStrategy activeStrategy;

    public BaristaFacade(BrewingStrategy initialStrategy) {
        this.grinder = new BeanGrinder();
        this.boiler = new WaterBoiler();
        this.chamber = new BrewChamber();
        this.activeStrategy = initialStrategy;
    }

    public void setBrewingStrategy(BrewingStrategy strategy) {
        this.activeStrategy = strategy;
        System.out.println("\n[Facade] Switched brewing method to: " + strategy.getMethodName());
    }

    public void prepareBeverage(String beanType) {
        System.out.println("[Facade] Preparing '" + beanType + "' using " + activeStrategy.getMethodName());

        BrewParameters params = activeStrategy.getBrewParameters();
        grinder.grindBeans(beanType, params.getGrindSize());
        boiler.heatWater(params.getWaterTempCelsius());
        chamber.brew(activeStrategy.getMethodName(), params.getExtractionSeconds());

        System.out.println("[Facade] Beverage ready! Enjoy your " + beanType + " (" + activeStrategy.getMethodName() + ").");
    }
}