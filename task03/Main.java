public class Main {
    public static void main(String[] args) {
        ShippingOrder order1 = new ShippingOrder("ORD-5001", "742 Evergreen Terrace", 1.5, 120.0);
        ShippingOrder order2 = new ShippingOrder("ORD-5002", "221B Baker Street", 14.0, 450.0);
        ShippingOrder order3 = new ShippingOrder("ORD-5003", "350 Fifth Avenue", 4.2, 25.0);

        ShippingFacade shipping = new ShippingFacade(new StandardGroundStrategy());
        shipping.dispatchOrder(order1);

        shipping.setShippingStrategy(new ExpressAirStrategy());
        shipping.dispatchOrder(order2);

        shipping.setShippingStrategy(new SameDayCourierStrategy());
        shipping.dispatchOrder(order3);
    }
}