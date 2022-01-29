import edu.princeton.cs.introcs.StdDraw;
import java.math.*;
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
public class SierpinskiGasket {
    /**
     * This method is used to draw a filled triangle that the
     * ((x1,y1),(x2,y2),(x3,y3)) is it's points.
     * <p>
     * this method create a filled square with a light gray background and black border.
     * </p>
     * <p>
     * we initialize the new triangle with a specific color we can also change it
     * use one of these methods
     * setPenColor(int red, int green, int blue)
     * or
     * setPenColor(Color color).
     * the first method allows to create a color using RGB system.
     * the second method allows to use one of the pre-defined color in the library
     * </p>
     * <p>
     * in this method we also determine the next coordinates of the next triangle
     * </p>
     * <p>
     * we use 3 recursion lines for making our image.
     * </p>
     * @param x0 the array of the x-axis coordinates of the triangle
     * @param y0 the array of the y-axis coordinates of the triangle
     * @param order number of the recursion
     */
    public static void recursion(int order,double[] x0,double[] y0){
        //first we need to fine the center of the each line coordinates
        double[] x1={(double)(x0[0]+x0[1])/2.0,(double)(x0[0]+x0[2])/2.0,(double)(x0[1]+x0[2])/2.0};
        double[] y1={(double)(y0[0]+y0[1])/2.0,(double)(y0[0]+y0[2])/2.0,(double)(y0[1]+y0[2])/2.0};

        if (order==0) return;
        StdDraw.setPenColor(StdDraw.CYAN);

        StdDraw.filledPolygon(x1, y1);

        //setting the all needed coordinates for the recursion.
        double[] xAbove={x1[1],x1[2],x0[2]};
        double[] yAbove={y1[1],y1[2],y0[2]};
        double[] xLeft={x0[0],x1[0],x1[1]};
        double[] yLeft={y0[0],y1[0],y1[1]};
        double[] xRight={x1[0],x0[1],x1[2]};
        double[] yRight={y1[0],y0[1],y1[2]};
        // recursively draw 3 smaller squares of order n-1
        recursion(order-1,xAbove,yAbove);   // Above
        recursion(order-1,xLeft,yLeft);     // Left
        recursion(order-1,xRight,yRight);   // Right

    }
    /**
     * This is the main method.
     * <p>
     * change the int n number to plot an order n recursive pattern.
     * </p>
     * <p>
     * to change the screen resolution change the CanvasSize by using StdDraw.setCanvasSize(width,height);.
     * </p>
     * <p>
     * we set our scale by our algorithm so you cant change it.
     * </p>
     * <p>
     * we need to determine the first triangle 3 points in x,y axis.
     * </p>
     * <p>
     * we clears the screen to the specified color(gray).if you want
     * the background to be comment the StdDraw.clear(StdDraw.GRAY);
     * line or another color change the
     * StdDraw.GRAY
     * to
     * StdDraw.(available color at the library)
     * </p>
     * <p>
     * we initialize the first triangle with a specific color we can also change it
     * use one of these methods
     * setPenColor(int red, int green, int blue)
     * or
     * setPenColor(Color color).
     * the first method allows to create a color using RGB system.
     * the second method allows to use one of the pre-defined color in the library
     * </p>
     * <p>
     * you can change the order of the incursion but right now its 6 only because it looks better
     * </p>
     * @param args Unused.
     */
    public static void main(String[] args) {
        //setting the image pixels
        StdDraw.setCanvasSize(920,720);
        //setting the size of the scale
        StdDraw.setXscale(0.0,1.0);
        StdDraw.setYscale(0.0,(double) Math.sqrt(3)/2.0);
        //the first triangle
        double[] x = { 0.0, 1.0, 0.5 };
        double[] y = { 0.0, 0.0, (double) Math.sqrt(3)/2.0};
        //Clears the screen to the specified color.
        StdDraw.clear(StdDraw.GRAY);
        //we need to initialize the first triangle with a color
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledPolygon(x, y);
        //how many time to iterate the incursion-order seven also looks great
        int order=7;

        recursion(order,x,y);
    }
}
