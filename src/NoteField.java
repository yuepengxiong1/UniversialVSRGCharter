/*
 * This will define the notefield when you initialize a chart. It will populate the scrollpane with notes depending
 * on what game it is. 
 */

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NoteField {
    protected List<Object[]> notes;
    private String pathToFile;
    private int noteLengthInMS;



    public NoteField(String filePath) {
        pathToFile = filePath;
    }
    public NoteField(List<Object[]> notes) {
        this.notes = notes;
    }

}

class Note {
    float columnPosition; 
    int typeOfNote;
    int locationOfNoteInMS;
    int endOfNoteInMs; //for long notes

}

class OSUManiaNoteReader extends NoteField {
    public OSUManiaNoteReader(List<Object[]> notesList) {
        super(notesList);
        
    }

    public void osuProcessNotes() {
        // Implementation for processing notes
    }
}
