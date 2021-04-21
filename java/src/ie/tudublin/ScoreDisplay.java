package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;


public class ScoreDisplay extends PApplet
{
	ArrayList<Note> note = new ArrayList<Note>();
	String score = "DEFGABcd";
	//String score = "D2E2F2G2A2B2c2d2";
	//String score = "DEF2F2F2EFA2A2B2AFD2E2D2D2D2";
	
	int size = score.length();

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

	public void settings()
	{
		size(1000, 500);
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
		float xborder = width * 0.15f;

		for ( int i = 0; i < 5 ; i++)
		{
			float x = map(i, -5, 5, xborder, height - xborder - 40);
			stroke(0);
			line(xborder, x, width - xborder, x);
		}
	}

	public void drawScore()
	{
		float border = width * 0.15f;
		for ( int i = 0; i < size;i++)
		{
			float x = map(i, -3, 3, border, height - border - 40);
			fill(0);
			text(score.substring(i, i+1),x, border);
		}
	}

	public void draw()
	{
		background(255);
		drawLines();
		drawScore();
		drawNotes();
		
	}

	void drawNotes(){
		float border = width * 0.15f;
		float halfHeight = height / 2;
		int position = 0;

		for ( int i = 0; i < size;i++)
		{
			//float x = map(i, -5, 5, xborder, height - xborder - 40);
			float y = map(i, 0, 2, border, height/2);
			fill(0);
			line(y + 10, halfHeight - 40,y + 10, halfHeight);
			ellipse(y, height /2  , 20, 20);
		}
	}

	void mouseHover()
	{

	}
}
