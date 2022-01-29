import edu.princeton.cs.introcs.StdDraw;
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

public class RecursiveSquares {

    /**
     * This method is used to draw a square that the (x,y) is it's center.
     * <p>
     * this method create a filled square with a light gray background and black border.
     * </p>
     * @param x coordinates of the x-axis of the center of the squares.
     * @param y coordinates of the y-axis of the center of the squares.
     * @param size size of the side length of the squares.
     */
    public static void drawSquare(double x, double y, double size) {
        StdDraw.setScale(0.0,2.0);
        //you can change the color using StdDraw. to see what color is available
        //or you can use the setPenColor(int red, int green, int blue) method to creat a color
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, size/2);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, size/2);
    }
    /**
     * this is our main recursive method for creating squares.Plot an order n tree of overlapping gray squares.
     * <p>
     * The ratio of the sizes of the squares is 2.2:1.
     * </p>
     * <p>
     * we use 4 recursion line for creating squares in different locations.
     * </p>
     * @param n order of the recursion
     * @param x coordinates of the x-axis of the center of the first square. we use it later for determine the dimensions of the smaller squares.
     * @param y coordinates of the y-axis of the center of the first square. we use it later for determine the dimensions of the smaller squares.
     * @param size size of the side length of the squares
     */
    public static void draw(int n, double x, double y, double size) {
        if (n == 0) return;

        drawSquare(x, y, size);

        // 2.2 ratio looks good
        double ratio = 2.2;

        // recursively draw 4 smaller squares of order n-1
        draw(n-1, x - size/2, y - size/2, size/ratio);    // lower left
        draw(n-1, x - size/2, y + size/2, size/ratio);    // upper left
        draw(n-1, x + size/2, y - size/2, size/ratio);    // lower right
        draw(n-1, x + size/2, y + size/2, size/ratio);    // upper right
    }

    /**
     * This is the main method.
     * <p>
     * change the int n number to plot an order n recursive squares pattern.
     * </p>
     * <p>
     * because our scale of the table is a 0 to 2 at the x,y axis the center will be (1,1).
     * </p>
     * <p>
     * size length decided by running the program to see which size is better.
     * </p>
     * <p>
     * to change the screen resolution change the CanvasSize by using StdDraw.setCanvasSize(width,height);.
     * </p>
     * @param args Unused.
     */
    public static void main(String[] args) {
        //setting the image pixels
        StdDraw.setCanvasSize(812,720);
        //order of the recursion
        int n = 5;
        double x = 1, y = 1;   // center of square
        double size = 1;       // side length of square
        //pass to our recursion method
        draw(n, x, y, size);
    }

}