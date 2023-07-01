import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Paddle {
    // Declaration of instance variables
    private int xPos, yPos, xa;
    private Breakout breakout;
    private int width, height;
    public int speed;

    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public Paddle(int x, int y, Breakout out) {
        xPos = x;
        yPos = y;
        width = 85;
        height = 10;
        xa = 0;
        speed = 5;
        breakout = out;
    }

    public void paint(Graphics g) {
        Color color = new Color(205,0,26);
        g.setColor(color);
        g.fillRect(xPos, yPos, width, height);
    }

    /**
     * This method will check to see if the paddle can move If the paddle can move
     * it will move
     */
    public void movePaddle() {
        if (xPos + xa > 0 && xPos + xa < breakout.getWidth() - 1 - width) {
            xPos = xPos + xa;
        }
    }

    /* -------------------- How to use keyboard ---------------------- */
    /**
     * In order to use the keyboard, you need to be able to check for keyEvents. A
     * KeyEvent is when the key is released, pressed
     *
     * @param e is the KeyEvent that happens
     */
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        // two keys, move left move right
        // KeyEvent.VK_RIGHT - right arrow
        // KeyEvent.VK_LEFT - left arrow
        // KeyEvent.VK_A - letter a - left
        // KeyEvent.VK_D - letter d - right
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -speed;
        }
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
     * This method will get the top of the bar, so it can interact with the ball
     * object
     *
     * @return the y value for the top of the paddle
     */
    public int getPaddleTop() {
        return yPos;
    }

    /* ------------------- Getters and Setters -------------------- */
}
