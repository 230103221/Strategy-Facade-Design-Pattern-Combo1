public class Main {
    public static void main(String[] args) {
        HomeLightingFacade smartHome = new HomeLightingFacade(new EcoDimStrategy());
        smartHome.applyScene("LivingRoom");

        smartHome.setLightingStrategy(new ReadingFocusStrategy());
        smartHome.applyScene("StudyRoom");

        smartHome.setLightingStrategy(new AmbientPartyStrategy());
        smartHome.applyScene("LivingRoom");
    }
}