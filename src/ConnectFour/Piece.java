package ConnectFour;

import java.awt.Color;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

/* 
 Piece class that defines the graphical and actual properties of a Connect Four piece 
* Written by Josh Planko for the COMP 128 Final Project, Spring 2024
*/
public class Piece extends Ellipse {

    public static final int PIECE_RADIUS = 25;
    private double centerX;
    private double centerY;
    private Color color;
    private char player;
    
    
    public Piece (double centerX, double centerY, double width, double height, Color color, char player){
        super(centerX, centerY, PIECE_RADIUS * 2, PIECE_RADIUS *2);
        this.setCenter(centerX, centerY);
        this.setFillColor(color);
        
    }

    /**
     * Adds the GraphicsObject item to the canvas
     * @param canvas a CanvasWindow canvas
     */

    public void addToCanvas(CanvasWindow canvas){
        canvas.add(this);
    }

    /**
     * Getter Methods
     */

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public Color getColor() {
        return color;
    }

    public char getPlayer() {
        return player;
    }

    

    

}
