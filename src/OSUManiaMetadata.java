/*
 * This class is an extension for the superclass SongChart. This class is specific for handling osu!mania format songs.
 */


public class OSUManiaMetadata extends ChartMetadata{
    private int numberofKeys;
    private String hpDrain;
    private final int mode = 3; //mode 3 is mania and that is what we only care about
    private String bgFile;
    
    
    public OSUManiaMetadata(String songName, String artist, String creatorOfChart, String pathToChartDirectory, float BPM, int setSongOffset, String[] difficultyList, String[] arrayContainingCharts) {
        super(songName, artist, creatorOfChart, pathToChartDirectory, BPM, setSongOffset, difficultyList, arrayContainingCharts);
        
    }
    
}

