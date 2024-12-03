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
    protected List<Object> storeEntireNote;
    private String pathToFile;
    private int noteLengthInMS;
    protected int keyCount = 0;



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

    public float getColumnPosition() {
        return columnPosition;
    }

    public int getTypeOfNote() {
        return typeOfNote;
    }

    public int getLocationOfNoteInMS() {
        return locationOfNoteInMS;
    }

    public int getEndOfNoteInMs() {
        return endOfNoteInMs;
    }

}

class OSUManiaNoteReader extends NoteField {
    public OSUManiaNoteReader(List<Object[]> notesList, int keycount) {
        super(notesList);
        this.keyCount = keycount;
        
    }
        /*  From osu documentation: https://osu.ppy.sh/wiki/en/Client/File_formats/osu_(file_format)#hit-objects

            Hit object syntax: x,y,time,type,hitSound,endTime:hitSample
            x (Integer) and y (Integer): Position in osu! pixels of the object.
            time (Integer): Time when the object is to be hit, in milliseconds from the beginning of the beatmap's audio.
            type (Integer): Bit flags indicating the type of the object. See the type section.
            hitSound (Integer): Bit flags indicating the hitsound applied to the object. See the hitsound section.
            objectParams (Comma-separated list): Extra parameters specific to the object's type.
            hitSample (Colon-separated list): Information about which samples are played when the object is hit. It is closely related to hitSound; see the hitsounds section. If it is not written, it defaults to 0:0:0:0:.
         */
    public void osuProcessNotes() {

        for (Object[] noteLine : notes) {
            String line = noteLine[0].toString();
            line = line.split(":")[0]; // Remove the part after the first colon
            String[] noteParts = line.split(","); // Split by comma
            for (String part : noteParts) {
                System.out.println(part);
            }

           Note note = parseNoteFromLine(noteParts);
          // storeEntireNote.add(new Object[]{note.getColumnPosition(), note.getTypeOfNote(), note.getLocationOfNoteInMS(), note.getEndOfNoteInMs()});
        }

        if (!notes.isEmpty()) {
            Object[] firstNote = notes.get(0);
            System.out.println("First element of the first note: " + firstNote[0]);
        }
    }

    private Note parseNoteFromLine(Object[] noteLine) {
        Note note = new Note();
        note.columnPosition = (float) Math.floor(Float.parseFloat(noteLine[0].toString()) * keyCount / 512); //output what column the note is in
        System.out.println("Colomn pos: " + note.columnPosition);
        note.locationOfNoteInMS = Integer.parseInt(noteLine[2].toString()); //output the time where the note is placed in ms
        note.typeOfNote = Integer.parseInt(noteLine[3].toString()); //outputs the type of note. 192 is long note

        if (note.typeOfNote == 192){
            note.endOfNoteInMs = Integer.parseInt(noteLine[5].toString()); //outputs the end of longnote in ms
        }
        
        return note;
    }
}
