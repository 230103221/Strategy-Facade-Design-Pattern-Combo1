public class RoomSensor {
    public int readAmbientLightLux(String roomId) {
        return roomId.equalsIgnoreCase("LivingRoom") ? 120 : 300;
    }

    public boolean isRoomOccupied(String roomId) {
        return true;
    }
}