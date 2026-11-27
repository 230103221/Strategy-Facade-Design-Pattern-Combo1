public class Main {
    public static void main(String[] args) {
        BaristaFacade coffeeStation = new BaristaFacade(new EspressoPullStrategy());
        coffeeStation.prepareBeverage("Italian Dark Roast");

        coffeeStation.setBrewingStrategy(new PourOverStrategy());
        coffeeStation.prepareBeverage("Ethiopian Yirgacheffe");

        coffeeStation.setBrewingStrategy(new FrenchPressStrategy());
        coffeeStation.prepareBeverage("Colombian Supremo");
    }
}