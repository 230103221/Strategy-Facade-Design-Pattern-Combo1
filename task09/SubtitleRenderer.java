public class SubtitleRenderer {
    public void enableSubtitles(String streamUrl) {
        System.out.println("  [SubtitleRenderer] Loaded WebVTT closed captions track.");
    }

    public void resyncOverlay(String resolution) {
        System.out.println("  [SubtitleRenderer] Scaled subtitle font metrics for " + resolution + " viewport.");
    }
}