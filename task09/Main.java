public class Main {
    public static void main(String[] args) {
        MediaPlayerFacade player = new MediaPlayerFacade(new BalancedAutoStrategy());
        player.playStream("https://cdn.stream.example/movie_4k/master.m3u8");

        player.changeQualityMode(new DataSaverStrategy());
        player.changeQualityMode(new UltraHdStrategy());
    }
}