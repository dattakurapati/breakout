import java.awt.Graphics;
import java.awt.Rectangle;
// import java.util.Random;
import java.awt.Color;


public class Brick {
    // Declaration of instance variables/objects

    private Breakout breakout;
    private int xPos, yPos;
    private int width, height;
    // Random rand = new Random();
    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public Brick(int x, int y, Breakout out) {
        xPos = x;
        yPos = y;
        width = 40;
        height = 25;
        breakout = out;
        //color = setColor(Color.CYAN);
    }

    public void paint(Graphics g) {
        g.setColor(Color.ORANGE);
        // g.setColor(Color.CYAN);
        g.fillRect(xPos, yPos, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(xPos, yPos, width, height);
    }

    /* -------------------- How to check collision ---------------------- */
    /**
     * To have some type of collusion, the brick needs to have bounds In the class
     * Rectangle, there is a getBounds method
     *
     * @return rectangle's outer most values
     */
    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, width, height);
    }

    /**
     * There also needs to be collision between the brick and the ball the following
     * method will take care of the collision
     * 
     * @return true if the ball intersects the brick
     */
    public boolean collision() {
        return breakout.getBall().getBounds().intersects(getBounds());
    }

    /* ------------------- Getters and Setters -------------------- */
}
