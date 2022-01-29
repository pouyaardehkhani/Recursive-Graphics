import edu.princeton.cs.introcs.StdDraw;
/**
 * @author ardehkhani-mokhtari rad
 * @version 2.0
 * @since 1.0
 * <p>
 * Plots an order n pattern. This is an N-by-N grid of black and white cells, where N = 2^n. An order 0 pattern is
 * a black square. An order n pattern is 4 order n-1 patterns arranged in a 2-by-2 grid, but the bottom right is
 * an order n-1 pattern with the roles of black and white reversed.
 * </p>
 * <p>
 * we use the StdDraw class in edu.princeton library.
 * this library provides a standard drawing class that uses java swing.
 * </p>
 * <p>
 * edu.princeton library developed by university of Princeton and provided by com.googlecode.
 * </p>
 */
public class pattern{
    /**
     * order order pattern with lower left endpoint (xbegin, ybegin) and upper right endpoint (xend, yend).
     *
     * @param order order of the recursion
     * @param xbegin the beginning of the x-axis
     * @param xend the end of the x-axis
     * @param ybegin the beginning of the y-axis
     * @param yend the end of the y-axis
     * @param color for changing the color
     */
    public static void recursion(double xbegin, double ybegin, double xend, double yend, int order, boolean color) {
        double xmid = (xbegin + xend) / 2.0;
        double ymid = (ybegin + yend) / 2.0;

        if (order == 0) {
            if (color){
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            else {
                StdDraw.setPenColor(StdDraw.WHITE);
            }
            StdDraw.filledSquare(xmid, ymid, 0.45);
        }
        else {
            recursion(xbegin,   ybegin,   xmid, ymid, order-1,  color);   // lower left
            recursion(xmid, ymid, xend,   yend,   order-1,  color);   // upper right
            recursion(xbegin,   ymid, xmid, yend,   order-1,  color);   // upper left
            recursion(xmid, ybegin,   xend,   ymid, order-1, !color);   // lower right
        }

    }
    /**
     * This is the main method.
     * <p>
     * change the int order number to plot an order n recursive pattern.
     * </p>
     * <p>
     * to change the screen resolution change the CanvasSize by using StdDraw.setCanvasSize(width,height);.
     * </p>
     * @param args Unused.
     */
    public static void main(String[] args) {
        int order = 5;
        //setting the image pixels
        StdDraw.setCanvasSize(920,720);
        //setting the size of the scale
        StdDraw.setScale(0.0,Math.pow(2, order));
        //Clears the screen to the specified color.
        StdDraw.clear(StdDraw.GRAY);
        recursion(0, 0, Math.pow(2, order), Math.pow(2, order), order, true);
    }

}