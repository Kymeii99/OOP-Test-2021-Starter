package ie.tudublin;

import java.util.ArrayList;

import javax.swing.border.Border;

import processing.core.PApplet;


public class ScoreDisplay extends PApplet
{
	ArrayList<Note> note = new ArrayList<Note>();
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";

	int size = score.length();
	float border;
	float borderHeight;
	public void printScore()
    {
        for(Note n: note)
        {
			//If Statement to check the if its a Crotchet or Quaver
			if(n.getDuration() == 2)
			{
				println(n.getNote()+ " " + n.getDuration()+" " + "Crotchet");
			}
			else
			{
				println(n.getNote()+ " " + n.getDuration()+" " + " Quaver");
			}
        }
    }

	public void loadScore()
	{	
		for ( int i = 0 ; i < size ; i++)
		{
			char cNote = score.charAt(i);
			int currDur;

			if(Character.isLetter(cNote))
			{
				if(i < size - 1 && Character.isDigit(score.charAt(i+1)))
				{
					currDur = 2;
				}
				else
				{
					currDur = 1;
				}
				Note n = new Note(cNote,currDur);
				note.add(n);
			}
		}
		
	}

	public void settings()
	{
		size(1000, 500);
		border = width * 0.1f;
		borderHeight = height * 0.1f;
		// How to convert a character to a number
		char c = '7'; // c holds the character 7 (55)
		int i = c - '0'; // i holds the number 7 (55 - 48) 
		println(i);
	}

	public void setup() 
	{

		loadScore();
		printScore();
	}

	public void drawLines()
	{
		for ( int i = 0; i < 5 ; i++)
		{
			float x = map(i, -5, 5, border, height - border - 40);
			stroke(0);
			line(border, x, width - border, x);
		}
	}

	public void draw()
	{
		background(255);
		fill(0);
		drawLines();
		drawNotes();
	}

	void drawNotes(){
		for ( int i = 0 ; i < note.size(); i++)
		{
			Note n = note.get(i);
			int note1,note2;
			char music = n.getNote();

			note1 = 'D';
			note2 = 'a';

			if (note1 > music)
			{
				music += 7;
			}
			else if(note2 < music)
			{
				music -=25;
			}
			float x = map(i, 0,note.size()-1, border + 10, width - border - 10);
			float y = map(music, note1 - 4, note2 - 25, height/2 + borderHeight, height/2 - borderHeight );
			ellipse(x, y + ((height/2) * 0.38f), 25, 25);
			text(n.getNote(), x , 100);
			line(x + 10, y + ((height/2) * 0.38f) , x + 10, y + ((height/2) * 0.38f)  - 40);
		}
	}
}
