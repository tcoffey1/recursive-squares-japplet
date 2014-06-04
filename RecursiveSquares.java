/*
 * Tadhg Coffey
 * 2/28/14
 * RecursiveSquares.java
 * Java 111C -  Lab C
*/

package chapter07_recursion;

import javax.swing.*;
import java.awt.*;

public class RecursiveSquares extends JApplet {

	//instance data
	final int ORIG_SIDE_LENGTH = 200;   	//original size of square
	final int MIN_SIDE_LENGTH = 30;	
	double shrinkFactor = 0.5;					

/**********************************init()************************************/	
	//set up applet
	public void init() 
	{
		setSize(400,400);  //size of applet window
	}//end init
	
/**********************************paint()************************************/	
	// use the page object to draw on the coordinate space
	public void paint(Graphics page) 
	{
		int width = 200; 		//initial size of the largest square
		int height = 200;		//initial size of the largest square
		int x_coorOrig = 100;	//coordinates of original square
		int y_coorOrig = 100;
		recursivePaint(page, x_coorOrig, y_coorOrig, width, height);  //send in coordinates of first square to be drawn
		
	}//end paint

/**********************************recursivePaint()************************************/		
	private void recursivePaint(Graphics page, int x_coor, int y_coor, int width, int height) 
	{
		
		setForeground(Color.black);
		
		page.setColor(Color.blue);   
		page.fillRect(x_coor, y_coor, width, height); // draw solid square

		page.setColor(Color.black);  //draws the outline of square
		page.drawRect(x_coor, y_coor, width	, height); 
		
		//start drawing smaller squares
		if (width> MIN_SIDE_LENGTH)  //base for total
		{	

			width = (int)(width * shrinkFactor); 					
			height = (int)(height * shrinkFactor);

			recursivePaint(page, x_coor -(width/2), y_coor-(height/2), width, height);  //top left
					
			recursivePaint(page, x_coor + 2*width - (width/2), y_coor-(height/2), width, height);   //top right	
			
			recursivePaint(page, x_coor + 2*width - (width/2), y_coor + 2*height - (height/2), width, height);   //bottom right
					
			recursivePaint(page, x_coor -(width/2), y_coor + 2*height - (height/2), width, height);   //bottom left

		}
		
	}
	
}//end class
