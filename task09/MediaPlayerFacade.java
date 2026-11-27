public class MediaPlayerFacade {
    private final BufferMonitor bufferMonitor;
    private final VideoDecoder videoDecoder;
    private final AudioSyncEngine audioSyncEngine;
    private final SubtitleRenderer subtitleRenderer;
    private BitrateStrategy activeStrategy;
    private String currentStreamUrl;
    private boolean isPlaying;

    public MediaPlayerFacade(BitrateStrategy initialStrategy) {
        this.bufferMonitor = new BufferMonitor();
        this.videoDecoder = new VideoDecoder();
        this.audioSyncEngine = new AudioSyncEngine();
        this.subtitleRenderer = new SubtitleRenderer();
        this.activeStrategy = initialStrategy;
        this.isPlaying = false;
    }

    public void playStream(String streamUrl) {
        this.currentStreamUrl = streamUrl;
        System.out.println("[Facade] Starting playback for '" + streamUrl + "' using " + activeStrategy.getModeName());

        double bandwidth = bufferMonitor.measureBandwidthMbps();
        String targetRes = activeStrategy.determineResolution(bandwidth);

        bufferMonitor.allocateJitterBuffer(targetRes);
        videoDecoder.initializeStream(streamUrl, targetRes);
        audioSyncEngine.startAudioTrack(streamUrl);
        subtitleRenderer.enableSubtitles(streamUrl);

        this.isPlaying = true;
        System.out.println("[Facade] Stream is now playing smoothly at " + targetRes + ".");
    }

    public void changeQualityMode(BitrateStrategy newStrategy) {
        this.activeStrategy = newStrategy;
        System.out.println("\n[Facade] Changing quality mode to: " + newStrategy.getModeName());

        if (!isPlaying || currentStreamUrl == null) {
            System.out.println("[Facade] Strategy updated for next playback session.");
            return;
        }

        double bandwidth = bufferMonitor.measureBandwidthMbps();
        String newResolution = activeStrategy.determineResolution(bandwidth);
        long currentPts = audioSyncEngine.getMasterClockMs();

        bufferMonitor.allocateJitterBuffer(newResolution);
        videoDecoder.switchTrackSeamless(newResolution, currentPts);
        audioSyncEngine.verifyLipSync(currentPts);
        subtitleRenderer.resyncOverlay(newResolution);

        System.out.println("[Facade] Quality switched to " + newResolution + " without playback interruption.");
    }
}