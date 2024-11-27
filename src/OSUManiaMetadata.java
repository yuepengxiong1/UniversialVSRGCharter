/*
 * This class is an extension for the superclass SongChart. This class is specific for handling osu!mania format songs.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OSUManiaMetadata extends ChartMetadata{

    //osu format meta data divided into same sections:

    //General
    private final Object[][] generalMetadata = new Object[0][0];

    //Editor
    private final Object[][] editorMetadata = new Object[0][0];

    private final Object[][] metaData = new Object[0][0];

    private final Object[][] difficultyMetadata = new Object[0][0];

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

    //this is used when you read a chart
    public OSUManiaMetadata(String filePath){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Print each line
                // Process each line of the file
                if (line.startsWith("[HitObjects]")) {
                    break; // Stop processing if we encounter [HitObjects]
                } else if (line.startsWith("[General]")) {
                    processSection(br, line, generalMetadata);
                } else if (line.startsWith("[Editor]")) {
                    processSection(br, line, editorMetadata);
                } else if (line.startsWith("[Metadata]")) {
                    processSection(br, line, metaData);
                } else if (line.startsWith("[Difficulty]")) {
                    processSection(br, line, difficultyMetadata);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void processSection(BufferedReader br, String line, Object[][] metadata) throws IOException {
            //we want to stop before this section. we only want to get data from the file and notes are handled 
            //somewhere else
            while (!(line = br.readLine()).startsWith("[") && !line.startsWith("[HitObjects]")) {
                //System.out.println(line); // Print each line
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    String variable = parts[0].trim(); //left side of :
                    String value = parts[1].trim(); //right side of :

                    for (int i = 0; i < metadata.length; i++) {
                        if (variable.equals(metadata[i][0])) {
                            metadata[i][1] = parseValue(value, metadata[i][1]);
                            if (containsJapaneseCharacters((String) metadata[i][1])) {
                                System.out.println("Japanese characters found in: " + metadata[i][0]);
                            }
                        }
                    }
                }
            }
            // Print the metadata array
            for (Object[] meta : metadata) {
                System.out.println(meta[0] + ": " + meta[1]);
            }
        }

        private boolean containsJapaneseCharacters(String text) {
        for (char c : text.toCharArray()) {
            if (isJapaneseCharacter(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean isJapaneseCharacter(char c) {
        return (c >= '\u3040' && c <= '\u309F') || // Hiragana
               (c >= '\u30A0' && c <= '\u30FF') || // Katakana
               (c >= '\u4E00' && c <= '\u9FFF');   // Kanji (CJK Unified Ideographs)
    }

    public void returnMetadataOsu(){
        System.out.println("General Metadata:");
        for (Object[] meta : generalMetadata) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\nEditor Metadata:");
        for (Object[] meta : editorMetadata) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\nMetadata:");
        for (Object[] meta : metaData) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\nDifficulty Metadata:");
        for (Object[] meta : difficultyMetadata) {
            System.out.println(meta[0] + ": " + meta[1]);
        }

        System.out.println("\nBackground Events:");
        for (String event : backgroundEvents) {
            System.out.println(event);
        }
    }

    
}

