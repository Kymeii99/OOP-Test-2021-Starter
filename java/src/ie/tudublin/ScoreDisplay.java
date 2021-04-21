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
		String which;
        for(Note n: note)
        {
			if(n.getDuration() == 2)
			{
				which = "Crotchet";
			}
			else
			{
				which = "Quaver";
			}
            println(n.getNote()+ " " + n.getDuration()+" " + which);
        }
    }

	public void loadScore()
	{	
	
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
		textAlign(CENTER,CENTER);
		for ( int i = 0; i < score.length();i++)
		{
			float x = map(i, -3, 0, border, height - border - 40);
			fill(0);
			text(score.substring(i, i+1),x, border);
		}
	}

	public void draw()
	{
		background(255);
		drawLines();
		drawScore();
		
	}

	void drawNotes(){

	}
}
