public class Main {
    public static void main(String[] args) {
        NavigationFacade nav = new NavigationFacade(new FastestTimeRouting());
        nav.startNavigation("Downtown Tech Park", "International Airport");

        nav.updateWaypoint("Midtown Junction");
        nav.switchRoutingStrategy(new AvoidTollsRouting());

        nav.updateWaypoint("Westside Bridge");
        nav.switchRoutingStrategy(new ShortestDistanceRouting());
    }
}