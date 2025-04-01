
import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

public class SimpleGuiExample {

    public static final int MAX_LINES = 10;
    public static final int MAX_W = 900;
    public static final int MAX_H = 600;
    public static final int RAD = 3;
    private Line[] myLines = new Line[MAX_LINES];


    public void drawRandomCircles() {
        Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Circles Example", MAX_W, MAX_H);
        DrawSurface d = gui.getDrawSurface();

        //EDGE CASES, parallel to y & visualy same line

        d.setColor(Color.BLACK);
        Line l1 = new Line(100,100,200,100);
        d.drawLine(100,100,200,100);

        Line l2 = new Line(100,200,200,200);
        d.drawLine(100,200,200,200);

        Line l3 = new Line(100,100,100,200);
        d.drawLine(100,100,100,200);

        Point intersect = l1.intersectionWith(l2);
        if (intersect != null) {
            d.setColor(Color.RED);
            d.fillCircle((int) intersect.getX(), (int) intersect.getY(), 3);
        }

        Point intersect1 = l2.intersectionWith(l3);
        if (intersect1 != null) {
            d.setColor(Color.RED);
            d.fillCircle((int) intersect1.getX(), (int) intersect1.getY(), 3);
        }

        Point intersect2 = l3.intersectionWith(l1);
        if (intersect2 != null) {
            d.setColor(Color.RED);
            d.fillCircle((int) intersect2.getX(), (int) intersect2.getY(), 3);
        }

      /*d.setColor(Color.BLACK);
        Line l1 = new Line(100,100,300,300);
        Line l2 = new Line(200,200,400,400);
        Line l3 = new Line(200,200,400,400);
        d.drawLine(100,100,200,200);
        d.drawLine(200,200,400,400);
        Point intersect = l1.intersectionWith(l2);
        if (intersect != null) {
            d.setColor(Color.RED);
            d.fillCircle((int) intersect.getX(), (int) intersect.getY(), 3);
        }
        Point intersect1 = l1.intersectionWith(l3);
        if (intersect != null) {
            d.setColor(Color.RED);
            d.fillCircle((int) intersect.getX(), (int) intersect.getY(), 3);
        }*/

       /* for (int i = 0; i < MAX_LINES; ++i) {

            int x1 = rand.nextInt(MAX_W) + 1; // get integer in range 1-800
            int x2 = rand.nextInt(MAX_W) + 1; // get integer in range 1-800
            int y1 = rand.nextInt(MAX_H) + 1; // get integer in range 1-600
            int y2 = rand.nextInt(MAX_H) + 1; // get integer in range 1-600

            d.setColor(Color.BLACK);
            d.drawLine(x1, y1, x2, y2);
            myLines[i] = new Line(x1, y1, x2, y2);
            Point middle = myLines[i].middle();

            d.setColor(Color.BLUE);
            d.fillCircle((int) middle.getX(), (int) middle.getY(), RAD);


            for (int j = 0; j < i; ++j) {
                for (int k = 0; k < j; ++k) {
                    if (myLines[i].isIntersecting(myLines[j], myLines[k])
                            && myLines[j].isIntersecting(myLines[k])) {
                        d.setColor(Color.GREEN);
                        Point i1 = myLines[i].intersectionWith(myLines[j]);
                        Point i2 = myLines[j].intersectionWith(myLines[k]);
                        Point i3 = myLines[k].intersectionWith(myLines[i]);

                        d.drawLine((int) i1.getX(), (int) i1.getY(),
                                (int) i2.getX(), (int) i2.getY());
                        d.drawLine((int) i2.getX(), (int) i2.getY(),
                                (int) i3.getX(), (int) i3.getY());
                        d.drawLine((int) i3.getX(), (int) i3.getY(),
                                (int) i1.getX(), (int) i1.getY());
                    }
                }
                Point cross = myLines[i].intersectionWith(myLines[j]);
                if (cross != null) {
                    d.setColor(Color.RED);
                    d.fillCircle((int) cross.getX(), (int) cross.getY(), RAD);
                }
            }



        }
        */gui.show(d);
    }

    public static void main(final String[] args) {
        SimpleGuiExample example = new SimpleGuiExample();
        example.drawRandomCircles();
    }
}