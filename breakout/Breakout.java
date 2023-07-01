import java.awt.Color;
import java.awt.Graphics;
// import javax.print.DocFlavor.STRING;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Font;

public class Breakout extends JPanel {
    // instance variables
    private int width, height;
    private int speed;
    private int score;
    private Ball ball;
    private Paddle paddle;
    // private ScorePanel score_new;
    public int row_color = 0;
    int x = 0;
    int y = 0;
    public int count = 0;
    // private Brick brick;
    // private Brick brick2;

    private ArrayList<Brick> bricks;

    // constructor takes in two parameters for the size of the JPanel
    // uses the methods from the JPanel class to create a visible
    // panel for the other objects of the game to appear on
    public Breakout(int w, int h) {
        width = w;
        height = h;

        speed = 3;
        score = 0;

        setSize(width, height);
        setLocation(200, 100);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        ball = new Ball(200, 150, this); // makes an instance of the class
        paddle = new Paddle(50, 465, this);
        // brick = new Brick(0, 0, this);
        // brick2 = new Brick(40, 0, this);

        // listen for the key pressing
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e){

            }

            public void keyPressed(KeyEvent e){
                paddle.keyPressed(e);
            }

            public void keyReleased(KeyEvent e){
                paddle.keyReleased(e);

            }
        });
        // must have to make sure breakout is focused
        setFocusable(true);
        createGrid();
    }

    /**
     * Displays graphics on the JPanel
     *
     * @param g is the declaration of the Graphics class, where all the methods
     *          needed to get graphics onto the JPanel
     */

    @Override
    public void paint(Graphics g) {
        // need to invoke paint in order to see the JPanel
        super.paint(g);
        paddle.paint(g);
        ball.paint(g); // draws the ball on the panel
        Color score_color = new Color(2, 132, 130);
        g.setColor(score_color);
        for (int x = bricks.size() - 1; x >= 0; x--) {
            bricks.get(x).paint(g);
            if (bricks.get(x).collision()) {
                ball.setYA(speed);
                bricks.remove(x);
                score += 10;
            }
        }

        if (score == 500) {
            speed = 0;
            ball.xa = 0;
            ball.ya = 0;
            paddle.speed = 0;
            g.setFont(new Font("Arial", Font.BOLD, 14));
            g.drawString("You won! Good Job!", 150, 240);
        }

        if (score == 100) {
            speed = 5;
        } else if (score == 200) {
            speed = 7;
        } else if (score == 300) {
            speed = 8;
        } else if (speed == 400) {
            speed = 9;
        }

        // brick.paint(g);
        // if (brick.collision()) {
        //     ball.setYA(speed);
        // }
        // brick2.paint(g);
        // if (brick2.collision()) {
        //     ball.setYA(speed);
        // }
    }

    /**
     * This method will get movement in the game
     */
    public void move() {
        paddle.movePaddle();
        ball.moveBall();
    }

    /* -------------------- The Brick Grid -------------------- */
    public ArrayList<Brick> createGrid() {
        bricks = new ArrayList<Brick>();
        for (int z = 1; z <= 50; z++) {
            bricks.add(new Brick(x, y, this));
            count += 1;
            x = x + 40;
            if (z % 10 == 0) {
                x = 0;
                y = y + 25;
            }
        }
        // for (int row = 0; row < 5; row++) {
        //     for (int col = 0;  col < 10; col++){
        //         bricks.add(new Brick((col * 40), (row * 25), this));
        //     }
        // }
        return bricks;
    }

    /* ------------------- Getters and Setters -------------------- */
    public int getSpeed() {
        return speed;
    }

    public Ball getBall() {
        return ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }
    public String getScore() {
        return Integer.toString(score);
    }
}
