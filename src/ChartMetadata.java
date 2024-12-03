/*
 * This File is basically a universal class for any chart that contains this information. All charts have these fields in common.
 * Their subclass to this class will be its own specific class because each game defines how they handle note charting differently.
 */


public abstract class ChartMetadata {

    //Universal Information for each chart
    
    protected String songName;
    protected String artist;
    protected String creatorOfChart;
    protected String pathToChartDirectory;
    protected String backgroundImageName; 
    protected float BPM;
    protected int setSongOffset;
    protected String[] difficultyList;
    protected String[] arrayContainingCharts; //sometimes song directories hold multiple songs in the same folder. OSU does this to handle packs
    protected int songLengthMs;
    

    //Every chart will use this in the child class
    public ChartMetadata(String songName, String artist, String creatorOfChart, String pathToChartDirectory, float BPM, int setSongOffset, String[] difficultyList, String[] arrayContainingCharts) {
        this.songName = songName;
        this.artist = artist;
        this.creatorOfChart = creatorOfChart;
        this.pathToChartDirectory = pathToChartDirectory;
        this.BPM = BPM;
        this.setSongOffset = setSongOffset;
        this.difficultyList = difficultyList;
        this.arrayContainingCharts = arrayContainingCharts;
    }

    public ChartMetadata() {
        this.songName = "Unknown Song";
        this.artist = "Unknown Artist";
        this.creatorOfChart = "Unknown Creator";
        this.pathToChartDirectory = "Unknown Path";
        this.BPM = 120.0f;
        this.setSongOffset = 0;
        this.difficultyList = new String[]{"Easy", "Medium", "Hard"};
        this.arrayContainingCharts = new String[]{};
    }

    public ChartMetadata(String pathToChartDirectory){
        this.pathToChartDirectory = pathToChartDirectory;
    }

    public void setSongLengthMs(int songLengthMs){
         this.songLengthMs = songLengthMs;
    }

    public int getSongLengthMs(){
        return songLengthMs;
   }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCreatorOfChart() {
        return creatorOfChart;
    }

    public void setCreatorOfChart(String creatorOfChart) {
        this.creatorOfChart = creatorOfChart;
    }

    public String getPathToChartDirectory() {
        return pathToChartDirectory;
    }

    public void setPathToChartDirectory(String pathToChartDirectory) {
        this.pathToChartDirectory = pathToChartDirectory;
    }

    public float getBPM() {
        return BPM;
    }

    public void setBPM(float BPM) {
        this.BPM = BPM;
    }

    public int getSetSongOffset() {
        return setSongOffset;
    }

    public void setSetSongOffset(int setSongOffset) {
        this.setSongOffset = setSongOffset;
    }

    public String getBackgroundImageName() {
        return backgroundImageName;
    }

    public void setBackgorundImageName(String backgroundImageName) {
        this.backgroundImageName = backgroundImageName;
    }

    public String[] getDifficultyList() {
        return difficultyList;
    }

    public void setDifficultyList(String[] difficultyList) {
        this.difficultyList = difficultyList;
    }

    public String[] getArrayContainingCharts() {
        return arrayContainingCharts;
    }

    public void setArrayContainingCharts(String[] arrayContainingCharts) {
        this.arrayContainingCharts = arrayContainingCharts;
    }
    
}

