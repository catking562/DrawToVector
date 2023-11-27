package taewookim.window;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class Window extends JFrame {

    Graphics gra;

    boolean isdrag = false;
    Vector<Integer> listx = new Vector<>();
    Vector<Integer> listy = new Vector<>();

    public Window() {
        super("abcd");
        this.setLayout(new GridLayout());
        setLocation(500, 500);
        setUndecorated(true);
        setOpacity(0.5f);
        setDefaultCloseOperation(3);
        setSize(500, 500);
        setVisible(true);
        JPanel pane = new JPanel();
        pane.addMouseListener(new MouseListener(this));
        pane.addMouseMotionListener(new MouseListener(this));
        setContentPane(pane);
        pane.setSize(500, 500);
        gra = getGraphics();
        gra.setColor(Color.RED);
    }

    @Override
    public void update(Graphics g) {
        System.out.println("j");
    }
}
