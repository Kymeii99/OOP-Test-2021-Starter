package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

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
            println(n);
        }
    }

	public void loadScore()
	{
		for (int i = 0; i <= score.length(); i++)
		{
			note[i] = score.charAt(i);
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

	public void draw()
	{
		background(255);
		drawLines();
		
	}

	void drawNotes()
	{
	}
}
