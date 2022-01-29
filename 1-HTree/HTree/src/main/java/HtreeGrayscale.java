//import edu.princeton.cs.introcs.StdDraw;
//import java.util.Random;
//
///**
// * @author ardehkhani-mokhtari rad
// * @version 2.0
// * @since 1.0
// * <p>
// * this class create a recursive graphic image that displays on the screen.
// * </p>
// * <p>
// * we use the StdDraw class in edu.princeton library.
// * this library provides a standard drawing class that uses java swing.
// * </p>
// * <p>
// * edu.princeton library developed by university of Princeton and provided by com.googlecode.
// * </p>
// */
//
//public class HtreeGrayscale {
//
//    /**
//     * initializing Random for random colors.
//     */
//    public static Random rand=new Random();
//    /**
//     * we use this for creating a random RGB color.
//     */
//    public static int Blue=0;
//    /**
//     * we use this for creating a random RGB color.
//     */
//    public static int Green=0;
//    /**
//     * we use this for creating a random RGB color.
//     */
//    public static int Red=0;
//    /**
//     * we use this for determine how many times to change the color.
//     */
//    public static double NumOfColor=0;
//    /**
//     * how many time to recursion. you can change it.
//     */
//    public static int order = 6;
//
//    /**
//     * This method is used to draw a HTree that the (x,y) is it's center.
//     * <p>
//     * we use StdDraw static line method for creating a line from the 2 points in our x,y axis.
//     * </p>
//     * @param x coordinates of the x-axis of the center of the HTrees.
//     * @param y coordinates of the y-axis of the center of the HTrees.
//     * @param size size of the side length of the HTrees.
//     */
//    public static void drawH(double x, double y, double size) {
//
//        // compute the coordinates of the 4 tips of the H
//        double x0 = x - size/2;
//        double x1 = x + size/2;
//        double y0 = y - size/2;
//        double y1 = y + size/2;
//
//        StdDraw.setScale(0.0,2.0);
//
//        // draw the 3 line segments of the H
//        StdDraw.line(x0, y0, x0, y1);    // left  vertical segment of the H
//        StdDraw.line(x1, y0, x1, y1);    // right vertical segment of the H
//        StdDraw.line(x0,  y, x1,  y);    // connect the two vertical segments of the H
//    }
//
//    /**
//     * this is our main recursive method for creating HTrees.plot an order n H-tree, centered on (x, y) of the given side length.
//     * <p>
//     * we use 4 recursion line for creating HTrees in different locations.
//     * </p>
//     * @param n order of the recursion
//     * @param x coordinates of the x-axis of the center of the first HTree. we use it later for determine the dimensions of the smaller HTrees.
//     * @param y coordinates of the y-axis of the center of the first HTree. we use it later for determine the dimensions of the smaller HTrees.
//     * @param size size of the side length of the HTreeS
//     */
//    public static void draw(int n, double x, double y, double size) {
//
//        if (n == 0) return;
//        drawH(x, y, size);
//
//        // compute x- and y-coordinates of the 4 half-size H-trees
//        // we use it to update the coordinates oh the HTrees in the recursion
//        double x0 = x - size/2;
//        double x1 = x + size/2;
//        double y0 = y - size/2;
//        double y1 = y + size/2;
//
//        // recursively draw 4 half-size H-trees of order n-1
//        draw(n-1, x0, y0, size/2);    // lower left  H-tree
//        draw(n-1, x0, y1, size/2);    // upper left  H-tree
//        draw(n-1, x1, y0, size/2);    // lower right H-tree
//        draw(n-1, x1, y1, size/2);    // upper right H-tree
//
//
//    }
//
//    /**
//     * This is the main method.
//     * <p>
//     * because our scale of the table is a 0 to 2 at the x,y axis so the center will be (1,1).
//     * </p>
//     * <p>
//     * size length decided by running the program to see which size is better. but you can change it.
//     * </p>
//     * <p>
//     * to change the screen resolution change the CanvasSize by using StdDraw.setCanvasSize(width,height);.
//     * </p>
//     * @param args Unused.
//     */
//    public static void main(String[] args) {
//        //setting the image pixels
//        StdDraw.setCanvasSize(812,720);
////        int n = 7;
//        NumOfColor=6*4;
//        double x = 1, y = 1;   // center of H-tree
//        double size = 1;       // side length of H-tree - always lower than (length of scale)/2 in here is <=1
//        draw(order, x, y, size);
//    }
//}
