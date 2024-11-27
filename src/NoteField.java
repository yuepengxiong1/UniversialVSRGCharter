/*
 * This will define the notefield when you initialize a chart. It will populate the scrollpane with notes depending
 * on what game it is. 
 */

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoteField {
    protected List<String> notes;
    private String pathToFile;
    private int locationOfNoteInMS;

    public NoteField(String filePath) {
        pathToFile = filePath;
    }

}

class OSUManiaNoteReader extends NoteField{
    public OSUManiaNoteReader(String filePath) {
        super(filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean hitObjectsSection = false;

            while ((line = br.readLine()) != null) {
                if (line.trim().equals("[HitObjects]")) {
                    hitObjectsSection = true;
                    continue;
                }

                if (hitObjectsSection) {
                    notes.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String note : notes) {
            System.out.println(note);
        }

    }

    public void osuProcessNotes(){

    }

    
}
