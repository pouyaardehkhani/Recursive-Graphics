import edu.princeton.cs.introcs.StdDraw;
import java.math.*;
import java.util.*;

/**
 * @author ardehkhani-mokhtari rad
 * @version 2.0
 * @since 1.0
 * <p>
 * this class create a recursive graphic image that displays on the screen.
 * </p>
 * <p>
 * we use the StdDraw class in edu.princeton library.
 * this library provides a standard drawing class that uses java swing.
 * </p>
 * <p>
 * edu.princeton library developed by university of Princeton and provided by com.googlecode.
 * </p>
 */
public class Sierpinski_carpet {

    /**
     * initializing Random for random colors.
     */
    public static Random rand=new Random();
    /**
     * we use this for creating a random RGB color.
     */
    public static final int RED=rand.nextInt(256);
    /**
     * we use this for creating a random RGB color.
     */
    public static final int GREEN=rand.nextInt(256);
    /**
     * we use this for creating a random RGB color.
     */
    public static final int BLUE=rand.nextInt(256);

    /**
     * this is our main recursive method for creating squares.Plot an order n tree of overlapping gray squares.
     * <p>
     * color for the inner squares choose at random.
     * </p>
     * <p>
     * the ratio is 1/3.
     * </p>
     * <p>
     * we use x,y for the other squares coordinates.
     * </p>
     * <p>
     * we use 8 recursion line for creating squares in different locations.
     * </p>
     * @param n order of the recursion
     * @param x coordinates of the x-axis of the center of the first square. we use it later for determine the dimensions of the smaller squares.
     * @param y coordinates of the y-axis of the center of the first square. we use it later for determine the dimensions of the smaller squares.
     * @param size size of the side length of the squares
     */
    public static void recursion(int n,double x,double y,double size){
        //creating a random color for the inner squares
        StdDraw.setPenColor(RED,GREEN,BLUE);

        //coordinates of the north square
        double xnorth=x;
        double ynorth=y+size;
        //coordinates of the north-west square
        double xn_west=xnorth-size;
        //coordinates of the north-east square
        double xn_east=xnorth+size;
        //coordinates of the west square
        double xwest=x-size;
        //coordinates of the east square
        double xeast=x+size;
        //coordinates of the south square
        double xsouth=x;
        double ysouth=y-size;
        //coordinates of the south-west square
        double xs_west=xsouth-size;
        //coordinates of the south-east square
        double xs_east=xsouth+size;

        if (n==0) return;
        StdDraw.filledSquare(x,y,size/2.0);

        //recursion for creating the squares
        recursion(n-1,x,ynorth,size/3.0);          // north square
        recursion(n-1,xn_west,ynorth,size/3.0);    // north-west square
        recursion(n-1,xn_east,ynorth,size/3.0);    // north-east square
        recursion(n-1,xwest,y,size/3.0);           // west square
        recursion(n-1,xeast,y,size/3.0);           // east square
        recursion(n-1,x,ysouth,size/3.0);          // south square
        recursion(n-1,xs_west,ysouth,size/3.0);    // south-west square
        recursion(n-1,xs_east,ysouth,size/3.0);    // south-east square
    }
    /**
     * This is the main method.
     * <p>
     * change the int n number to plot an order n recursive Sierpinski-carpet pattern. right now is 6 but 5 is also great.
     * </p>
     * <p>
     * because our scale of the table is a 0 to 3 at the x,y axis the center will be (1.5,1.5).
     * </p>
     * <p>
     * size length decided by the algorithm to see which size is needed.
     * </p>
     * <p>
     * to change the screen resolution change the CanvasSize by using StdDraw.setCanvasSize(width,height);.
     * </p>
     * <p>
     * we create a full scale square first for the color(the color is randomly by the RGB system)
     * </p>
     * @param args Unused.
     */
    public static void main(String[] args) {
        //setting the image pixels
        StdDraw.setCanvasSize(812,720);
        StdDraw.setScale(0.0,3.0);
        //order of the recursion - but n=5 is also great
        int n = 6;
        //background color
        StdDraw.setPenColor(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
        //a filled square for color
        StdDraw.filledSquare(1.5,1.5,1.5);

        double x = 1.5, y = 1.5;   // center of square
        double size = 1;           // side length of square

        recursion(n,x,y,size);
    }
}
