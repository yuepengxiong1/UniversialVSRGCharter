/*
 * This class is an extension for the superclass SongChart. This class is specific for handling osu!mania format songs.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OSUManiaMetadata extends ChartMetadata{

    //osu format meta data divided into same sections:

    //General
    private final List<Object[]> generalMetadata = new ArrayList<>();

    //Editor
    private final List<Object[]> editorMetadata = new ArrayList<>();

    //Metadata
    private final List<Object[]> metaData = new ArrayList<>();

    //Difficulty
    private final List<Object[]> difficultyMetadata = new ArrayList<>();

    // Events
    private String[] backgroundEvents = new String[5];
    {
        //this just sets the bg image
        backgroundEvents[0] = "0"; 
        backgroundEvents[1] = "0"; 
        backgroundEvents[2] = "0"; //filename
        backgroundEvents[3] = "0"; //x offset
        backgroundEvents[4] = "0"; // y offset
    }

    //this is for parsing what kind of data type is being encountered
    private Object parseValue(String value, Object defaultValue) {
        if (defaultValue instanceof Integer) {
            return Integer.parseInt(value);
        } else if (defaultValue instanceof Double) {
            return Double.parseDouble(value);
        } else if (defaultValue instanceof Float) {
            return Float.parseFloat(value);
        } else if (defaultValue instanceof Boolean) {
            return Boolean.parseBoolean(value);
        } else {
            return value;
        }
    }      
    
    //this is used when you create a chart   
    public OSUManiaMetadata(String songName, String artist, String creatorOfChart, String pathToChartDirectory, float BPM, int setSongOffset, String[] difficultyList, String[] arrayContainingCharts) {
        super(songName, artist, creatorOfChart, pathToChartDirectory, BPM, setSongOffset, difficultyList, arrayContainingCharts);
    }

    //this is used when you read a chart. BufferReader for passed in file. Accessed by Open menu.
    public OSUManiaMetadata(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; //saves current line of the reader

            //while the current line is not null, do...
            while ((line = br.readLine()) != null) {

                //to skip empty lines
                if (line.trim().isEmpty()) {
                    continue; 
                }

                //System.out.println("Current line is: " + line); // Print each line

                //this handles what section we are in inside the .osu file.
                //if we encounter [General], the next lines are associated with that section
                //and we store to a arraylist in order of apperace
                if (line.startsWith("[General]")) {
                    processSection(br, line, generalMetadata);
                } else if (line.startsWith("[Editor]")) {
                    processSection(br, line, editorMetadata);
                } else if (line.startsWith("[Metadata]")) {
                    processSection(br, line, metaData);
                } else if (line.startsWith("[Difficulty]")) {
                    processSection(br, line, difficultyMetadata);
                } else if (line.startsWith("[HitObjects]")) {
                    break; // Stop processing if we encounter [HitObjects]
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }
        
    // we pass in the reader, the line we are currently on, and the arraylist that we are on.
    // we are passing by reference so we are directly changing it.
    private void processSection(BufferedReader br, String line, List<Object[]> metadata) throws IOException {
        
        //if the line starts with [ , we skip. the next line is guranteed to be the stuff we want.
        //we keep going until we reach an empty line. 
        while (!(line = br.readLine()).startsWith("[") && !line.startsWith("[HitObjects]")) {
            
            //this breaks out of loop when we get an empty line. reader will skip [Editor] because it has read that line
            //and whenever we use .readLine(), it will iterate by 1 line. So to prevent it from skipping [Editor], we exit loop
            if (line.trim().isEmpty()) {
                break;
            }

            //Holds an array of 2 elements. Splits by :
            String[] parts = line.split(":", 2);

            //and if we get 2, we set them based on variable and value
            if (parts.length == 2) {
                String variable = parts[0].trim();
                String value = parts[1].trim();
                metadata.add(new Object[]{variable, parseValue(value, "")});
            }
        }  
    }

    //Just returns the metadata in the format of the .osu file.
    public void returnMetadataOsu(){
        System.out.println("[General]");
        for (Object[] meta : generalMetadata) {
            System.out.println(meta[0] + ": " + meta[1]);
        }
        
        System.out.println("\n[Editor]");
        for (Object[] meta : editorMetadata) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\n[Metadata]");
        for (Object[] meta : metaData) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\n[Difficulty]");
        for (Object[] meta : difficultyMetadata) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\nBackground Events:");
        System.out.println(String.join(", ", backgroundEvents));
    }

    
}

