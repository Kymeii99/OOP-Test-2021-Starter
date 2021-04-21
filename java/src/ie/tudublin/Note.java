package ie.tudublin;

import processing.data.TableRow;

public class Note {
    private char note;
    private int duration;
    

    //Get and Setters
    public char getNote() {
        return note;
    }

    public void setNote(char note) {
        this.note = note;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    //To String
    @Override
    public String toString() {
        return "Note [duration=" + duration + ", note=" + note + "]";
    }

    //Constructer
    public Note(char note, int duration) {
        this.note = note;
        this.duration = duration;
    }

    public Note(int i) {
    }
}
