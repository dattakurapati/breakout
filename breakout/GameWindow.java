// import java.awt.Color;
import javax.swing.JFrame;
// import javax.swing.JPanel;

public class GameWindow extends JFrame {
    // Declartion of instance variables/objects
    private int width, height;
    private static String title;

    // constructor is first thing called when a new Paddle is created
    // the constructor is where any instance variables are given values
    // initializes instance variables
    public GameWindow(String t, int w, int h) throws InterruptedException {
        // initialize instance variables
        title = t;
        width = w;
        height = h;

        // methods to make a JFrame/window
        setSize(width, height);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // gives absolute positioning
        setResizable(false);

        // Construct a Breakout Panel
        Breakout out = new Breakout(401,500);
        ScorePanel score_new = new ScorePanel(401, 50, out);

        add(out);
        add(score_new);
        setVisible(true);
        // this while loop will be the game loop that will run
        while (true) {
            out.move();
            score_new.repaint();
            out.repaint();
            Thread.sleep(10);
        }
    }
}
