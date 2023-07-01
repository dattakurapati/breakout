import java.awt.Color;
import java.awt.Graphics;
// import javax.print.DocFlavor.STRING;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
// import java.awt.event.KeyListener;
// import java.awt.event.KeyEvent;
// import java.util.ArrayList;
import java.awt.Font;

public class ScorePanel extends JPanel {
    // instance variables
    private int width, height;
    private Breakout breakout;

    public ScorePanel(int w, int h, Breakout out) {
        width = w;
        height = h;
        breakout = out;
        setSize(width, height);
        setLocation(200, 50);
        Color score_color = new Color(2, 132, 130);
        setBackground(score_color);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

    }
    /**
     * Displays graphics on the JPanel
     *
     * @param g is the declaration of the Graphics class, where all the methods
     *          needed to get graphics onto the JPanel
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        g.drawString("Score: " + breakout.getScore(), 10, 30);
    }
}