/*
 * This will define the notefield when you initialize a chart. It will populate the scrollpane with notes depending
 * on what game it is. 
 */

import java.util.List;

public class NoteField {
    private List<String> notes;
    private String pathToFile;
    private int locationOfNoteInMS;

    public NoteField(String filePath) {
        
    }

}

class OSUManiaNoteReader extends NoteField{
    public OSUManiaNoteReader(String filePath) {
        super(filePath);
    }
}
